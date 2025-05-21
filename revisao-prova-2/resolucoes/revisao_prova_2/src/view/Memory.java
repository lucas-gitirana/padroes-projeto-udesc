package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Controle;
import control.Observer;

/**
 * The Memory class creates the GUI for the MemoryUI House application.
 */

// Adaptado de https://github.com/moon-tea/Memory/

public class Memory extends JFrame implements Observer {


	private static final long serialVersionUID = 1L;

	private MemoryButton[][] memButtons = new MemoryButton[Controle.ROWS][Controle.COLUMNS];
	private JLabel[][] imgLabel = new JLabel[Controle.ROWS][Controle.COLUMNS];
	private JPanel[][] memPanel = new JPanel[Controle.ROWS][Controle.COLUMNS];

	private ImageIcon versoCarta;
	
	private Controle controle;
	
	private MemoryMenuBar memoryMenuBar;

	public Memory() {
		this.controle = new Controle();
		this.controle.addObserver(this);
		
		versoCarta = new ImageIcon("imagens/Card0.jpg");
		
		for (int i = 0; i < Controle.ROWS; i++) {
			for (int j = 0; j < Controle.COLUMNS; j++) {
				buildMemPanel(i, j);
				add(memPanel[i][j]);
			}
		}

		setTitle("Prova 2 - 2024/1");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(Controle.ROWS, Controle.COLUMNS));

		// Empacotar (organizar) a janela
		pack();

		// add the menu bar to the application
		memoryMenuBar = new MemoryMenuBar();
		setJMenuBar(memoryMenuBar);

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
			
			controle.virouCarta(r, c);
			
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
	public void virouACarta(int r, int c, int numero) {
		ImageIcon tempImg = new ImageIcon("imagens/Card" + numero + ".jpg");
		imgLabel[r][c].setIcon(tempImg);
	}

	@Override
	public void virouAPrimeiraCarta(int r, int c) {
		memButtons[r][c].setEnabled(false);
	}

	@Override
	public void venceuJogo(int r, int c, int numero) {
		ImageIcon tempImg = new ImageIcon("imagens/Card" + numero + ".jpg");
		imgLabel[r][c].setIcon(tempImg);

		JOptionPane.showMessageDialog(null, "Voc\u00EA venceu!");
		dispose();

	}

	@Override
	public void encontrouPar(int r, int c, int numero) {
		ImageIcon tempImg = new ImageIcon("imagens/Card" + numero + ".jpg");
		imgLabel[r][c].setIcon(tempImg);
		JOptionPane.showMessageDialog(null, "Voc\u00EA encontrou um par!");
		memButtons[r][c].setEnabled(false);
	}

	@Override
	public void paresDiferentes(int holdCardRow, int holdCardColumn, int r, int c) {
		JOptionPane.showMessageDialog(null, "Gah! Erradas!");
		memButtons[holdCardRow][holdCardColumn].setEnabled(true);
		ImageIcon tempImg = versoCarta;
		imgLabel[r][c].setIcon(tempImg);
		imgLabel[holdCardRow][holdCardColumn].setIcon(tempImg);
		
	}
	
	private class MemoryMenuBar extends JMenuBar {
		
		private JMenu help = new JMenu("Help");
		private JMenuItem helpItem = new JMenuItem("Help me, please");
		private JMenu visitor = new JMenu("Visitor");
		
		private JMenuItem contarPares = new JMenuItem("Contar pares virados");
		private JMenuItem trocarCartas = new JMenuItem("Usar outras imagens");
		
		public MemoryMenuBar() {

			helpItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog helpWindow = new JDialog();
					helpWindow.setSize(450, 100);
					helpWindow.getContentPane().add(new JLabel("Ainda bem que tu estudou... \ue007 ... Boa sorte em implementar o padr\u00e3o!!"));
					helpWindow.setLocationRelativeTo(null);
					helpWindow.setModal(true);
					helpWindow.setVisible(true);
				}
			});
			
			contarPares.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controle.contouPares();
					
				}});
			
			trocarCartas.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controle.trocouImagens();
				}});
			
			help.add(helpItem);
			
			visitor.add(contarPares);
			visitor.add(trocarCartas);
			
			add(help);
			add(visitor);;
			
		}
	}
	
	class HelpPanel extends JEditorPane {
		public HelpPanel() {
			super("Help", "Ainda bem que tu estudou... boa sorte em implementar o padr\ue007o!!");
		}
	}

	@Override
	public void exibeContagem(int paresCorretos) {
		JOptionPane.showMessageDialog(memoryMenuBar, "Foram encontrados " +paresCorretos+ " pares corretos.");
	}


}