package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DropMode;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ImageIcon;
import java.awt.Cursor;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.Comercial;
import error.SisComException;

import model.Estatistica;
import model.Produto;
import model.Venda;
import model.Vendedor;
import utilitarios.CustomTransferHandler;
import utilitarios.InterfaceUtil;
import utilitarios.LtpLib;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PanelVendedorCenter extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Comercial comercial = new Comercial();
	private JTextField fieldNome;
	private JTextField fieldTelefone;
	private JTextField fieldEmail;
	private JTextField fieldCpf;
	private JTextField fieldMetaMensal;
	private JTextField fieldPesquisar;
	private JTable tableConsulta;
	private JTextField fieldPesquisaVendedor;
	private JTextField fieldPesquisaProduto;
	private JTable tablePesquisaVendedor;
	private JTable tableProdutos;
	public static JTable tableListaVendas;
	public static JLabel lblValorTotalCompra = new JLabel();
	private JTextField fieldDataInicio;
	private JTextField fieldDataFinal;
	private JTextField fieldDataInicioVendas;
	private JTextField fieldDataFinalVenda;
	private JTable tableEstatistica;
	
	
	/**
	 * Create the panel.
	 */
	public PanelVendedorCenter() {
		tablePesquisaVendedor = new JTable();
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
					.addGap(13))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addGap(9))
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tableProdutos.setModel(mostraTabelaDeProdutosTotal(Comercial.getTemporariaListaProdutos()));
			}
		});
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
					.addGap(6))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
					.addGap(8))
		);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(new Rectangle(100, 100, 0, 0));
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de  Vendedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 102)));
		tabbedPane.addTab("Cadastro", new ImageIcon(PanelVendedorCenter.class.getResource("/images/salesman-32.png")), panelCadastro, null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldNome = new JTextField();
		fieldNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldTelefone = new JTextField();
		fieldTelefone.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		fieldCpf = new JTextField();
		fieldCpf.setColumns(10);
		
		fieldMetaMensal = new JTextField();
		fieldMetaMensal.setColumns(10);
		
		JLabel lblMetamensal = new JLabel("metaMensal:");
		lblMetamensal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int codigo = 0;
					
					if(Comercial.getListaPessoas().isEmpty()) {
						codigo = 1;
					}else {
						codigo = Comercial.getListaPessoas().size() + 1;
					}
					
					String nome = fieldNome.getText();
					String telefone = fieldTelefone.getText();
					String email = fieldEmail.getText();
					Date dataCadastrada = new Date();
					String cpf = fieldCpf.getText();
					double metaMensal = Double.parseDouble(fieldMetaMensal.getText());
					
					
					Vendedor vendedor = new Vendedor(codigo, nome, telefone, email, dataCadastrada, cpf, metaMensal);
					Comercial.getListaPessoas().add(vendedor);
					
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					
					tableConsulta.setModel(mostraTabelaDeVendedor());
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFocusable(false);
		btnCadastrar.setBorder(BorderFactory.createEmptyBorder());
		btnCadastrar.setBackground(new Color(86, 35, 130));
		
		
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fieldNome, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fieldTelefone, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)))
							.addGap(15))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldEmail, GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
								.addComponent(fieldCpf, GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblMetamensal, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
									.addGap(370))
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(fieldMetaMensal, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
									.addContainerGap())))))
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNome))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addContainerGap()
							.addComponent(fieldNome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGap(22)
							.addComponent(lblTelefone))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGap(20)
							.addComponent(fieldTelefone, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblEmail)
							.addGap(27)
							.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldCpf, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMetamensal, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldMetaMensal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(391, Short.MAX_VALUE))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel panelConsulta = new JPanel();
		panelConsulta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consultar Vendedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		tabbedPane.addTab("Consulta", new ImageIcon(PanelVendedorCenter.class.getResource("/images/search2.png")), panelConsulta, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JButton btnDeletar = new JButton("Deletar");
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableConsulta.setModel(mostraTabelaDeVendedor());
			}
		});
		GroupLayout gl_panelAcoes = new GroupLayout(panelAcoes);
		gl_panelAcoes.setHorizontalGroup(
			gl_panelAcoes.createParallelGroup(Alignment.LEADING)
				.addGap(0, 832, Short.MAX_VALUE)
				.addGroup(gl_panelAcoes.createSequentialGroup()
					.addGap(174)
					.addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(btnListarTodos, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addGap(181))
		);
		gl_panelAcoes.setVerticalGroup(
			gl_panelAcoes.createParallelGroup(Alignment.LEADING)
				.addGap(0, 67, Short.MAX_VALUE)
				.addGroup(gl_panelAcoes.createSequentialGroup()
					.addGroup(gl_panelAcoes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(btnListarTodos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelAcoes.setLayout(gl_panelAcoes);
		
		JLabel lblPesquisa = new JLabel("Pesquisa por cpf:");
		lblPesquisa.setForeground(new Color(102, 0, 153));
		lblPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldPesquisar = new JTextField();
		fieldPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
				try {
					
					InterfaceUtil.limparTabela(model);
					Vendedor vendedor = (Vendedor) comercial.consultarCpf(fieldPesquisar.getText(),"vendedor");
					
					Object[] row = new Object[7];
					
					row[0] = vendedor.getCodigo();
					row[1] = vendedor.getNome();
					row[2] = vendedor.getEmail();
					row[3] = vendedor.getCpf();
					row[4] = LtpLib.obterDataFormatada(vendedor.getDataCadastrada());
					row[5] = vendedor.getTelefone();
					row[6] = vendedor.getMetaMensal();
					
					model.addRow(row);
					
				} catch (SisComException a) {
					System.err.println(a.getMessage());
				}
			}
		});
		fieldPesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tableConsulta.setModel(mostraTabelaDeVendedorUnico(fieldPesquisar.getText()));
			}
		});
		GroupLayout gl_panelConsulta = new GroupLayout(panelConsulta);
		gl_panelConsulta.setHorizontalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(panelAcoes, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(lblPesquisa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisar, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addGap(63))))
		);
		gl_panelConsulta.setVerticalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGap(0, 610, Short.MAX_VALUE)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisa)
						.addComponent(fieldPesquisar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAcoes, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
		);
		
		tableConsulta = new JTable();
		
		DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
		Object[] titleJTable  = {"Código", "Nome", "Email", "Cpf", "Data Cadastrada","Meta Mensal"};
		
		for (int i = 0; i < titleJTable.length; i++) {
			model.addColumn(titleJTable[i]);
		}
		scrollPane.setViewportView(tableConsulta);
		panelConsulta.setLayout(gl_panelConsulta);
		
		JPanel panelVenda = new JPanel();
		panelVenda.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Venda", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		tabbedPane.addTab("Venda", new ImageIcon(PanelVendedorCenter.class.getResource("/images/cart-32.png")), panelVenda, null);
		
		JPanel panelPesquisaVendedor = new JPanel();
		panelPesquisaVendedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesquisa de Vendedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel lblPesquisaPorCpf = new JLabel("Pesquisa por Cpf:");
		lblPesquisaPorCpf.setForeground(new Color(102, 0, 153));
		lblPesquisaPorCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldPesquisaVendedor = new JTextField();
		fieldPesquisaVendedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tablePesquisaVendedor.setModel(mostraTabelaDeVendedorUnico(fieldPesquisaVendedor.getText()));
			}
		});
		fieldPesquisaVendedor.setColumns(10);
		
		JButton btnPesquisarVendedor = new JButton("Pesquisar");
		btnPesquisarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablePesquisaVendedor.setModel(mostraTabelaDeVendedorUnico(fieldPesquisaVendedor.getText()));
			}
		});
		
		JScrollPane scrollPaneTableVendedor = new JScrollPane();
		GroupLayout gl_panelPesquisaVendedor = new GroupLayout(panelPesquisaVendedor);
		gl_panelPesquisaVendedor.setHorizontalGroup(
			gl_panelPesquisaVendedor.createParallelGroup(Alignment.LEADING)
				.addGap(0, 865, Short.MAX_VALUE)
				.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPesquisaVendedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
							.addComponent(lblPesquisaPorCpf, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisaVendedor, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnPesquisarVendedor, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
							.addComponent(scrollPaneTableVendedor, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
							.addGap(14))))
		);
		gl_panelPesquisaVendedor.setVerticalGroup(
			gl_panelPesquisaVendedor.createParallelGroup(Alignment.LEADING)
				.addGap(0, 120, Short.MAX_VALUE)
				.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
					.addGroup(gl_panelPesquisaVendedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelPesquisaVendedor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
									.addGap(2)
									.addComponent(fieldPesquisaVendedor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
									.addGap(1)
									.addComponent(btnPesquisarVendedor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelPesquisaVendedor.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPesquisaPorCpf, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPaneTableVendedor, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		
		scrollPaneTableVendedor.setViewportView(tablePesquisaVendedor);
		panelPesquisaVendedor.setLayout(gl_panelPesquisaVendedor);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Painel de produtos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel label_1 = new JLabel("Pesquisar");
		
		fieldPesquisaProduto = new JTextField();
		fieldPesquisaProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
								
					tableProdutos.setModel(mostraTabelaDeProdutosTotal(Comercial.procurarProdutoNome(fieldPesquisaProduto.getText())));
					 
				} catch(NumberFormatException f){
			          System.out.println(f.getMessage());
			          System.out.println("Campo Pesquisa Produto Vazio");
		        }
				
			}
		});
		fieldPesquisaProduto.setToolTipText("Pesquisar Produto por parte do nome");
		fieldPesquisaProduto.setColumns(10);
		
		JScrollPane scrollPaneProdutos = new JScrollPane();
		GroupLayout gl_panelProdutos = new GroupLayout(panelProdutos);
		gl_panelProdutos.setHorizontalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelProdutos.createSequentialGroup()
					.addGroup(gl_panelProdutos.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPaneProdutos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addGroup(gl_panelProdutos.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisaProduto, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelProdutos.setVerticalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProdutos.createSequentialGroup()
					.addGroup(gl_panelProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(fieldPesquisaProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneProdutos, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		
		//Tabela Protudos
		tableProdutos = new JTable();
		tableProdutos.setModel(mostraTabelaDeProdutosTotal(Comercial.getListaProdutos()));
		tableProdutos.setDragEnabled(true);
		tableProdutos.setTransferHandler(new CustomTransferHandler());
		tableProdutos.setDefaultEditor(Object.class, null);
		
		scrollPaneProdutos.setViewportView(tableProdutos);
		panelProdutos.setLayout(gl_panelProdutos);
		
		JPanel panelListaVendas = new JPanel();
		panelListaVendas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Vendas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		
		JLabel lblValorTotalCompra = new JLabel("0,00");
		
		JButton btnComprar = new JButton("Vender");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					InternalFrameVendaCliente.obterTabelaVendas((DefaultTableModel) tableListaVendas.getModel(),
							lblValorTotalCompra.getText(),
							tablePesquisaVendedor.getModel().getValueAt(0, 4).toString());
					
					InterfaceBase.frameCliente.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(panelListaVendas,
						    "Vendedor ou Produtos vazio",
						    "Tabelas Vazias",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JScrollPane scrollPaneListaVendas = new JScrollPane();
		
		JPanel panelIconVenda = new JPanel();
		
		JLabel label_4 = new JLabel("");
		panelIconVenda.add(label_4);
		GroupLayout gl_panelListaVendas = new GroupLayout(panelListaVendas);
		gl_panelListaVendas.setHorizontalGroup(
			gl_panelListaVendas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListaVendas.createSequentialGroup()
					.addComponent(lblValorTotal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblValorTotalCompra)
					.addGap(286)
					.addComponent(btnComprar, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(gl_panelListaVendas.createSequentialGroup()
					.addGap(185)
					.addComponent(panelIconVenda, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(187))
				.addGroup(gl_panelListaVendas.createSequentialGroup()
					.addComponent(scrollPaneListaVendas, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelListaVendas.setVerticalGroup(
			gl_panelListaVendas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListaVendas.createSequentialGroup()
					.addComponent(panelIconVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneListaVendas, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelListaVendas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorTotal)
						.addComponent(lblValorTotalCompra)
						.addComponent(btnComprar))
					.addGap(21))
		);
		
		tableListaVendas = new JTable();
		
		tableListaVendas.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				calcularValorTotalProdutos(lblValorTotalCompra);
			
			}
		});
	
	
		
		tableListaVendas.setTransferHandler(new CustomTransferHandler());
		
		tableListaVendas.setSurrendersFocusOnKeystroke(true);
		
		tableListaVendas.setColumnSelectionAllowed(true);
		tableListaVendas.setDropMode(DropMode.INSERT_ROWS);
		tableListaVendas.setFillsViewportHeight(true);
		
		tableListaVendas.setModel(new DefaultTableModel(
				null,
				new String[] {"Código","Nome", "Preço Unitário","Quantidade"}
			));
		
		TableColumn tableColumn = tableListaVendas.getColumnModel().getColumn(3);
		
		
		JComboBox<Integer> comboBoxQuantProd = new JComboBox<Integer>();
		int[] valuesQuantProd = {10,20,30,40,50};
		
		for (int i = 0; i < valuesQuantProd.length; i++) {
			comboBoxQuantProd.addItem(valuesQuantProd[i]);
		}
		
		comboBoxQuantProd.setSelectedIndex(0);
		
		tableColumn.setCellEditor(new DefaultCellEditor(comboBoxQuantProd));
		
		scrollPaneListaVendas.setViewportView(tableListaVendas);
		panelListaVendas.setLayout(gl_panelListaVendas);
		GroupLayout gl_panelVenda = new GroupLayout(panelVenda);
		gl_panelVenda.setHorizontalGroup(
			gl_panelVenda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVenda.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVenda.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelPesquisaVendedor, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
						.addGroup(gl_panelVenda.createSequentialGroup()
							.addComponent(panelProdutos, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panelListaVendas, GroupLayout.PREFERRED_SIZE, 561, Short.MAX_VALUE)
							.addGap(9)))
					.addContainerGap())
		);
		gl_panelVenda.setVerticalGroup(
			gl_panelVenda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVenda.createSequentialGroup()
					.addComponent(panelPesquisaVendedor, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelVenda.createParallelGroup(Alignment.LEADING)
						.addComponent(panelProdutos, 0, 0, Short.MAX_VALUE)
						.addComponent(panelListaVendas, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelVenda.setLayout(gl_panelVenda);
		
		JPanel panelEstatistica = new JPanel();
		panelEstatistica.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estat\u00EDstica de Vendas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		tabbedPane.addTab("Estat\u00EDstica de vendas", new ImageIcon(PanelVendedorCenter.class.getResource("/images/statistic.png")), panelEstatistica, null);
		
		JPanel panelAcoesEstatistica = new JPanel();
		panelAcoesEstatistica.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel lblPeriodo = new JLabel("Per\u00EDodo");
		
		fieldDataInicio = new JTextField();
		fieldDataInicio.setColumns(10);
		
		JLabel lbla = new JLabel("a");
		
		fieldDataFinal = new JTextField();
		fieldDataFinal.setColumns(10);
		
		JButton btnListarVendas = new JButton("Listar Vendas de Vendedor");
		btnListarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Date dataInicio = LtpLib.obterStringParaData(fieldDataInicio.getText());
					Date dataFinal = LtpLib.obterStringParaData(fieldDataFinal.getText());
					
					tableEstatistica.setModel(mostraTabelaVendas(dataInicio,dataFinal));
				
					
				} catch (SisComException e) {
					JOptionPane.showMessageDialog(tableEstatistica,
						    "Preencha as datas de início e Fim",
						    "Datas Vazias",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblPeriodoEstatistica = new JLabel("Per\u00EDodo");
		
		fieldDataInicioVendas = new JTextField();
		fieldDataInicioVendas.setColumns(10);
		
		JLabel lblA = new JLabel("a");
		
		fieldDataFinalVenda = new JTextField();
		fieldDataFinalVenda.setColumns(10);
		
		JButton btnListarEstatistica = new JButton("Listar todas estat\u00EDsticas");
		btnListarEstatistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Date dataInicioEstatistica = LtpLib.obterStringParaData(fieldDataInicioVendas.getText());
					Date dataFinalEstatistica = LtpLib.obterStringParaData(fieldDataFinalVenda.getText());
					
					tableEstatistica.setModel(mostraTabelaEstatistica(dataInicioEstatistica,dataFinalEstatistica));
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(tableEstatistica,
						    "Preencha as datas de início e Fim",
						    "Datas Vazias",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GroupLayout gl_panelAcoesEstatistica = new GroupLayout(panelAcoesEstatistica);
		gl_panelAcoesEstatistica.setHorizontalGroup(
			gl_panelAcoesEstatistica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPeriodo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addComponent(fieldDataInicio, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lbla, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldDataFinal, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
						.addComponent(btnListarVendas, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
					.addGap(34)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPeriodoEstatistica, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addComponent(fieldDataInicioVendas, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldDataFinalVenda, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
						.addComponent(btnListarEstatistica, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAcoesEstatistica.setVerticalGroup(
			gl_panelAcoesEstatistica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeriodo)
						.addComponent(fieldDataInicio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldDataFinal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbla))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnListarVendas, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelAcoesEstatistica.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addGap(7)
							.addComponent(lblPeriodoEstatistica))
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.BASELINE)
								.addComponent(fieldDataFinalVenda, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblA)
								.addComponent(fieldDataInicioVendas, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnListarEstatistica, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		panelAcoesEstatistica.setLayout(gl_panelAcoesEstatistica);
		
		JScrollPane scrollPaneEstatistica = new JScrollPane();
		GroupLayout gl_panelEstatistica = new GroupLayout(panelEstatistica);
		gl_panelEstatistica.setHorizontalGroup(
			gl_panelEstatistica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstatistica.createSequentialGroup()
					.addGroup(gl_panelEstatistica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEstatistica.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelAcoesEstatistica, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE))
						.addComponent(scrollPaneEstatistica, GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelEstatistica.setVerticalGroup(
			gl_panelEstatistica.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelEstatistica.createSequentialGroup()
					.addGap(28)
					.addComponent(panelAcoesEstatistica, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPaneEstatistica, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		
		
		tableEstatistica = new JTable();
		tableEstatistica.setFillsViewportHeight(true);
		scrollPaneEstatistica.setViewportView(tableEstatistica);
		panelEstatistica.setLayout(gl_panelEstatistica);
		panel.setLayout(gl_panel);
		
		setLayout(groupLayout);

	}
	
	public DefaultTableModel mostraTabelaDeProdutosTotal(ArrayList<Produto> listaProdutos) {
		
		Object[] titleRow = {"Código","Nome", "Preço Unitário","Quantidade"};
		Object[][] data = new Object[listaProdutos.size()][titleRow.length];
		
		for (int i = 0; i < listaProdutos.size(); i++) {
			
			
			data[i][0] = listaProdutos.get(i).getCodigo();
			data[i][1] = listaProdutos.get(i).getNome();
			data[i][2] = listaProdutos.get(i).getPrecoUnitario();
//			data[i][3] = listaProdutos.get(i).getEstoque();
//			data[i][4] = listaProdutos.get(i).getEstoqueMinimo();
//			data[i][5] = LtpLib.obterDataFormatada(listaProdutos.get(i).getDataCadastrada());
			data[i][3] = 1;
			
				
		}
		
		DefaultTableModel model = new DefaultTableModel(data,titleRow);
		
		
		
		return model;
	}
	public DefaultTableModel mostraTabelaDeVendedorUnico(String fieldPesquisar) {
		
		
			try {
				Vendedor vendedor = (Vendedor) comercial.consultarCpf(fieldPesquisar,"vendedor");
				
				
				Object[] titleRow = {"Código","Nome", "Email", "Data Cadastrada","Cpf","Meta mensal"};
				Object[][] data = new Object[1][titleRow.length];
				
				
				for (int i = 0; i < 1; i++) {
				
					data[i][0] = vendedor.getCodigo();
					data[i][1] = vendedor.getNome();
					data[i][2] = vendedor.getEmail();
					data[i][3] = LtpLib.obterDataFormatada(vendedor.getDataCadastrada());
					data[i][4] = vendedor.getCpf();
					data[i][5] = vendedor.getMetaMensal();
					
						
				}
				
	
				DefaultTableModel model = new DefaultTableModel(data,titleRow);
				
				
				return model;
				
			
				
			} catch (SisComException e) {
				System.err.println("Não foi possivel Criar table" + e.getMessage());
				System.out.println(e.getLocalizedMessage());
			}
		
		return new DefaultTableModel();
		
	}
	
	public DefaultTableModel mostraTabelaDeVendedor() {
		
		try {
			ArrayList<Vendedor> listaVendedores  = Comercial.listaVendedor();
			
			Object[] titleRow = {"Código","Nome", "Email", "Data Cadastrada","Cpf","Meta mensal"};
			Object[][] data = new Object[listaVendedores.size()][titleRow.length];
			
			for (int i = 0; i < listaVendedores.size(); i++) {
				
				
				data[i][0] = listaVendedores.get(i).getCodigo();
				data[i][1] = listaVendedores.get(i).getNome();
				data[i][2] = listaVendedores.get(i).getEmail();
				data[i][3] = LtpLib.obterDataFormatada(listaVendedores.get(i).getDataCadastrada());
				data[i][4] = listaVendedores.get(i).getCpf();
				data[i][5] = listaVendedores.get(i).getMetaMensal();
				
					
			}
			

			DefaultTableModel model = new DefaultTableModel(data,titleRow);
			
			return model;
			
		} catch (SisComException e) {
			System.out.println("Não foi possível encontrar Vendedores na lista!" + e.getMessage());
		}
		
		return new DefaultTableModel();
		
	
	}
	
	public void calcularValorTotalProdutos(JLabel valor) {
		DefaultTableModel tableModel = (DefaultTableModel) tableListaVendas.getModel();
		
			try {
				double total = 0;
				double valorProduto;
				int quantidade;
				
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					valorProduto = Double.parseDouble(tableModel.getValueAt(i, 2).toString().trim());
					
					quantidade = Integer.parseInt(tableModel.getValueAt(i, 3).toString().trim());
					
					total += valorProduto * quantidade;
				}
				
				valor.setText(Double.toString(total));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		
		
	}
	
	public DefaultTableModel mostraTabelaVendas(Date dataInicio,Date dataFinal) throws SisComException {
		if(dataInicio == null || dataFinal == null)
			throw new SisComException("Datas vazias");
		
		//get ListaComprasPeriodo
		ArrayList<Venda> listaVendaPeriodo = new ArrayList<>();
		for (Venda venda : Comercial.getListaVendas()) {
			
			
			if(venda.getDataVenda().compareTo(dataInicio) >=0 && venda.getDataVenda().compareTo(dataFinal) <=0 ) {
				listaVendaPeriodo.add(venda);
			}
		}
		
		//Create Table
		Object[] titleRow = {"Numero da Compra","Vendedor","Data das vendas"};
		Object[][] data = new Object[listaVendaPeriodo.size()][titleRow.length];
	
		for (int i = 0; i < listaVendaPeriodo.size(); i++) {
			
			data[i][0] = listaVendaPeriodo.get(i).getNumeroVenda();
			data[i][1] = listaVendaPeriodo.get(i).getVendedor().getNome();
			data[i][2] = LtpLib.obterDataFormatada(listaVendaPeriodo.get(i).getDataVenda());
		}
				
		DefaultTableModel model = new DefaultTableModel(data,titleRow);
			
		return model;
	}
	
	/**
	 * 
	 * @param dataInicio Description data de inicio
	 * @param dataFinal Description data final	
	 * @return model
	 * @throws SisComException Description datas Vazias
	 */
	public DefaultTableModel mostraTabelaEstatistica(Date dataInicio,Date dataFinal)throws SisComException{
		if(dataInicio == null || dataFinal == null)
			throw new SisComException("Datas Vazias");
		
		HashMap<String, Estatistica> listaEstatisticas = Comercial.getListaEstatisticaVendasVendedor();
		HashMap<String, Estatistica> listaEstatisticaPeriodo = new HashMap<>();
		
		for (Object chav : listaEstatisticas.keySet()) {
			Estatistica valuee = listaEstatisticas.get(chav);
			
			if(valuee.getDataCompra().compareTo(dataInicio) >=0	&&
			   valuee.getDataCompra().compareTo(dataFinal) <=0){
				
				listaEstatisticaPeriodo.put(valuee.getNome(), valuee);
			}
		}
		
		Object[] titleRow = {"Nome Vendedor","Quantidade de vendas","Valor das vendas"};
		Object[][] data = new Object[listaEstatisticaPeriodo.size()][titleRow.length];
		
		int i = 0;
		for (Object chave : listaEstatisticaPeriodo.keySet()) {
			 Estatistica value = listaEstatisticaPeriodo.get(chave);
			 data[i][0] =  value.getNome();
			 data[i][1] =  value.getQuantidade();
			 data[i][2] =  value.getValorTotal();
			 i++;
		}
		
		DefaultTableModel model = new DefaultTableModel(data,titleRow);
		
		
		
		return model;
	}
	
	public DefaultTableModel mostraTabelaDeProdutosUnico(Produto produto) {
		
		Object[] titleRow = {"Código","Nome", "Preço Unitário","Quantidade"};
		Object[][] data = new Object[1][titleRow.length];
		
		for (int i = 0; i < 1; i++) {
			
			data[i][0] = produto.getCodigo();
			data[i][1] = produto.getNome();
			data[i][2] = produto.getPrecoUnitario();
//			data[i][3] = produto.getEstoque();
//			data[i][4] = produto.getEstoqueMinimo();
//			data[i][5] = LtpLib.obterDataFormatada(produto.getDataCadastrada());
			data[i][3] = 1;
				
		}
		
		DefaultTableModel model = new DefaultTableModel(data,titleRow);
		
		return model;
	}

	
}
