package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import controle.Observador;
import controle.PedidoController;
import model.Pedido;
import model.Produto;

@SuppressWarnings("serial")
public class Janela extends JFrame implements Observador{

	private JButton jbNovo;

	private CardLayout cardLayout;

	private JButton jbAnterior;

	private JButton jbPosterior;

	private JButton jbAdd;

	private JButton jbConcluir;

	private JPanel jpProdutos;

	private JTable jtItens;

	private ItensTableModel itModel;
	
	// Controlador de pedidos
	private PedidoController pedidoController;

	class ItensTableModel extends AbstractTableModel {

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if (columnIndex == 0) {
				return String.class;
			} else {
				return Number.class;
			}
		}
		
		@Override
		public int getRowCount() {
			return pedidoController.getTabelaPedidos().size() + 1;
		}

		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			if (rowIndex == pedidoController.getTabelaPedidos().size()) {
				if (colIndex == 2) {
					return pedidoController.calculaTotalPedido();
				} else {
					return null;
				}
			} else {
				Pedido p = pedidoController.getTabelaPedidos().get(rowIndex);
				switch (colIndex) {
				case 0:
					return p.getProduto().getNome();
				case 1:
					return p.getQtdade();
				default:
					return p.getPcoTotal();
				}
			}
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "Produto";
			case 1:
				return "Qtdade";
			default:
				return "Total";
			}
		}

	}

	class ItensTableRenderer extends DefaultTableCellRenderer {
		
		public ItensTableRenderer() {
			setHorizontalAlignment(JLabel.RIGHT);
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {

			// Cells are by default rendered as a JLabel.
			JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

			if (row == pedidoController.getTabelaPedidos().size()) {
				l.setFont(new Font(l.getFont().getFontName(), Font.BOLD, l.getFont().getSize()));
			}
			return l;

		}
	}

	public Janela() {
		
		// Registramos a janela como observador do controller
		pedidoController = new PedidoController();
		pedidoController.addObservador(this);
		
		setTitle("Prova 1 55PPR");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		initComponents();
		addEventos();
		
		habilitarComponentes(false);

	}

	private void habilitarComponentes(boolean valor) {
		jbNovo.setEnabled(!valor);
		jbAnterior.setEnabled(valor);
		jbPosterior.setEnabled(valor);
		jbAdd.setEnabled(valor);
		jbConcluir.setEnabled(valor);
		jtItens.setEnabled(valor);
		
	}

	private void initComponents() {
		JPanel jp1 = new JPanel();
		jbNovo = new JButton("Novo");

		jp1.add(jbNovo);
		add(jp1, BorderLayout.NORTH);

		JPanel nav = new JPanel();
		nav.setLayout(new BorderLayout());
		nav.setBorder(BorderFactory.createLineBorder(Color.black));

		jpProdutos = new JPanel();		
		
		// Chamando controller para instanciar cada item de produto
		pedidoController.carregaImagemProduto();

		cardLayout = new CardLayout();
		jpProdutos.setLayout(cardLayout);
		jbAnterior = new JButton("<<");
		jbPosterior = new JButton(">>");

		nav.add(jpProdutos, BorderLayout.CENTER);
		JPanel navBotoes = new JPanel();
		navBotoes.add(jbAnterior);
		navBotoes.add(jbPosterior);
		nav.add(navBotoes, BorderLayout.SOUTH);

		add(nav, BorderLayout.WEST);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		// criar a JTable
		jtItens = new JTable();
		itModel = new ItensTableModel();
		jtItens.setModel(itModel);
		jtItens.setDefaultRenderer(Number.class, new ItensTableRenderer());

		jp2.add(new JScrollPane(jtItens), BorderLayout.CENTER);

		JPanel jpBotoes = new JPanel();

		jbAdd = new JButton("Add ao pedido");
		jbConcluir = new JButton("Concluir o pedido");

		jpBotoes.add(jbAdd);
		jpBotoes.add(jbConcluir);

		jp2.add(jpBotoes, BorderLayout.SOUTH);

		add(jp2, BorderLayout.CENTER);

	}

	private void addEventos() {
		jbNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pedidoController.novo();
			}
		});

		jbAnterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pedidoController.anterior();
			}
		});

		jbPosterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pedidoController.posterior();
			}
		});

		jbAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pedidoController.adicionarProdutoPedido();
			}
		});

		jbConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pedidoController.concluirPedido();
			}
		});
	}

	public static void main(String[] args) {
		Janela j = new Janela();
		j.setVisible(true);
	}
	
	@Override
	public void novoPedido() {
		habilitarComponentes(true);		
	}

	@Override
	public void inicializaProduto(Produto p) {
		Icon icon = new ImageIcon("imagens/" + p.getNome() + ".png");
		JLabel jl = new JLabel(icon);
		this.jpProdutos.add(jl);
	}

	@Override
	public void anterior() {
		cardLayout.previous(jpProdutos);
	}

	@Override
	public void posterior() {
		cardLayout.next(jpProdutos);
	}

	@Override
	public void addProdutoPedido() {
		itModel.fireTableDataChanged();
	}

	@Override
	public void concluirPedido() {
		itModel.fireTableDataChanged();
		cardLayout.first(jpProdutos);
		habilitarComponentes(false);
	}
	
}
