package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JTabbedPane;

import javax.swing.JOptionPane;

import javax.swing.border.TitledBorder;

import controller.Comercial;
import error.SisComException;
import model.Cliente;
import model.Estatistica;
import model.Venda;
import utilitarios.InterfaceUtil;
import utilitarios.LtpLib;

import javax.swing.UIManager;

import javax.swing.ImageIcon;

import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class PanelClienteCenter extends JPanel {
	/**
	 * 
	 */
	private static Comercial comercial = new Comercial();
	private static final long serialVersionUID = 1L;
	private JTextField fieldEmail;
	private JTextField fieldNome;
	private JTextField fieldTelefone;
	private JTextField fieldCpf;
	private JTextField fieldLimiteCredito;
	private JTable tableConsulta;
	private JTextField fieldPesquisar;
	private JTextField fieldDataInicio;
	private JTextField fieldDataFinal;
	private JTextField fieldDataInicioEstatistica;
	private JTextField fieldDataFinalEstatistica;
	private JTable tableEstatistica;
	

	/**
	 * 
	 * Create the panel.
	 */
	public PanelClienteCenter() {
		
		setBackground(SystemColor.control);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
					.addGap(16))
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 518, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(new Rectangle(100, 100, 0, 0));
		panelCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de  Fornecedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 102)));
		tabbedPane.addTab("Cadastro", new ImageIcon(PanelClienteCenter.class.getResource("/images/cliente-32.png")), panelCadastro, null);
		
		
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
		
		fieldCpf = new JTextField();
		fieldCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldLimiteCredito = new JTextField();
		fieldLimiteCredito.setColumns(10);
		
		JLabel lblLimiteCredito = new JLabel("LimiteCredito:");
		lblLimiteCredito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
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
					String cpf = fieldCpf.getText();
					Double limiteCredito = Double.parseDouble(fieldLimiteCredito.getText());
					
					
					Cliente cliente = new Cliente(codigo, nome, telefone, email, dataCadastrada, cpf, limiteCredito);
					Comercial.getListaPessoas().add(cliente);
					
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
					mostarTabelaCliente();
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
									.addComponent(fieldTelefone, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
							.addGap(15))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldEmail, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
								.addComponent(fieldCpf, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblLimiteCredito)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
									.addGap(360))
								.addComponent(fieldLimiteCredito, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
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
							.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldCpf, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
						.addComponent(fieldLimiteCredito, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLimiteCredito, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel Consulta = new JPanel();
		Consulta.setBorder(new TitledBorder(null, "Consultar Fornecedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		Consulta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("Consulta", new ImageIcon(PanelClienteCenter.class.getResource("/images/search2.png")), Consulta, null);
		
		JScrollPane scrollPaneConsulta = new JScrollPane();
		
		JLabel lblPesquisar = new JLabel("Pesquisa por Cpf:");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesquisar.setForeground(new Color(102, 0, 153));
		
		fieldPesquisar = new JTextField();
		fieldPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					
					try {
						InterfaceUtil.limparTabela(model);
						
						Cliente cliente = (Cliente) comercial.consultarCpf(fieldPesquisar.getText(),"cliente");
						Object[] row = new Object[7];
						
						row[0] = cliente.getCodigo();
						row[1] = cliente.getNome();
						row[2] = cliente.getEmail();
						row[3] = cliente.getTelefone();
						row[4] = LtpLib.obterDataFormatada(cliente.getDataCadastrada());
						row[5] = cliente.getCpf();
						row[6] = cliente.getLimiteCredito();
						
						model.addRow(row);
						
					} catch (SisComException o) {
						System.err.println(o.getMessage());
					}
				}
				
				try {
					
					InterfaceUtil.limparTabela(model);
					Cliente cliente = (Cliente) comercial.consultarCpf(fieldPesquisar.getText(),"cliente");
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
		fieldPesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
				
				try {
					InterfaceUtil.limparTabela(model);
					
					Cliente cliente = (Cliente) comercial.consultarCpf(fieldPesquisar.getText(),"cliente");
					
					Object[] row = new Object[7];
					
					row[0] = cliente.getCodigo();
					row[1] = cliente.getNome();
					row[2] = cliente.getEmail();
					row[3] = cliente.getTelefone();
					row[4] = LtpLib.obterDataFormatada(cliente.getDataCadastrada());
					row[5] = cliente.getCpf();
					row[6] = cliente.getLimiteCredito();
					
					model.addRow(row);
					
				} catch (SisComException e) {
					System.err.println(e.getMessage());
				}
				
			}
		});
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel label = new JLabel("Clique com o bot\u00E3o direito para exclus\u00E3o de Fornecedores");
		label.setForeground(new Color(102, 0, 153));
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_Consulta = new GroupLayout(Consulta);
		gl_Consulta.setHorizontalGroup(
			gl_Consulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Consulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Consulta.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneConsulta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_Consulta.createSequentialGroup()
							.addComponent(panelAcoes, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_Consulta.createSequentialGroup()
							.addComponent(lblPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisar, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(63))
						.addGroup(gl_Consulta.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(334, Short.MAX_VALUE))))
		);
		gl_Consulta.setVerticalGroup(
			gl_Consulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Consulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Consulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(fieldPesquisar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAcoes, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(scrollPaneConsulta, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
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
				} catch (SisComException e) {
					System.out.println(e.getMessage());
				}
			
				
				System.out.println("Pessoa removida com Sucesso!");
				
			}
		});
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					mostarTabelaCliente();
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
		
		tableConsulta = new JTable();
		tableConsulta.setFillsViewportHeight(true);
		
		DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
		Object[] titleJTable  = {"ID", "Nome", "Email", "Cpf", "Data cadastrada", "Telefone", "Limite Credito"};
		
		for (int i = 0; i < titleJTable.length; i++) {
			model.addColumn(titleJTable[i]);
		}
		
		scrollPaneConsulta.setViewportView(tableConsulta);
		
		JPopupMenu popupMenu = new JPopupMenu();
		InterfaceUtil.addPopup(tableConsulta, popupMenu);
		
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
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
		popupMenu.add(mntmExcluir);
		Consulta.setLayout(gl_Consulta);
		
		JPanel panelEstatistica = new JPanel();
		panelEstatistica.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estat\u00EDstica de Compras", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		tabbedPane.addTab("Estat\u00EDsticas", new ImageIcon(PanelClienteCenter.class.getResource("/images/statistic.png")), panelEstatistica, null);
		
		JPanel panelAcoesCliente = new JPanel();
		panelAcoesCliente.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		JLabel lblPeriodoCompras = new JLabel("Per\u00EDodo");
		
		fieldDataInicio = new JTextField();
		fieldDataInicio.setColumns(10);
		
		JLabel label_1 = new JLabel("a");
		
		fieldDataFinal = new JTextField();
		fieldDataFinal.setColumns(10);
		
		JButton btnListarComprasCliente = new JButton("Listar Compras de Clientes");
		btnListarComprasCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Date dataInicio = LtpLib.obterStringParaData(fieldDataInicio.getText());
					Date dataFinal = LtpLib.obterStringParaData(fieldDataFinal.getText());
					
					tableEstatistica.setModel(mostraTabelaCompras(dataInicio,dataFinal));
				
					
				} catch (SisComException e) {
					JOptionPane.showMessageDialog(tableEstatistica,
						    "Preencha as datas de início e Fim",
						    "Datas Vazias",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel label_2 = new JLabel("Per\u00EDodo");
		
		fieldDataInicioEstatistica = new JTextField();
		fieldDataInicioEstatistica.setColumns(10);
		
		JLabel label_3 = new JLabel("a");
		
		fieldDataFinalEstatistica = new JTextField();
		fieldDataFinalEstatistica.setColumns(10);
		
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
		GroupLayout gl_panelAcoesCliente = new GroupLayout(panelAcoesCliente);
		gl_panelAcoesCliente.setHorizontalGroup(
			gl_panelAcoesCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoesCliente.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPeriodoCompras)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAcoesCliente.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAcoesCliente.createSequentialGroup()
							.addComponent(fieldDataInicio, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldDataFinal, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
						.addComponent(btnListarComprasCliente, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
					.addGap(34)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAcoesCliente.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAcoesCliente.createSequentialGroup()
							.addComponent(fieldDataInicioEstatistica, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldDataFinalEstatistica, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
						.addComponent(btnListarEstatistica, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAcoesCliente.setVerticalGroup(
			gl_panelAcoesCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoesCliente.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panelAcoesCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeriodoCompras)
						.addComponent(fieldDataInicio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldDataFinal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnListarComprasCliente, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(gl_panelAcoesCliente.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelAcoesCliente.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(gl_panelAcoesCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAcoesCliente.createSequentialGroup()
							.addGap(7)
							.addComponent(label_2))
						.addGroup(gl_panelAcoesCliente.createSequentialGroup()
							.addGroup(gl_panelAcoesCliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(fieldDataFinalEstatistica, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(fieldDataInicioEstatistica, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnListarEstatistica, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		panelAcoesCliente.setLayout(gl_panelAcoesCliente);
		
		JScrollPane scrollPaneEstatistica = new JScrollPane();
		GroupLayout gl_panelEstatistica = new GroupLayout(panelEstatistica);
		gl_panelEstatistica.setHorizontalGroup(
			gl_panelEstatistica.createParallelGroup(Alignment.LEADING)
				.addGap(0, 897, Short.MAX_VALUE)
				.addGroup(gl_panelEstatistica.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEstatistica.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAcoesCliente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
						.addComponent(scrollPaneEstatistica, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelEstatistica.setVerticalGroup(
			gl_panelEstatistica.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 670, Short.MAX_VALUE)
				.addGroup(gl_panelEstatistica.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addComponent(panelAcoesCliente, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(scrollPaneEstatistica, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addGap(84))
		);
		
		tableEstatistica = new JTable();
		tableEstatistica.setFillsViewportHeight(true);
		scrollPaneEstatistica.setViewportView(tableEstatistica);
		panelEstatistica.setLayout(gl_panelEstatistica);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	/**
	 * 
	 * @throws SisComException Description lista de clientes vazias
	 */
	public void mostarTabelaCliente() throws SisComException {
		DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
			InterfaceUtil.limparTabela(model);
			ArrayList<Cliente> clientes = Comercial.listaClientes();
			
				Object[] colum = new Object[7];
				
				for (int i = 0; i < clientes.size(); i++) {
					
					colum[0] = clientes.get(i).getCodigo();
					colum[1] = clientes.get(i).getNome();
					colum[2] = clientes.get(i).getEmail();
					colum[3] = clientes.get(i).getCpf();
					colum[4] = LtpLib.obterDataFormatada(clientes.get(i).getDataCadastrada());
					colum[5] = clientes.get(i).getTelefone();
					colum[6] = clientes.get(i).getLimiteCredito();
					
					model.addRow(colum);
				}
				
				model.fireTableDataChanged();
		
	}
	
	public DefaultTableModel mostraTabelaCompras(Date dataInicio,Date dataFinal) throws SisComException {
		if(dataInicio == null || dataFinal == null)
			throw new SisComException("datas Vazias");
		
		//get ListaComprasPeriodo
		ArrayList<Venda> listaCompraPeriodo = new ArrayList<>();
		for (Venda venda: Comercial.getListaVendas()) {
			
			
			if(venda.getDataVenda().compareTo(dataInicio) >=0 && venda.getDataVenda().compareTo(dataFinal) <=0 ) {
				listaCompraPeriodo.add(venda);
			}
		}
		
		//Create Table
		Object[] titleRow = {"Numero da Compra","Cliente","Data das vendas"};
		Object[][] data = new Object[listaCompraPeriodo.size()][titleRow.length];
	
		for (int i = 0; i < listaCompraPeriodo.size(); i++) {
			
			data[i][0] = listaCompraPeriodo.get(i).getNumeroVenda();
			data[i][1] = listaCompraPeriodo.get(i).getCliente().getNome();
			data[i][2] = LtpLib.obterDataFormatada(listaCompraPeriodo.get(i).getDataVenda());
		}
				
		DefaultTableModel model = new DefaultTableModel(data,titleRow);
			
		return model;
	}
	
	public DefaultTableModel mostraTabelaEstatistica(Date dataInicio,Date dataFinal) throws SisComException {
		if(dataInicio == null || dataFinal == null)
			throw new SisComException("Datas Vazias");
		
		HashMap<String, Estatistica> listaEstatisticas = Comercial.getListaEstatisticaComprasCliente();
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
	
	@SuppressWarnings("unused")
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
