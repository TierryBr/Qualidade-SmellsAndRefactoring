package view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import javax.swing.JTabbedPane;

import javax.swing.JOptionPane;

import javax.swing.border.TitledBorder;

import controller.Comercial;
import error.SisComException;

import model.Produto;
import utilitarios.InterfaceUtil;
import utilitarios.LtpLib;

import javax.swing.UIManager;

import javax.swing.ImageIcon;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class PanelProdutosCenter extends JPanel {
	/**
	 * 
	 */
	private static Comercial comercial = new Comercial();
	private static final long serialVersionUID = 1L;
	private JTextField fieldEstoque;
	private JTextField fieldNome;
	private JTextField fieldPrecoUnitario;
	private JTextField fieldEstoqueMin;
	private JTable tableConsulta;
	private JTextField fieldPesquisar;
//	private JRadioButton rdbtnAbaixoDoMnimo = new JRadioButton();
//	private JRadioButton rdbtnPesqPorCdigo = new JRadioButton();
	/**
	 * Create the panel.
	 */
	public PanelProdutosCenter() {
		
		
		JRadioButton rdbtnOrdenarPorNome = new JRadioButton("Ordenar por nome");
		rdbtnOrdenarPorNome.setToolTipText("Pesquisa ordenada por nome do produto");
		
		JRadioButton rdbtnAbaixoDoMnimo = new JRadioButton("Abaixo do m\u00EDnimo");
		rdbtnAbaixoDoMnimo.setToolTipText("Pesquisa de produtos abaixo do mínimo de produtos");
		
		rdbtnOrdenarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnAbaixoDoMnimo.setSelected(false);
				
				rdbtnOrdenarPorNome.setSelected(true);
			}
		});
		
		
		
		rdbtnAbaixoDoMnimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnOrdenarPorNome.setSelected(false);
				
				rdbtnAbaixoDoMnimo.setSelected(true);
			}
		});
		
		setBackground(SystemColor.control);
		
		JPanel panelProdutos = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelProdutos, GroupLayout.PREFERRED_SIZE, 894, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelProdutos, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GroupLayout gl_panelProdutos = new GroupLayout(panelProdutos);
		gl_panelProdutos.setHorizontalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProdutos.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 874, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelProdutos.setVerticalGroup(
			gl_panelProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelProdutos.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(new Rectangle(100, 100, 0, 0));
		panelCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de  Produtos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 102)));
		tabbedPane.addTab("Cadastro", new ImageIcon(PanelProdutosCenter.class.getResource("/images/shopping-basket-32.png")), panelCadastro, null);
		
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldEstoque = new JTextField();
		fieldEstoque.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldNome = new JTextField();
		fieldNome.setColumns(10);
		
		JLabel lblPrecoUnitario = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		lblPrecoUnitario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		fieldPrecoUnitario = new JTextField();
		fieldPrecoUnitario.setColumns(10);
		
		fieldEstoqueMin = new JTextField();
		fieldEstoqueMin.setColumns(10);
		
		JLabel lblEstoqueMin = new JLabel("Estoque M\u00EDnimo:");
		lblEstoqueMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = 0;
					
					if(Comercial.getListaProdutos().isEmpty()) {
						codigo = 1;
					}else {
						codigo = Comercial.getListaProdutos().size() + 1;
					}
					
					String nome = fieldNome.getText();
					nome = LtpLib.firstToUppercase(nome);
					
					double precoUnitario = Double.parseDouble(fieldPrecoUnitario.getText().replace(',', '.'));
					
					int estoque = Integer.parseInt(fieldEstoque.getText());
					int estoqueMinimo = Integer.parseInt(fieldEstoqueMin.getText());
					Date dataCadastrada = new Date();
		
					Produto produto = new Produto(codigo, nome, precoUnitario, estoque, estoqueMinimo, dataCadastrada);
					Comercial.getListaProdutos().add(produto);
					Comercial.getTemporariaListaProdutos().add(produto);
					
					// Cria o JOptionPane por showMessageDialog
				    int resposta = JOptionPane.showConfirmDialog(null,"escolha um", "escolha dois", JOptionPane.YES_NO_OPTION);
				    System.out.println("resp:"+resposta);
				    //verfica se a resposta é verdadeira
				    if (resposta == JOptionPane.YES_OPTION) {
				        JOptionPane.showMessageDialog(null, "Olá");
				      }
				      else {
				         JOptionPane.showMessageDialog(null, "Adeus");
				        
				      }
				    
				    
				    
				    
					 JOptionPane pane = new JOptionPane("Produto Inserido com Sucesso", JOptionPane.INFORMATION_MESSAGE);
		                JDialog dialog = pane.createDialog(panelProdutos, "Cadastro de produtos");
		                dialog.setModal(false);
		                dialog.setVisible(true);

		                new Timer(1000, new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent e) {
		                        dialog.setVisible(false);
		                        
		                    }
		                }).start();
					
		                fieldNome.setText("");
    					fieldEstoque.setText("");
    					fieldEstoqueMin.setText("");
    					fieldPrecoUnitario.setText("");
					mostarTabelaDeProdutos();
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
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrecoUnitario)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldNome, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
								.addComponent(fieldPrecoUnitario, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
							.addGap(15))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblEstoque, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstoqueMin))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldEstoqueMin, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
								.addComponent(fieldEstoque, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
									.addGap(622)))
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
							.addComponent(lblPrecoUnitario))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGap(20)
							.addComponent(fieldPrecoUnitario, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldEstoque, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstoque))
					.addGap(19)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstoqueMin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldEstoqueMin, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel Consulta = new JPanel();
		Consulta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Consultar Produtos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		Consulta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("Consulta", new ImageIcon(PanelProdutosCenter.class.getResource("/images/search2.png")), Consulta, null);
		
		JScrollPane scrollPaneConsulta = new JScrollPane();
		
		JLabel lblPesquisar = new JLabel("Pesquisa de Produtos");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesquisar.setForeground(new Color(102, 0, 153));
		
		fieldPesquisar = new JTextField();
		fieldPesquisar.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					
					try {
						InterfaceUtil.limparTabela(model);
						Produto produtos = (Produto) comercial.consultarProduto(Integer.parseInt(fieldPesquisar.getText()));
						Object[] row = new Object[6];
						
						row[0] = produtos.getCodigo();
						row[1] = produtos.getNome();
						row[2] = produtos.getPrecoUnitario();
						row[3] = produtos.getEstoque();
						row[4] = produtos.getEstoqueMinimo();
						row[5] = LtpLib.obterDataFormatada(produtos.getDataCadastrada());
						
						model.addRow(row);
						
					} catch (SisComException o) {
						System.err.println(o.getMessage());
					}catch(NumberFormatException b){
//		                JOptionPane.showMessageDialog(null, "Informe apenas números");
		            }
				}
				
				try {
					String regex = "^[a-zA-Z]+$";
					 if(fieldPesquisar.getText() == "") {
						fieldPesquisar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					}else if (fieldPesquisar.getText().matches(regex)) { 
						
						fieldPesquisar.setBorder(BorderFactory.createLineBorder(Color.RED));
					
					}else {
						fieldPesquisar.setBorder(BorderFactory.createLineBorder(Color.GREEN));
					}
					 
					InterfaceUtil.limparTabela(model);
					Produto produtos = (Produto) comercial.consultarProduto(Integer.parseInt(fieldPesquisar.getText()));
					Object[] row = new Object[6];
					
					row[0] = produtos.getCodigo();
					row[1] = produtos.getNome();
					row[2] = produtos.getPrecoUnitario();
					row[3] = produtos.getEstoque();
					row[4] = produtos.getEstoqueMinimo();
					row[5] = LtpLib.obterDataFormatada(produtos.getDataCadastrada());
					
					model.addRow(row);
					
				} catch (SisComException a) {
					System.err.println(a.getMessage());
				}catch(NumberFormatException b){
//	                JOptionPane.showMessageDialog(null, "Informe apenas números");
	            }
			}
			
		});
		fieldPesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 0, 153)));
		
		
		GroupLayout gl_Consulta = new GroupLayout(Consulta);
		gl_Consulta.setHorizontalGroup(
			gl_Consulta.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Consulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Consulta.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPaneConsulta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
						.addGroup(gl_Consulta.createSequentialGroup()
							.addComponent(lblPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPesquisar, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
						.addComponent(panelAcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(51))
		);
		gl_Consulta.setVerticalGroup(
			gl_Consulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Consulta.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_Consulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar)
						.addComponent(fieldPesquisar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelAcoes, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPaneConsulta, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
					.addGap(6))
		);
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel model =  (DefaultTableModel) tableConsulta.getModel();
					InterfaceUtil.limparTabela(model);
					
					if(rdbtnOrdenarPorNome.isSelected()) {
						
						ArrayList<Produto> produtos = comercial.obterListaProdutosNomeOrdenada();
						Object[] colum = new Object[6];
						
						for (int i = 0; i < produtos.size(); i++) {
							
							colum[0] = produtos.get(i).getCodigo();
							colum[1] = produtos.get(i).getNome();
							colum[2] = produtos.get(i).getPrecoUnitario();
							colum[3] = produtos.get(i).getEstoque();
							colum[4] = produtos.get(i).getEstoqueMinimo();
							colum[5] = LtpLib.obterDataFormatada(produtos.get(i).getDataCadastrada());
							
							
							model.addRow(colum);
						}
					}else if(rdbtnAbaixoDoMnimo.isSelected()) {
						
						ArrayList<Produto> produtos = null;
						produtos = comercial.obterListaProdutosEstoqueMin();
						Object[] colum = new Object[6];
						
						for (int i = 0; i < produtos.size(); i++) {
							
							colum[0] = produtos.get(i).getCodigo();
							colum[1] = produtos.get(i).getNome();
							colum[2] = produtos.get(i).getPrecoUnitario();
							colum[3] = produtos.get(i).getEstoque();
							colum[4] = produtos.get(i).getEstoqueMinimo();
							colum[5] = LtpLib.obterDataFormatada(produtos.get(i).getDataCadastrada());
							
							
							model.addRow(colum);
						}
					}
				
				} catch (SisComException e) {
					System.out.println(e.getMessage());
					
				}
			}
		});
		
		
		GroupLayout gl_panelAcoes = new GroupLayout(panelAcoes);
		gl_panelAcoes.setHorizontalGroup(
			gl_panelAcoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoes.createSequentialGroup()
					.addGap(287)
					.addGroup(gl_panelAcoes.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListarTodos, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
						.addGroup(gl_panelAcoes.createSequentialGroup()
							.addComponent(rdbtnOrdenarPorNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(rdbtnAbaixoDoMnimo, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
					.addGap(291))
		);
		gl_panelAcoes.setVerticalGroup(
			gl_panelAcoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAcoes.createSequentialGroup()
					.addGroup(gl_panelAcoes.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnOrdenarPorNome)
						.addComponent(rdbtnAbaixoDoMnimo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListarTodos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelAcoes.setLayout(gl_panelAcoes);
		
		tableConsulta = new JTable();
		tableConsulta.setFillsViewportHeight(true);
		
		DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
		Object[] titleJTable  = {"ID", "Nome", "Preço Unitário", "Estoque", "Estoque Mínimo", "Data "};
		
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
		
				int idProduto = (int) model.getValueAt(selectedRowIndex, 0);
				
			
				int r = JOptionPane.showConfirmDialog(
					    tableConsulta,
					    "Tem Certeza que deseja Remover?",
					    "Remover Produto",
					    JOptionPane.YES_NO_OPTION);
				
				
					
					try {
					
						if(r  == 0) {
							Comercial.removerProdutoId(idProduto);
							
							model.removeRow(selectedRowIndex);
							System.out.println("Produto removido com Sucesso!");
						
						}
					} catch (SisComException e) {
						System.out.println(e.getMessage());
					}
				
			}
		});
		popupMenu.add(mntmExcluir);
		Consulta.setLayout(gl_Consulta);
		panelProdutos.setLayout(gl_panelProdutos);
		setLayout(groupLayout);

	}
	/**
	 * 
	 * @author lucas
	 * @throws SisComException Description não existem lista de produtos
	 */
	public void mostarTabelaDeProdutos() throws SisComException {
		DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();
			InterfaceUtil.limparTabela(model);
			ArrayList<Produto> produtos = Comercial.getListaProdutos();
			
				Object[] colum = new Object[6];
				
				for (int i = 0; i < produtos.size(); i++) {
					
					colum[0] = produtos.get(i).getCodigo();
					colum[1] = produtos.get(i).getNome();
					colum[2] = produtos.get(i).getPrecoUnitario();
					colum[3] = produtos.get(i).getEstoque();
					colum[4] = produtos.get(i).getEstoqueMinimo();
					colum[5] = LtpLib.obterDataFormatada(produtos.get(i).getDataCadastrada());
					
					
					model.addRow(colum);
				}
				
				model.fireTableDataChanged();
		
	}
	
}
