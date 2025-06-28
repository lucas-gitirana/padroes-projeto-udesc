package command4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class PaintFixo extends JFrame implements ActionListener {

	private JPanel canvas;
	private JToolBar toolbar;

	private List<String> desenhos = new ArrayList<>();
	private Random sorteio = new Random();
	
	public PaintFixo() {
		setTitle("Paint Fixo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		toolbar = new JToolBar("Comandos");
		toolbar.setFloatable(false);
		try {
			criarBotoes();
			
			add(toolbar, BorderLayout.NORTH);
			
			canvas = new JPanel() {
			  public void paintComponent(Graphics g) {
				  	super.paintComponent(g);
				   
	
				    for (String desenho:desenhos) {
				    	String[] d = desenho.split(",");
			    		int x = Integer.parseInt(d[1]);
			    		int y = Integer.parseInt(d[2]);
			    		
			    		g.setColor(new Color(Integer.parseInt(d[3])));
				    	if (d[0].equals("quad")) {
						    g.fillRect(x, y, 50, 50);
				    	} else {
				    		g.fillOval(x, y, 50, 50);
				    	}
				    }
				  
				  }
	
			};
			
			add(canvas, BorderLayout.CENTER);
			
			pack();
	
			setExtendedState(JFrame.MAXIMIZED_BOTH);
	//		setLocationRelativeTo(null);
			setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	private void criarBotoes() throws Exception {
		Path arquivo = Path.of("botoes.json");
		String str = Files.readString(arquivo);
		JSONObject json = new JSONObject(str);
		
		JSONArray botoes = json.getJSONArray("botoes");
		for (int i=0; i<botoes.length(); i++) {
			JSONObject botao = botoes.getJSONObject(i);
			String tipo = botao.getString("type");
			switch (tipo) {
				case "Undo": 
					toolbar.add(criarBotao("undo", "desfazer", "Desfazer"));
					break;
				case "Redo":
					toolbar.add(criarBotao("redo", "refazer", "Refazer"));
					break;
				case "Circ":
					toolbar.add(criarBotao("circ", "circulo", "Desenhar círculo"));
					break;
				case "Quad":
					toolbar.add(criarBotao("quad", "quadrado", "Desenhar quadrado"));
					break;
				case "separador":
					toolbar.addSeparator();
			}
		}
	}

	private JButton criarBotao(String nomeImage, String actionCommand, String tooltip) {

		String imgLocation = "imagens/" + nomeImage + ".gif";
		URL imageURL = PaintFixo.class.getResource(imgLocation);

		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.addActionListener(this);
		button.setToolTipText(tooltip);
		button.setIcon(new ImageIcon(imageURL));

		return button;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PaintFixo();
			}
		});
	}
	
	private Color[] cores = new Color[]{Color.BLACK,Color.BLUE,Color.YELLOW,Color.GREEN, Color.RED, Color.WHITE};

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		
		if (action.equals("quadrado")) {
		 	desenhos.add("quad,"+sorteio.nextInt(getWidth()-100)+","+sorteio.nextInt(getHeight()-100)+","+cores[sorteio.nextInt(cores.length)].getRGB());
		} else 
			if (action.equals("circulo")) {
			 	desenhos.add("circ,"+sorteio.nextInt(getWidth()-100)+","+sorteio.nextInt(getHeight()-100)+","+cores[sorteio.nextInt(cores.length)].getRGB());
				
			}
		canvas.repaint();
	}
	

}