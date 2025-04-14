package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import controle.GameController;
import controle.Observador;
import model.Jogada;


public class Game implements Observador {
	// 0 - pedra 1 - papel 2 - tesoura
	
	private GameController gameController;
	
	public Game() {
		this.gameController = new GameController();
		this.gameController.addObservador(this);
	}
	
	public void panel_introduction() { // give the instruction to the game
		String info_text = "Pedra, papel e tesoura!  Esse \u00e9 um jogo muito simples.\nEscolha sua m\u00E3o. Pedra vence tesoura, tesoura vence papel\ne papel enrola a pedra. Sim, papel vence a pedra.";
		JOptionPane.showMessageDialog(null, info_text, "Como jogar!", 1);
	}

	public void panel_game() {
		
		// Instaciando componentes de tela
		JFrame frame_main = new JFrame("Pedra, papel e tesoura");
		frame_main.getContentPane().setBackground(Color.BLACK);
		Container panel_main = frame_main.getContentPane();
		panel_main.setLayout(null);

		String[] icon_path = new String[3];
		int[] icon_bound = new int[3];

		for (int i = 0; i <= 2; i++) {
			icon_path[i] = System.getProperty("user.dir") + "/images/" + i + ".png";
			icon_bound[i] = 40 + 250 * i;
		}
		JLabel title_main = new JLabel("Pedra Papel Tesoura");
		title_main.setBounds(240, 20, 400, 40);
		title_main.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
		title_main.setForeground(Color.WHITE);

		JButton btn_rock = new JButton(" ", new ImageIcon(icon_path[0]));
		btn_rock.setBackground(Color.red);
		btn_rock.setBounds(icon_bound[0], 100, 200, 250);

		JButton btn_paper = new JButton(" ", new ImageIcon(icon_path[1]));
		btn_paper.setBackground(Color.yellow);
		btn_paper.setBounds(icon_bound[1], 100, 200, 250);

		JButton btn_scissors = new JButton(" ", new ImageIcon(icon_path[2]));
		btn_scissors.setBackground(Color.blue);
		btn_scissors.setBounds(icon_bound[2], 100, 200, 250);

		JToggleButton toggle_button = new JToggleButton("Modo claro");
		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					frame_main.getContentPane().setBackground(Color.WHITE);
					title_main.setForeground(Color.BLACK);
					toggle_button.setText("Modo escuro");
				} else {
					frame_main.getContentPane().setBackground(Color.BLACK);
					title_main.setForeground(Color.WHITE);
					toggle_button.setText("Modo claro");
					toggle_button.setBackground(Color.white);
				}
			}
		};
		toggle_button.addItemListener(itemListener);
		toggle_button.setBounds(570, 20, 150, 40);

		panel_main.add(toggle_button);
		panel_main.add(btn_rock);
		panel_main.add(btn_scissors);
		panel_main.add(btn_paper);
		panel_main.add(title_main);
		
		btn_rock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gameController.computeWinner(1);
			}
		});

		btn_paper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gameController.computeWinner(2);
			}
		});

		btn_scissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gameController.computeWinner(3);
			}
		});
		frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_main.setSize(800, 400);
		frame_main.setVisible(true);
	}
	
	public void displayResult(String label_choice, int choice_human, int choice_computer) {
		
		String label_winner = getWinner();
		
		JFrame score_frame = new JFrame("Pedra, papel e tesoura");
		score_frame.getContentPane().setBackground(Color.cyan);
		Container score_panel = score_frame.getContentPane();
		score_panel.setLayout(null);

		JLabel label_result = new JLabel(label_choice + label_winner);
		label_result.setBounds(150, 10, 300, 35);
		score_panel.add(label_result);

		JLabel label_title_human = new JLabel("Sua escolha");
		label_title_human.setBounds(50, 35, 150, 35);
		score_panel.add(label_title_human);

		JLabel label_title_computer = new JLabel("Escolha do computador");
		label_title_computer.setBounds(350, 35, 150, 35);
		score_panel.add(label_title_computer);

		JLabel image_human = new JLabel(
				new ImageIcon(System.getProperty("user.dir") + "/images/" + (choice_human - 1) + ".png"));
		image_human.setBounds(10, 100, 200, 250);
		score_panel.add(image_human);

		JLabel image_computer = new JLabel(
				new ImageIcon(System.getProperty("user.dir") + "/images/" + (choice_computer - 1) + "c.png"));
		image_computer.setBounds(300, 100, 200, 250);
		score_panel.add(image_computer);

		JLabel label_score1 = new JLabel("Vit\u00f3rias / Rodadas : " + gameController.getScore_win() + "/" + gameController.getJogadas().size());
		label_score1.setBounds(175, 200, 150, 350);
		score_panel.add(label_score1);

		JLabel label_score2 = new JLabel("Empate: " + gameController.getScore_tie());
		label_score2.setBounds(175, 210, 125, 370);
		score_panel.add(label_score2);

		JButton btn_ok = new JButton("OK");
		btn_ok.setBackground(Color.green);
		btn_ok.setBounds(410, 360, 100, 50);
		score_panel.add(btn_ok);

		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				score_frame.dispose();
			}
		});

		score_frame.setSize(600, 450);
		score_frame.setVisible(true);
	}
	
	public String getWinner() {
		String label_winner = "";
		int winner = gameController.getJogadorVencedor(); 
		if (winner == 1) {
			label_winner = "   Voc\u00ea venceu!";
		} else if (winner == 2) {
			label_winner = "   Ningu\u00e9m venceu!";
		} else {
			label_winner = "   Computador venceu!";
		}
		
		return label_winner;
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.panel_game();
		g.panel_introduction();
	}

	@Override
	public void venceuPedra(int choice_human, int choice_computer) {
		String label_choice = "Pedra venceu!";
		displayResult(label_choice, choice_human, choice_computer);
	}

	@Override
	public void venceuPapel(int choice_human, int choice_computer) {
		String label_choice = "Papel venceu!";
		displayResult(label_choice, choice_human, choice_computer);
	}

	@Override
	public void venceuTesoura(int choice_human, int choice_computer) {
		String label_choice = "Tesoura venceu!";
		displayResult(label_choice, choice_human, choice_computer);
	}

	@Override
	public void empate(int choice_human, int choice_computer) {
		String label_choice = "Empate!";
		displayResult(label_choice, choice_human, choice_computer);
	}

}