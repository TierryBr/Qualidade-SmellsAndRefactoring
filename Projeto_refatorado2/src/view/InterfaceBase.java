package view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;
import java.awt.Cursor;


import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

import javax.swing.JLabel;
import java.awt.Component;

public class InterfaceBase extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JInternalFrame frameCliente = new InternalFrameVendaCliente();
	
	public InterfaceBase() {
		frameCliente.setSize(800,550);
		getContentPane().add(frameCliente);
		
		JPanel panelLeft = new JPanel();
	
		panelLeft.setBackground(Colors.COLOR_MAIN);
		
		JPanel panelTop = new JPanel();
		
		panelTop.setBackground(Colors.COLOR_MAIN);
		
		JPanel panelDefaulCenter = new JPanel();
		panelDefaulCenter.setBackground(Color.LIGHT_GRAY);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()						
					.addComponent(panelLeft, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addGap(0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelDefaulCenter, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)						
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelLeft, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelDefaulCenter, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
		);
		
		
		
		//Adiciona panels em PanelDefaultCenter
		PanelClienteCenter panelClienteCenter = new PanelClienteCenter();
		panelClienteCenter.setBackground(SystemColor.control);
		PanelFornecedorCenter panelFornecedorCenter = new PanelFornecedorCenter();
		PanelVendedorCenter panelVendedorCenter = new PanelVendedorCenter();
		PanelProdutosCenter panelProdutosCenter = new PanelProdutosCenter();
		
		
		GroupLayout gl_panelDefaulCenter = new GroupLayout(panelDefaulCenter);
		gl_panelDefaulCenter.setHorizontalGroup(
			gl_panelDefaulCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(panelClienteCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
				.addComponent(panelFornecedorCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
				.addComponent(panelVendedorCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
				.addComponent(panelProdutosCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
		);
		gl_panelDefaulCenter.setVerticalGroup(
			gl_panelDefaulCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(panelClienteCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
				.addComponent(panelFornecedorCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
				.addComponent(panelVendedorCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
				.addComponent(panelProdutosCenter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
		);
		
		panelDefaulCenter.setLayout(gl_panelDefaulCenter);
		panelFornecedorCenter.setVisible(false);
		panelClienteCenter.setVisible(true);
		panelVendedorCenter.setVisible(false);
		panelProdutosCenter.setVisible(false);
		
		
        
		
		JLabel lblData = new JLabel("data");
		lblData.setForeground(Color.WHITE);
		
		JLabel lblHora = new JLabel("hora");
		lblHora.setForeground(Color.WHITE);
		
		Thread horario = new Thread(new Runnable() {

            public void run() {
                while (true) {
                	lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar().getTime()));
                	lblHora.setText(new SimpleDateFormat("hh:mm:ss a").format(new GregorianCalendar().getTime()));
                    try {
                        Thread.sleep(1000); // Interromper por 1000 milisegundos
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
		
		horario.start();
		
		JLabel lblSistemaComercialDe = new JLabel("Sistema comercial de Compra e venda");
		lblSistemaComercialDe.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSistemaComercialDe.setForeground(SystemColor.text);
		
		GroupLayout gl_panelTop = new GroupLayout(panelTop);
		gl_panelTop.setHorizontalGroup(
			gl_panelTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTop.createSequentialGroup()
					.addGap(264)
					.addComponent(lblSistemaComercialDe, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
					.addGap(252))
				.addGroup(gl_panelTop.createSequentialGroup()
					.addGap(370)
					.addComponent(lblData, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHora, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addGap(471))
		);
		gl_panelTop.setVerticalGroup(
			gl_panelTop.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelTop.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemaComercialDe, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelTop.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panelTop.setLayout(gl_panelTop);
		
		
		
		
		
		
		JButton btnCliente = new JButton("Cliente");
		
		btnCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panelProdutosCenter.setVisible(false);
				panelFornecedorCenter.setVisible(false);
				panelVendedorCenter.setVisible(false);
				panelClienteCenter.setVisible(true);
//				btnCliente.setBackground(Color.red);
				
			}
		});
		
		
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCliente.setBackground(Colors.COLOR_HOVER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCliente.setBackground(Colors.COLOR_BUTTON);
			}
			
		});
		btnCliente.setFocusable(false);
		btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
		btnCliente.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/cliente-64.png")));
		btnCliente.setBackground(Colors.COLOR_BUTTON);
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 24));
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setBorder(BorderFactory.createEmptyBorder());
		
		
		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panelProdutosCenter.setVisible(false);
				panelClienteCenter.setVisible(false);
				panelVendedorCenter.setVisible(false);
				panelFornecedorCenter.setVisible(true);
				
			}
		});
		btnFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFornecedor.setBackground(Colors.COLOR_HOVER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFornecedor.setBackground(Colors.COLOR_BUTTON);
			}
		});
		btnFornecedor.setFocusable(false);
		btnFornecedor.setHorizontalAlignment(SwingConstants.LEADING);
		btnFornecedor.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/fornecedor-64.png")));
		btnFornecedor.setForeground(Color.WHITE);
		btnFornecedor.setFont(new Font("Arial", Font.PLAIN, 24));
		btnFornecedor.setBackground(Colors.COLOR_BUTTON);
		btnFornecedor.setBorder(BorderFactory.createEmptyBorder());
		
		JButton btnVendedor = new JButton("Vendedor");
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelProdutosCenter.setVisible(false);
				panelClienteCenter.setVisible(false);
				panelFornecedorCenter.setVisible(false);
				panelVendedorCenter.setVisible(true);
			}
		});
		btnVendedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVendedor.setBackground(Colors.COLOR_HOVER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVendedor.setBackground(Colors.COLOR_BUTTON);
			}
		});
		btnVendedor.setFocusable(false);
		btnVendedor.setHorizontalAlignment(SwingConstants.LEADING);
		btnVendedor.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/salesman-64.png")));
		btnVendedor.setForeground(Color.WHITE);
		btnVendedor.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVendedor.setBackground(Colors.COLOR_BUTTON);
		btnVendedor.setBorder(BorderFactory.createEmptyBorder());
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnProdutos.setBackground(Colors.COLOR_HOVER);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnProdutos.setBackground(Colors.COLOR_BUTTON);
			}
		});
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelClienteCenter.setVisible(false);
				panelFornecedorCenter.setVisible(false);
				panelVendedorCenter.setVisible(false);
				panelProdutosCenter.setVisible(true);
			}
		});
		btnProdutos.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/shopping-basket-64.png")));
		btnProdutos.setHorizontalAlignment(SwingConstants.LEADING);
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Arial", Font.PLAIN, 24));
		btnProdutos.setFocusable(false);
		btnProdutos.setBorder(BorderFactory.createEmptyBorder());
		btnProdutos.setBackground(new Color(86, 35, 130));
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setForeground(SystemColor.text);
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Facebook");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openWebpage("https://www.facebook.com/lucas.breitembach");
			}
		});
		lblNewLabel.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/facebook-32-white.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Linkdin");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.linkedin.com/in/lucas-breitembac%CC%B6h-47aa5911a/");
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/linkedin-white-32.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Github");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://github.com/breitembach");
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setIcon(new ImageIcon(InterfaceBase.class.getResource("/images/github-white-32.png")));
		
		JLabel lblLucasBreitembach = new JLabel("Lucas Breitembach");
		lblLucasBreitembach.setForeground(Color.WHITE);
		
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addComponent(btnCliente, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
				.addComponent(btnFornecedor, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
				.addComponent(btnVendedor, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addComponent(btnProdutos, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addComponent(lblLucasBreitembach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelLeft.createSequentialGroup()
							.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLeft.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(lblNewLabel)
									.addGap(14)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_panelLeft.createSequentialGroup()
									.addGap(24)
									.addComponent(lblContato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(32)))
							.addGap(91))))
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(97)
					.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnFornecedor, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(btnVendedor, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnProdutos, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(lblContato, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLucasBreitembach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(145))
		);
		gl_panelLeft.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblNewLabel, lblNewLabel_1, lblNewLabel_2});
		panelLeft.setLayout(gl_panelLeft);
		getContentPane().setLayout(groupLayout);
		
	}
	
	public static void openWebpage(String url) {
		try { 
	         
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
       System.out.println(e.getMessage());
       }
	}
}
