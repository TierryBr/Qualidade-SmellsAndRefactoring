package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;

import javax.swing.JOptionPane;

import javax.swing.border.TitledBorder;

import controller.Comercial;
import error.SisComException;
import model.Compra;
import model.Estatistica;
import model.Fornecedor;
import model.ItemCompra;
import model.Produto;
import utilitarios.CustomTransferHandler;
import utilitarios.InterfaceUtil;
import utilitarios.LtpLib;

import javax.swing.UIManager;

import javax.swing.ImageIcon;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Dimension;


public class PanelFornecedorCenter extends JPanel {
	/**
	 * 
	 */
	private static Comercial comercial = new Comercial();
	private static final long serialVersionUID = 1L;
	private JTextField fieldEmail;
	private JTextField fieldNome;
	private JTextField fieldTelefone;
	private JTextField fieldCnpj;
	private JTextField fieldContato;
	private JTable tableConsulta;
	private JTextField fieldPesquisar;
	private JTable tableEstatistica;
	private JTextField fieldPesquisaFornecedor;
	private JTable tableFornecedor;
	private JTextField fieldPesquisarProduto;
	private JTable tableProdutos;
	private JTable tableListaCompra;
	private JLabel lblValorTotal = new JLabel();
	private static Compra objCompra = new Compra();
	private static Fornecedor fornecedor = new Fornecedor();
	private JTextField fieldDataInicio;
	private JTextField fieldDataFinal;
	private JTextField fieldDataInicioEstatistica;
	private JTextField fieldDataFinalEstatistica;

	/**
	 * Create the panel.
	 */
	public PanelFornecedorCenter() {
		
		//Instancias
		tableProdutos = new JTable();
		tableProdutos.setPreferredScrollableViewportSize(new Dimension(450, 200));
		tableProdutos.setDefaultEditor(Object.class, null);
		
		tableProdutos.setTransferHandler(new CustomTransferHandler());
		tableProdutos.setDragEnabled(true);
		
		tableListaCompra = new JTable();
		tableListaCompra.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tableListaCompra.setSurrendersFocusOnKeystroke(true);
		tableListaCompra.setFillsViewportHeight(true);
		tableListaCompra.setColumnSelectionAllowed(true);
		
		tableListaCompra.setDropMode(DropMode.INSERT_ROWS);
		tableListaCompra.setTransferHandler(new CustomTransferHandler());
		
		
		tableEstatistica = new JTable();
		tableEstatistica.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		setBackground(SystemColor.control);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
					.addGap(23))
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
					.addGap(21))
		);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(new Rectangle(100, 100, 0, 0));
		panelCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de  Fornecedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 102)));
		tabbedPane.addTab("Cadastro", new ImageIcon(PanelFornecedorCenter.class.getResource("/images/fornecedor-32.png")), panelCadastro, null);
		
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldNome = new JTextField();
		fieldNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldTelefone = new JTextField();
		fieldTelefone.setColumns(10);
		
		fieldCnpj = new JTextField();
		fieldCnpj.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldContato = new JTextField();
		fieldContato.setColumns(10);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					String cnpj = fieldCnpj.getText();
					String nomeContato = fieldContato.getText();
					System.out.println(nome +"" + telefone + email + LtpLib.obterDataFormatada(dataCadastrada));
					
					Fornecedor fornecedor = new Fornecedor(codigo, nome, telefone, email, dataCadastrada, cnpj, nomeContato);
					Comercial.getListaPessoas().add(fornecedor);
					
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					mostarTabelaDeFornecedor();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
				
			}
		});
		btnCadastrar.setFocusable(false);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(Colors.COLOR_BUTTON);
		btnCadastrar.setBorder(BorderFactory.createEmptyBorder());
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setBackground(Colors.COLOR_HOVER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setBackground(Colors.COLOR_BUTTON);
			}
		});
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
									.addComponent(fieldTelefone, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)))
							.addGap(15))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldEmail, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
								.addComponent(fieldCnpj, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblContato, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
									.addGap(360))
								.addComponent(fieldContato, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
							.addContainerGap())))
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
							.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldCnpj, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContato, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldContato, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel panelConsulta = new JPanel();
		panelConsulta.setBorder(new TitledBorder(null, "Consultar Fornecedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		panelConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("Consulta", new ImageIcon(PanelFornecedorCenter.class.getResource("/images/search2.png")), panelConsulta, null);
		
		JScrollPane scrollPaneConsulta = new JScrollPane();
		
		JLabel lblPesquisar = new JLabel("Pesquisa por cnpj:");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesquisar.setForeground(new Color(102, 0, 153));
		
		fieldPesquisar = new JTextField();
		fieldPesquisar.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
				
				try {
					
					InterfaceUtil.limparTabela(model);
					Fornecedor fornecedor = (Fornecedor) comercial.consultarCpf(fieldPesquisar.getText(),"fornecedor");
					
					Object[] row = new Object[7];
					
					row[0] = fornecedor.getCodigo();
					row[1] = fornecedor.getNome();
					row[2] = fornecedor.getEmail();
					row[3] = fornecedor.getCnpj();
					row[4] = LtpLib.obterDataFormatada(fornecedor.getDataCadastrada());
					row[5] = fornecedor.getTelefone();
					row[6] = fornecedor.getNomeContato();
					
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
				
				DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
				
				try {
					InterfaceUtil.limparTabela(model);
					
					Fornecedor fornecedor = (Fornecedor) comercial.consultarCpf(fieldPesquisar.getText(),"fornecedor");
					Object[] row = new Object[7];
					
					row[0] = fornecedor.getCodigo();
					row[1] = fornecedor.getNome();
					row[2] = fornecedor.getEmail();
					row[3] = fornecedor.getCnpj();
					row[4] = LtpLib.obterDataFormatada(fornecedor.getDataCadastrada());
					row[5] = fornecedor.getTelefone();
					row[6] = fornecedor.getNomeContato();
					
					model.addRow(row);
					
				} catch (SisComException e) {
					System.err.println(e.getMessage());
				}
				
			}
		});
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel lblCliqueComDireito = new JLabel("Clique com o bot\u00E3o direito para exclus\u00E3o de Fornecedores");
		lblCliqueComDireito.setForeground(new Color(102, 0, 153));
		lblCliqueComDireito.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_panelConsulta = new GroupLayout(panelConsulta);
		gl_panelConsulta.setHorizontalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneConsulta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panelConsulta.createSequentialGroup()
							.addComponent(panelAcoes, GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelConsulta.createSequentialGroup()
							.addComponent(lblPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisar, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
							.addGap(63))
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(lblCliqueComDireito)
							.addContainerGap(695, Short.MAX_VALUE))))
		);
		gl_panelConsulta.setVerticalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(fieldPesquisar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAcoes, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCliqueComDireito)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneConsulta, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addGap(49))
		);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model =  (DefaultTableModel) tableConsulta.getModel();
				int selectedRowIndex = tableConsulta.getSelectedRow();
				
				int idPessoa = (int) model.getValueAt(selectedRowIndex, 0);
					
				model.removeRow(selectedRowIndex);
				
				try {
					
					Comercial.removerPessoaId(idPessoa);
					System.out.println("Pessoa removida com Sucesso!");
				} catch (SisComException e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					tableConsulta.setModel(mostarTabelaDeFornecedor());
				} catch (SisComException e) {
					System.out.println(e.getMessage());
					
				}
			}
		});
		GroupLayout gl_panelAcoes = new GroupLayout(panelAcoes);
		gl_panelAcoes.setHorizontalGroup(
			gl_panelAcoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoes.createSequentialGroup()
					.addGap(174)
					.addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(btnListarTodos, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(181))
		);
		gl_panelAcoes.setVerticalGroup(
			gl_panelAcoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoes.createSequentialGroup()
					.addGroup(gl_panelAcoes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(btnListarTodos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelAcoes.setLayout(gl_panelAcoes);
		
//		Vector data = makeData();
//		  Vector columns = makeColumns();
//		  dataModel = new DefaultTableModel(data, columns);
//		  table.setModel(dataModel);
		tableConsulta = new JTable();
		Object[] titleJTable  = {"ID", "Nome", "Email", "Cnpj", "Data cadastrada", "Telefone", "Contato"};
		tableConsulta.setModel(new DefaultTableModel(
			new Object[][] {
				,
			},
			titleJTable
		));
		tableConsulta.setFillsViewportHeight(true);
	
		scrollPaneConsulta.setViewportView(tableConsulta);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		InterfaceUtil.addPopup(tableConsulta, popupMenu_1);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model =  (DefaultTableModel) tableConsulta.getModel();
				int selectedRowIndex = tableConsulta.getSelectedRow();
				
				int idPessoa = (int) model.getValueAt(selectedRowIndex, 0);

				
				model.removeRow(selectedRowIndex);
					
				try {
					
					Comercial.removerPessoaId(idPessoa);
					System.out.println("Pessoa removida com Sucesso!");
				} catch (SisComException e) {
					System.out.println(e.getMessage());
					System.out.println("Não foi possível remover o cliente");
				}
			}
		});
		popupMenu_1.add(mntmExcluir_1);
		panelConsulta.setLayout(gl_panelConsulta);
		
		JPanel panelCompra = new JPanel();
		panelCompra.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelCompra.setBorder(new TitledBorder(null, "Compra", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		tabbedPane.addTab("Compra", new ImageIcon(PanelFornecedorCenter.class.getResource("/images/compra-32.png")), panelCompra, null);
		
		JPanel panelPesquisaFornecedor = new JPanel();
		panelPesquisaFornecedor.setBorder(new TitledBorder(null, "Pesquisa de Fornecedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Painel de produtos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JPanel painelListaCompra = new JPanel();
		painelListaCompra.setBorder(new TitledBorder(null, "Lista de Compras", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		GroupLayout gl_panelCompra = new GroupLayout(panelCompra);
		gl_panelCompra.setHorizontalGroup(
			gl_panelCompra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCompra.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCompra.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPesquisaFornecedor, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
						.addGroup(gl_panelCompra.createSequentialGroup()
							.addComponent(panelProdutos, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelListaCompra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3)))
					.addContainerGap())
		);
		gl_panelCompra.setVerticalGroup(
			gl_panelCompra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCompra.createSequentialGroup()
					.addComponent(panelPesquisaFornecedor, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCompra.createParallelGroup(Alignment.LEADING)
						.addComponent(panelProdutos, GroupLayout.PREFERRED_SIZE, 388, Short.MAX_VALUE)
						.addComponent(painelListaCompra, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addGap(110))
		);
		
		JPanel panelImgCompra = new JPanel();
		
		JScrollPane scrollPaneListaCompra = new JScrollPane();
		
		
		JLabel lblValor = new JLabel("Valor Total:");
		
		JLabel lblValorTotal = new JLabel("0,00");
		
		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

					try {
						fazerCompra(lblValorTotal);
						
						
						
					} catch (Exception e) {
						System.out.println("Depois da função");
						JOptionPane.showMessageDialog(panelPesquisaFornecedor,
							    "Fornecedor ou Produtos vazio",
							    "Tabelas Vazias",
							    JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		GroupLayout gl_painelListaCompra = new GroupLayout(painelListaCompra);
		gl_painelListaCompra.setHorizontalGroup(
			gl_painelListaCompra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelListaCompra.createSequentialGroup()
					.addComponent(lblValor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblValorTotal)
					.addGap(252)
					.addComponent(btnFinalizarCompra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(gl_painelListaCompra.createSequentialGroup()
					.addGap(185)
					.addComponent(panelImgCompra, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(187))
				.addComponent(scrollPaneListaCompra, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
		);
		gl_painelListaCompra.setVerticalGroup(
			gl_painelListaCompra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelListaCompra.createSequentialGroup()
					.addComponent(panelImgCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneListaCompra, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_painelListaCompra.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(lblValorTotal)
						.addComponent(btnFinalizarCompra))
					.addGap(21))
		);
		
		
		
		tableListaCompra.setModel(new DefaultTableModel(
			 null,
			new String[] 
					{"Código","Nome", "Preço Unitário","Quantidade"}
		));
		
		TableColumn tableColumn = tableListaCompra.getColumnModel().getColumn(3);
		
		
		JComboBox<Integer> comboBoxQuantProd = new JComboBox<Integer>();
		int[] valuesQuantProd = {10,20,30,40,50};
		
		for (int i = 0; i < valuesQuantProd.length; i++) {
			comboBoxQuantProd.addItem(valuesQuantProd[i]);
		}
		
		comboBoxQuantProd.setSelectedIndex(0);
		comboBoxQuantProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				calcularValorTotalProdutos(lblValorTotal);
			}
		});
		
		tableColumn.setCellEditor(new DefaultCellEditor(comboBoxQuantProd));

		
		scrollPaneListaCompra.setViewportView(tableListaCompra);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLabel("teste\r\nteste");
		InterfaceUtil.addPopup(tableListaCompra, popupMenu);
		
		JMenuItem mntmExcluir = new JMenuItem("excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =  (DefaultTableModel) tableListaCompra.getModel();
				int selectedRowIndex = tableListaCompra.getSelectedRow();
					
				model.removeRow(selectedRowIndex);
				
			}
		});
		popupMenu.add(mntmExcluir);
		
		JLabel lblImgCompra = new JLabel("");
		lblImgCompra.setIcon(new ImageIcon(PanelFornecedorCenter.class.getResource("/images/cart-32.png")));
		panelImgCompra.add(lblImgCompra);
		painelListaCompra.setLayout(gl_painelListaCompra);
		
		JLabel lblPesquisarProduto = new JLabel("Pesquisar");
		
		fieldPesquisarProduto = new JTextField();
		fieldPesquisarProduto.setToolTipText("Pesquisar Produto por parte do nome");
		fieldPesquisarProduto.setColumns(10);
		fieldPesquisarProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
								
					tableProdutos.setModel(mostraTabelaDeProdutosTotal(Comercial.procurarProdutoNome(fieldPesquisarProduto.getText())));
					 
				} catch(NumberFormatException f){
			          System.out.println(f.getMessage());
			          System.out.println("Campo Pesquisa Produto Vazio");
		        }
				
			}
		});
		
		
		JScrollPane scrollPaneProdutos = new JScrollPane();
		
		GroupLayout gl_panelProdutos = new GroupLayout(panelProdutos);
		gl_panelProdutos.setHorizontalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProdutos.createSequentialGroup()
					.addGroup(gl_panelProdutos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelProdutos.createSequentialGroup()
							.addComponent(lblPesquisarProduto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisarProduto, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
						.addComponent(scrollPaneProdutos, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelProdutos.setVerticalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProdutos.createSequentialGroup()
					.addGroup(gl_panelProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisarProduto)
						.addComponent(fieldPesquisarProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneProdutos, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		
		
		
	
		//Seta o modelo da tabela
		tableProdutos.setModel(mostraTabelaDeProdutosTotal(Comercial.getListaProdutos()));
		tableProdutos.setDragEnabled(true);
		
		
		scrollPaneProdutos.setViewportView(tableProdutos);
		panelProdutos.setLayout(gl_panelProdutos);
		
		JLabel lblPesquisaFornecedor = new JLabel("Pesquisa por Cnpj:");
		lblPesquisaFornecedor.setForeground(new Color(102, 0, 153));
		lblPesquisaFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldPesquisaFornecedor = new JTextField();
		fieldPesquisaFornecedor.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {

				DefaultTableModel modelCompra = (DefaultTableModel) tableFornecedor.getModel();

				try {
					
					InterfaceUtil.limparTabela(modelCompra);
					Fornecedor fornecedor = (Fornecedor) comercial.consultarCpf(fieldPesquisaFornecedor.getText(),"fornecedor");
					
						Object[] row = new Object[7];
						
						row[0] = fornecedor.getCodigo();
						row[1] = fornecedor.getNome();
						row[2] = fornecedor.getEmail();
						row[3] = fornecedor.getCnpj();
						row[4] = LtpLib.obterDataFormatada(fornecedor.getDataCadastrada());
						row[5] = fornecedor.getTelefone();
						row[6] = fornecedor.getNomeContato();
						
						modelCompra.addRow(row);
					
				} catch (SisComException a) {
					System.err.println(a.getMessage());
				}
			}
			
		});
		fieldPesquisaFornecedor.setColumns(10);
		
		
		
		JButton btnPesquisaFornecedor = new JButton("Pesquisar");
		btnPesquisaFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					DefaultTableModel modelCompra = (DefaultTableModel) tableFornecedor.getModel();
					InterfaceUtil.limparTabela(modelCompra);
					
					Fornecedor fornecedor = (Fornecedor) comercial.consultarCpf(fieldPesquisaFornecedor.getText(),"fornecedor");
					Object[] colums = new Object[7];
					
					colums[0] = fornecedor.getCodigo();
					colums[1] = fornecedor.getNome();
					colums[2] = fornecedor.getEmail();
					colums[3] = fornecedor.getCnpj();
					colums[4] = LtpLib.obterDataFormatada(fornecedor.getDataCadastrada());
					colums[5] = fornecedor.getTelefone();
					colums[6] = fornecedor.getNomeContato();
					
					modelCompra.addRow(colums);
					
				} catch (SisComException e) {
					System.err.println(e.getMessage());
				}
			}
		});
		
		JScrollPane scrollPaneCompra = new JScrollPane();
		GroupLayout gl_panelPesquisaFornecedor = new GroupLayout(panelPesquisaFornecedor);
		gl_panelPesquisaFornecedor.setHorizontalGroup(
			gl_panelPesquisaFornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPesquisaFornecedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
							.addComponent(lblPesquisaFornecedor, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisaFornecedor, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnPesquisaFornecedor, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
							.addComponent(scrollPaneCompra, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
							.addGap(14))))
		);
		gl_panelPesquisaFornecedor.setVerticalGroup(
			gl_panelPesquisaFornecedor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
					.addGroup(gl_panelPesquisaFornecedor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelPesquisaFornecedor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
									.addGap(2)
									.addComponent(fieldPesquisaFornecedor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
									.addGap(1)
									.addComponent(btnPesquisaFornecedor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelPesquisaFornecedor.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPesquisaFornecedor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPaneCompra, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		tableFornecedor = new JTable();
		DefaultTableModel modelCompra = (DefaultTableModel) tableFornecedor.getModel();
		Object[] titleJTableCompra  = {"ID", "Nome", "Email", "Cnpj", "Data cadastrada", "Telefone", "Contato"};
		
		for (int i = 0; i < titleJTableCompra.length; i++) {
			modelCompra.addColumn(titleJTableCompra[i]);
		}
		scrollPaneCompra.setViewportView(tableFornecedor);
		panelPesquisaFornecedor.setLayout(gl_panelPesquisaFornecedor);
		panelCompra.setLayout(gl_panelCompra);
		
		JPanel panelEstatistica = new JPanel();
		panelEstatistica.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estat\u00EDstica de Compras", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		panelEstatistica.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("Estat\u00EDstica de Compras", new ImageIcon(PanelFornecedorCenter.class.getResource("/images/statistic.png")), panelEstatistica, null);
		
		JScrollPane scrollPaneEstatistica = new JScrollPane();
		
		JPanel panelAcoesEstatistica = new JPanel();
		panelAcoesEstatistica.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		fieldDataInicio = new JTextField();
		fieldDataInicio.setColumns(10);
		
		fieldDataFinal = new JTextField();
		fieldDataFinal.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Per\u00EDodo");
		JLabel lblA = new JLabel("a");
		
		
		JLabel label = new JLabel("Per\u00EDodo");
		
		fieldDataInicioEstatistica = new JTextField();
		fieldDataInicioEstatistica.setColumns(10);
		
		JLabel label_1 = new JLabel("a");
		
		fieldDataFinalEstatistica = new JTextField();
		fieldDataFinalEstatistica.setColumns(10);
		
		
		JButton btnListaComprasFornecedor = new JButton("Listar Compras de fornecedores");
		btnListaComprasFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Date dataInicio = LtpLib.obterStringParaData(fieldDataInicio.getText());
					Date dataFinal = LtpLib.obterStringParaData(fieldDataFinal.getText());
					
					tableEstatistica.setModel(mostraTabelaCompra(dataInicio,dataFinal));
				
					
				} catch (SisComException e) {
					JOptionPane.showMessageDialog(tableEstatistica,
						    "Preencha as datas de início e Fim",
						    "Datas Vazias",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnListarEstatistica = new JButton("Listar todas estat\u00EDsticas");
		btnListarEstatistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Date dataInicioEstatistica = LtpLib.obterStringParaData(fieldDataInicioEstatistica.getText());
					Date dataFinalEstatistica = LtpLib.obterStringParaData(fieldDataFinalEstatistica.getText());
					
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
							.addComponent(fieldDataInicio, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldDataFinal, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
						.addComponent(btnListaComprasFornecedor, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
					.addGap(34)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addComponent(fieldDataInicioEstatistica, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldDataFinalEstatistica, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addComponent(btnListarEstatistica, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
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
						.addComponent(lblA))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnListaComprasFornecedor, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelAcoesEstatistica.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addGap(7)
							.addComponent(label))
						.addGroup(gl_panelAcoesEstatistica.createSequentialGroup()
							.addGroup(gl_panelAcoesEstatistica.createParallelGroup(Alignment.BASELINE)
								.addComponent(fieldDataFinalEstatistica, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(fieldDataInicioEstatistica, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnListarEstatistica, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		panelAcoesEstatistica.setLayout(gl_panelAcoesEstatistica);
		GroupLayout gl_panelEstatistica = new GroupLayout(panelEstatistica);
		gl_panelEstatistica.setHorizontalGroup(
			gl_panelEstatistica.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstatistica.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEstatistica.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneEstatistica, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
						.addComponent(panelAcoesEstatistica, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelEstatistica.setVerticalGroup(
			gl_panelEstatistica.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelEstatistica.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelAcoesEstatistica, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneEstatistica, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addGap(22))
		);
		
		
		
		scrollPaneEstatistica.setViewportView(tableEstatistica);
		panelEstatistica.setLayout(gl_panelEstatistica);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		tableListaCompra.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				calcularValorTotalProdutos(lblValorTotal);
			
			}
		});
		

	}
	public DefaultTableModel mostraTabelaCompra(Date dataInicio,Date dataFinal) throws SisComException {
		
		if(dataInicio == null || dataFinal == null)
			throw new SisComException("Data Vazias");
			
		//get ListaComprasPeriodo
		ArrayList<Compra> listaCompraPeriodo = new ArrayList<>();
		for (Compra compra : Comercial.getListaCompras()) {
			
			if(compra.getDataCompra().compareTo(dataInicio) >=0 && compra.getDataCompra().compareTo(dataFinal) <=0 ) {
				listaCompraPeriodo.add(compra);
			}
		}
		
		//Create Table
		Object[] titleRow = {"Numero da Compra","Fornecedor","Data das vendas"};
		Object[][] data = new Object[listaCompraPeriodo.size()][titleRow.length];
	
		for (int i = 0; i < listaCompraPeriodo.size(); i++) {
			
			data[i][0] = listaCompraPeriodo.get(i).getNumeroCompra();
			data[i][1] = listaCompraPeriodo.get(i).getFornecedor().getNome();
			data[i][2] = LtpLib.obterDataFormatada(listaCompraPeriodo.get(i).getDataCompra());
		}
				
		DefaultTableModel model = new DefaultTableModel(data,titleRow);
			
		return model;
	}
	
	/**
	 *
	 * @author lucas
	 * @return model
	 * @throws SisComException Description lista de fornecedores
	 */
	public DefaultTableModel mostarTabelaDeFornecedor() throws SisComException {
		
		
		try {
			ArrayList<Fornecedor> listaFornecedores  = Comercial.listaFornecedores();
			
			Object[] titleRow  = {"ID", "Nome", "Email", "Cnpj", "Data cadastrada", "Telefone", "Contato"};
			Object[][] data = new Object[listaFornecedores.size()][titleRow.length];
			
			for (int i = 0; i < listaFornecedores.size(); i++) {
				
				
				data[i][0] = listaFornecedores.get(i).getCodigo();
				data[i][1] = listaFornecedores.get(i).getNome();
				data[i][2] = listaFornecedores.get(i).getEmail();
				data[i][3] = listaFornecedores.get(i).getCnpj();
				data[i][4] = LtpLib.obterDataFormatada(listaFornecedores.get(i).getDataCadastrada());
				data[i][5] = listaFornecedores.get(i).getTelefone();
				data[i][6] = listaFornecedores.get(i).getNomeContato();
				
					
			}
			

			DefaultTableModel model = new DefaultTableModel(data,titleRow);
			
			return model;
			
		} catch (SisComException e) {
			System.out.println("Não foi possível encontrar Vendedores na lista!" + e.getMessage());
		}
				
		return new DefaultTableModel();
		
	}
	/**
	 * 
	 * @param listaFornecedores Description lista de fornecedores
	 * @return model
	 * @throws SisComException Description Não existem fornecedores na lista
	 */
	public DefaultTableModel mostarTabelaDeFornecedor(ArrayList<Fornecedor> listaFornecedores) throws SisComException {
		
		Object[] titleRow  = {"ID", "Nome", "Email", "Cnpj", "Data cadastrada", "Telefone", "Contato"};
		Object[][] data = new Object[listaFornecedores.size()][titleRow.length];
		
		for (int i = 0; i < listaFornecedores.size(); i++) {
			
			
			data[i][0] = listaFornecedores.get(i).getCodigo();
			data[i][1] = listaFornecedores.get(i).getNome();
			data[i][2] = listaFornecedores.get(i).getEmail();
			data[i][3] = listaFornecedores.get(i).getCnpj();
			data[i][4] = LtpLib.obterDataFormatada(listaFornecedores.get(i).getDataCadastrada());
			data[i][5] = listaFornecedores.get(i).getTelefone();
			data[i][6] = listaFornecedores.get(i).getNomeContato();
			
				
		}
			

		DefaultTableModel model = new DefaultTableModel(data,titleRow);
			
				
		return model;
		
	}
	/**
	 * 
	 * @param dataInicio Description data de inicio
	 * @param dataFinal Description data final
	 * @return model
	 * @throws SisComException Description datas vazias
	 */
	public DefaultTableModel mostraTabelaEstatistica(Date dataInicio,Date dataFinal) throws SisComException {
		if(dataInicio == null || dataFinal == null)
			throw new SisComException("Datas Vazias");
		
		HashMap<String, Estatistica> listaEstatisticas = Comercial.getListaEstatisticaVendasFornecedor();
		HashMap<String, Estatistica> listaEstatisticaPeriodo = new HashMap<>();
		
		
		for (Object chav : listaEstatisticas.keySet()) {
			Estatistica valuee = listaEstatisticas.get(chav);
			
			if(valuee.getDataCompra().compareTo(dataInicio) >=0	&&
			   valuee.getDataCompra().compareTo(dataFinal) <=0){
				
				listaEstatisticaPeriodo.put(valuee.getNome(), valuee);
			}
		}
		
		Object[] titleRow = {"Nome","Quantidade de vendas","Valor das vendas"};
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
	
	
	/**
	 * 
	 * @param listaProdutos Description lista de produtos
	 * @return model
	 */
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

	public void calcularValorTotalProdutos(JLabel valor) {
		DefaultTableModel tableModel = (DefaultTableModel) tableListaCompra.getModel();
		
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
	/**
	 * 
	 * @param valorCompraTotal Description valor total das comrpas
	 */
	public void fazerCompra(JLabel valorCompraTotal) {
		
		
		DefaultTableModel tableModel = (DefaultTableModel) tableListaCompra.getModel();
		if(tableFornecedor.getValueAt(0, 0).toString().trim() != null
			&& tableListaCompra.getValueAt(0, 0).toString().trim() != null) {
			
			try {
				
				String[] objFornecedor = new String[tableFornecedor.getColumnCount()-1];
				
				objFornecedor[0] = tableFornecedor.getValueAt(0, 0).toString().trim();//ID
				
				objFornecedor[1] = tableFornecedor.getValueAt(0, 1).toString().trim();//Nome
				
				objFornecedor[2] = tableFornecedor.getValueAt(0, 2).toString().trim();//Email
				
				objFornecedor[3] = tableFornecedor.getValueAt(0, 3).toString().trim();//CNPJ
				//Not date
				objFornecedor[4] = tableFornecedor.getValueAt(0, 5).toString().trim();//Telefone
				
				objFornecedor[5] = tableFornecedor.getValueAt(0, 6).toString().trim();//Contato
				
				
				
				Fornecedor fornecedor = new Fornecedor(Integer.parseInt(objFornecedor[0]),objFornecedor[1],objFornecedor[5],objFornecedor[2],new Date(),objFornecedor[3],objFornecedor[5]);
				
				int[] idProdutos = new int[tableModel.getRowCount()];
				
				double valorProdutosTotal = Double.parseDouble(valorCompraTotal.getText().toString().trim());
				
				int[] quantidadeProdutos = new int [tableModel.getRowCount()];
				
				double [] valorCompra = new double [tableModel.getRowCount()];
				
				
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					idProdutos[i] = Integer.parseInt(tableModel.getValueAt(i, 0).toString().trim());
					
					quantidadeProdutos[i] = Integer.parseInt(tableModel.getValueAt(i, 3).toString().trim());
					
					valorCompra[i] = Double.parseDouble(tableModel.getValueAt(i, 2).toString().trim());
					
					
				}
			
				ArrayList<ItemCompra> listaItemCompra = new ArrayList<ItemCompra>();
				
				for (Produto prod : Comercial.getListaProdutos()) {
					for (int i = 0; i < idProdutos.length; i++) {
						if(prod.getCodigo() == idProdutos[i]) {
							prod.incrementarProdutoEstoque(quantidadeProdutos[i]);
							ItemCompra itemCompra = new ItemCompra(prod, quantidadeProdutos[i], valorCompra[i]);
							listaItemCompra.add(itemCompra);
						}
					}
				}
		
				int codigo = 0;
				
				if(Comercial.getListaCompras().isEmpty()) {
					codigo = 1;
				}else {
					codigo = Comercial.getListaCompras().size() + 1;
				}
				
				Compra compra = new Compra(listaItemCompra,codigo,fornecedor,new Date());
				
				Comercial.getListaCompras().add(compra);
				
				//Atuliza Estatistica Venda
				fornecedor.atualizarEstatistica(new Estatistica(objFornecedor[1], 1, valorProdutosTotal,new Date()));
	
				JOptionPane.showMessageDialog(tableListaCompra,
					    "Compra realizada com Sucesso",
					    "Compra",
					    JOptionPane.INFORMATION_MESSAGE,new ImageIcon(PanelFornecedorCenter.class.getResource("/images/success.png")));
							
							
				InterfaceUtil.limparTabela((DefaultTableModel) tableListaCompra.getModel());
				InterfaceUtil.limparTabela((DefaultTableModel) tableFornecedor.getModel());
				
				Comercial.setTemporariaListaProdutos(Comercial.getListaProdutos());
				tableProdutos.setModel(mostraTabelaDeProdutosTotal(Comercial.getTemporariaListaProdutos()));
				
				fieldPesquisaFornecedor.setText("");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			
		}else
			System.out.println("Digite novamente.");
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
}



