package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controle.CardController;
import controle.Observer;
import model.Card;

/**
 * The Memory class creates the GUI for the MemoryUI House application.
 */

// Adaptado de https://github.com/moon-tea/Memory/

public class Memory extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	// constantes: nao tem problema mante-las publicas
	public static final int ROWS = CardController.ROWS;
	public static final int COLUMNS = CardController.COLUMNS;

	private MemoryButton[][] memButtons = new MemoryButton[ROWS][COLUMNS];
	private JLabel[][] imgLabel = new JLabel[ROWS][COLUMNS];
	private JPanel[][] memPanel = new JPanel[ROWS][COLUMNS];

	private ImageIcon versoCarta;
	
	private CardController cardController;

	public Memory() {
		
		//Instanciando construtor
		cardController = new CardController();
		cardController.addObserver(this);
		
		versoCarta = new ImageIcon("imagens/Card0.jpg");

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				buildMemPanel(i, j);
				add(memPanel[i][j]);
			}
		}

		setTitle("Prova 1 - 2024/1");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(ROWS, COLUMNS));

		// Empacotar (organizar) a janela
		pack();

		setLocationRelativeTo(null);
		setResizable(false);

	}

	// criar o visual do jogo de memoria
	private void buildMemPanel(int _i, int _j) {
		memPanel[_i][_j] = new JPanel();

		memPanel[_i][_j].setLayout(new GridLayout(2, 1));

		memButtons[_i][_j] = new MemoryButton(_i, _j);

		memButtons[_i][_j].addActionListener(new FlipListener());
		memButtons[_i][_j].setText("Virar!");

		imgLabel[_i][_j] = new JLabel(versoCarta);

		memPanel[_i][_j].setBorder(BorderFactory.createTitledBorder(" "));

		memPanel[_i][_j].add(imgLabel[_i][_j]);
		memPanel[_i][_j].add(memButtons[_i][_j]);
	}

	private class FlipListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			MemoryButton clicked = (MemoryButton) obj;
			int r = clicked.getRow();
			int c = clicked.getColumn();
			
			ImageIcon tempImg = new ImageIcon("imagens/Card" + cardController.getCardImgNum(r, c) + ".jpg");
			imgLabel[r][c].setIcon(tempImg);

			cardController.compare(r, c);
		}
	}

	class MemoryButton extends JButton {

		private static final long serialVersionUID = 1L;

		private int row;
		private int column;

		public MemoryButton(int _i, int _j) {
			this.row = _i;
			this.column = _j;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}
	}

	public static void main(String[] args) {
		Memory m = new Memory();
		m.setVisible(true);
	}

	@Override
	public void acertou(int r, int c) {
		JOptionPane.showMessageDialog(null, "Voc\u00EA encontrou um par!");
		memButtons[r][c].setEnabled(false);
	}

	@Override
	public void errou(int r, int c, int holdCardRow, int holdCardColumn) {
		JOptionPane.showMessageDialog(null, "Gah! Erradas!");
		memButtons[holdCardRow][holdCardColumn].setEnabled(true);
		imgLabel[r][c].setIcon(versoCarta);
		imgLabel[holdCardRow][holdCardColumn].setIcon(versoCarta);
	}

	@Override
	public void venceu() {
		JOptionPane.showMessageDialog(null, "Voc\u00EA venceu!");
		dispose();
	}

	@Override
	public void bloqueiaCarta(int holdCardRow, int holdCardColumn) {
		memButtons[holdCardRow][holdCardColumn].setEnabled(false);
	}
}