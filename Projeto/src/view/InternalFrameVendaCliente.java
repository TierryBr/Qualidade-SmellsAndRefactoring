package view;


import javax.swing.JInternalFrame;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import controller.Comercial;
import error.SisComException;
import model.Cliente;
import model.Estatistica;
import model.ItemCompra;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import model.Vendedor;
import utilitarios.InterfaceUtil;
import utilitarios.LtpLib;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class InternalFrameVendaCliente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fieldPesquisaCliente;
	
	private static JTable tableListaCompra;
	private Comercial comercial = new Comercial();
	private JTable tableCliente;
	private PanelVendedorCenter objVendedor = new PanelVendedorCenter();
	private static JLabel lblValorCompra = new JLabel();
	private static String codigoVendedor;
	private JComboBox opcaoPagamento = new JComboBox();
	private Vendedor modelVendedor = new Vendedor();
	private Cliente modelCliente = new Cliente();
	private int opPagamento = 1;
	/**
	 * Create the frame.
	 */
	public InternalFrameVendaCliente() {
		tableListaCompra = new JTable();
		tableListaCompra.setDefaultEditor(Object.class, null);
		tableCliente = new JTable();
		DefaultTableModel model = (DefaultTableModel) tableCliente.getModel();
		Object[] titleJTable  = {"ID", "Nome", "Email", "Cpf", "Data cadastrada", "Telefone", "Limite Credito"};
		
		for (int i = 0; i < titleJTable.length; i++) {
			model.addColumn(titleJTable[i]);
		}
		
		setClosable(true);
		setBounds(100, 100, 787, 530);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesquisar Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel label = new JLabel("Pesquisa por nome:");
		label.setForeground(new Color(102, 0, 153));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldPesquisaCliente = new JTextField();
		fieldPesquisaCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tableCliente.getModel();
				try {
					
					InterfaceUtil.limparTabela(model);
					Cliente cliente = (Cliente) comercial.consultarCpf(fieldPesquisaCliente.getText(),"cliente");
					Object[] row = new Object[7];
					
					row[0] = cliente.getCodigo();
					row[1] = cliente.getNome();
					row[2] = cliente.getEmail();
					row[3] = cliente.getTelefone();
					row[4] = LtpLib.obterDataFormatada(cliente.getDataCadastrada());
					row[5] = cliente.getCpf();
					row[6] = cliente.getLimiteCredito();
					
					model.addRow(row);
					
				} catch (SisComException a) {
					System.err.println(a.getMessage());
				}
			}
		});
		fieldPesquisaCliente.setColumns(10);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) tableCliente.getModel();
				try {
					
					InterfaceUtil.limparTabela(model);
					Cliente cliente = (Cliente) comercial.consultarCpf(fieldPesquisaCliente.getText(),"cliente");
				
					Object[] row = new Object[7];
					
					row[0] = cliente.getCodigo();
					row[1] = cliente.getNome();
					row[2] = cliente.getEmail();
					row[3] = cliente.getTelefone();
					row[4] = LtpLib.obterDataFormatada(cliente.getDataCadastrada());
					row[5] = cliente.getCpf();
					row[6] = cliente.getLimiteCredito();
					
					model.addRow(row);
					
				} catch (SisComException a) {
					System.err.println(a.getMessage());
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1128, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisaCliente, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnPesquisarCliente, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
							.addGap(14))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 120, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(fieldPesquisaCliente, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(btnPesquisarCliente, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		scrollPane.setViewportView(tableCliente);
		
		
		
	
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPaneListaCompras = new JScrollPane();
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		JLabel lblvalorCompra = new JLabel();
		
//		atualizarValorCompra(lblValorTotalCompra);TODO
		JButton btnFinalizarCompra = new JButton("Finalizar Venda");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fazerVenda();
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(panel,
						    "Vendedor ou Produtos vazio",
						    "Tabelas Vazias",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JComboBox opcaoPagamento = new JComboBox();
		opcaoPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				opPagamento = InterfaceUtil.obterOpcaoComboBox(opcaoPagamento);
			}
		});
		opcaoPagamento.setModel(new DefaultComboBoxModel(new String[] {"1 - Pagamento \u00E1 vista", "2 - Pagamento a prazo"}));
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPaneListaCompras, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(opcaoPagamento, 0, 272, Short.MAX_VALUE)
							.addGap(481))
						.addComponent(lblFormaDePagamento)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblValorTotal, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblValorCompra)
							.addGap(129)
							.addComponent(btnVoltar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnFinalizarCompra, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
							.addGap(351)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneListaCompras, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblFormaDePagamento)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(opcaoPagamento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValorTotal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblValorCompra)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnVoltar)
							.addComponent(btnFinalizarCompra)))
					.addContainerGap(230, Short.MAX_VALUE))
		);
		
		
		
		scrollPaneListaCompras.setViewportView(tableListaCompra);
		
		
		getContentPane().setLayout(groupLayout);
		
		this.setVisible(false);
		
		
		

	}
	/**
	 * 
	 * @param comp Description tabela modelo
	 * @param valorCompras Description valor das compras
	 * @param cpfVendedor Description cpf do vendedor
	 */
	public static void obterTabelaVendas(DefaultTableModel comp,String valorCompras,String cpfVendedor) {
		
		tableListaCompra.setModel(comp);
		
		lblValorCompra.setText(valorCompras);
		
		codigoVendedor = cpfVendedor;
		
		
	}
	public void fazerVenda() {
		DefaultTableModel tableModel = (DefaultTableModel) tableListaCompra.getModel();
		int quantTableComprasRows = tableModel.getRowCount();
		
		try {
			
			String[] objCliente = new String[tableCliente.getColumnCount()-1];
			
			objCliente[0] = tableCliente.getValueAt(0, 0).toString().trim();//ID
			
			objCliente[1] = tableCliente.getValueAt(0, 1).toString().trim();//Nome
			
			
			objCliente[2] = tableCliente.getValueAt(0, 2).toString();//Email
			
			objCliente[3] = tableCliente.getValueAt(0, 3).toString();//Telefone
			
			//Not date
			
			objCliente[4] = tableCliente.getValueAt(0, 5).toString();//CPF
			
			objCliente[5] = tableCliente.getValueAt(0, 6).toString();//Limite credito
			
			
			
			Cliente cliente = new Cliente(Integer.parseInt(objCliente[0]), objCliente[1], objCliente[3], objCliente[2], new Date(), objCliente[4], Double.parseDouble(objCliente[5]));
			
			int[] idProdutos = new int[quantTableComprasRows];
			
			double valorProdutosTotal = Double.parseDouble(lblValorCompra.getText());
			
			int[] quantidadeProdutos = new int [quantTableComprasRows];
			
			double [] valorCompra = new double [quantTableComprasRows];
			
			
			for (int i = 0; i < quantTableComprasRows; i++) {
				idProdutos[i] = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
				
				quantidadeProdutos[i] = Integer.parseInt(tableModel.getValueAt(i, 3).toString().trim());
				
				valorCompra[i] = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
				
				
			}

			
			int k = 0;
			ArrayList<ItemVenda> listaItemVenda = new ArrayList<ItemVenda>();
			
			for (Produto prod : Comercial.getListaProdutos()) {
				
				for (int i = 0; i < idProdutos.length; i++) {
					if(prod.getCodigo() == idProdutos[i]) {
						prod.decrementarProdutoEstoque(quantidadeProdutos[i]);
						ItemVenda itemVenda = new ItemVenda(prod, quantidadeProdutos[k], valorCompra[k]);
						listaItemVenda.add(itemVenda);
					}
				}
			}
			
			int codigo = 0;
			
			if(Comercial.getListaVendas().isEmpty()) {
				codigo = 1;
			}else {
				codigo = Comercial.getListaVendas().size() + 1;
			}
			
			Vendedor vendedor = new Vendedor();
			vendedor = (Vendedor) comercial.consultarCpf(codigoVendedor,"vendedor"); 
			
			
			Venda venda = new Venda(listaItemVenda, codigo, cliente, vendedor, opPagamento, new Date());
			
			Comercial.getListaVendas().add(venda);
			
			//Atuliza Estatistica Venda
			modelVendedor.atualizarEstatistica(new Estatistica(vendedor.getNome(), 1, valorProdutosTotal,new Date()));
			
			modelCliente.atualizarEstatistica(new Estatistica(cliente.getNome(), 1, valorProdutosTotal,new Date()));

			JOptionPane.showMessageDialog(tableListaCompra,
				    "Venda realizada com Sucesso",
				    "Venda",
				    JOptionPane.INFORMATION_MESSAGE,new ImageIcon(PanelFornecedorCenter.class.getResource("/images/success.png")));
			Comercial.setTemporariaListaProdutos(Comercial.getListaProdutos());
			InterfaceUtil.limparTabela((DefaultTableModel) tableCliente.getModel());
			InterfaceUtil.limparTabela((DefaultTableModel) tableListaCompra.getModel());
			
			this.dispose();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
				    "Vendedor ou Produtos vazio",
				    "Tabelas Vazias",
				    JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
