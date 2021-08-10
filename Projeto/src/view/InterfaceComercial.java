package view;


import java.io.File;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;


import controller.Comercial;
import error.SisComException;
import model.Cliente;
import model.Compra;

import model.Fornecedor;
import model.ItemCompra;
import model.Pessoa;
import model.Produto;
import model.Vendedor;
import utilitarios.Console;
import utilitarios.LtpLib;

public class InterfaceComercial {
	private static Comercial comercial = new Comercial();
	private static Compra objCompra = new Compra();
	
	public static void main(String[] args){


		lerArquivo();
	
		JFrame face = new InterfaceBase();
//		face.setExtendedState(face.MAXIMIZED_BOTH);
//		face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		face.pack();
		
		face.setSize(1250, 750);
		face.setVisible(true);
		menu();
		
		gravarArquivo();
			
	}
	
	/**
	 * Menu
	 */
	private static void menu() 
	{
		int opcao=0;
		do {
			System.out.println("\nMenu ");
			System.out.println("1-Inserir novo Fornecedor");
			System.out.println("2-Excluir Fornecedor");
			
			System.out.println("3-Inserir novo Cliente");
			System.out.println("4-Excluir Cliente");
			
			System.out.println("5-Inserir novo Produto");
			System.out.println("6-Excluir produto");
			
			System.out.println("7-Inserir novo Vendedor");
			System.out.println("8-Excluir vendedor");
			
			System.out.println("9-Fazer Compra Fornecedor");
			System.out.println("10-Excluir compra Fornecedor");
			
			System.out.println("11-Fazer Venda Cliente");
			System.out.println("12-Excluir Venda Cliente");
			
			System.out.println("13-Consultar Fornecedor");
			System.out.println("14-Imprimir lista de Fornecedores");
			
			System.out.println("15-Consultar Cliente");
			System.out.println("16-Imprimir Lista de clientes");
			
			System.out.println("17-Consultar Vendedor");
			System.out.println("18-lista de Vendedores");
			
			System.out.println("19-Consultar Produto");
			System.out.println("20-Imprimir lista de Produtos");
			System.out.println("21-Imprimir lista de produtos estoque abaixo estoque min.");
			
			System.out.println("22-Imprimir lista de vendas por período Cliente");
			
			System.out.println("23-Imprimir lista de vendas por período  Vendedor");
			
			System.out.println("24-Imprimir lista de compras por periodo Fornecedor");
			
			System.out.println("25-Imprimir Estatística de vendas por cliente por período de vendas");
			
			System.out.println("26-Imprimir Estatística de vendas por Vendedor por período de vendas");
			
			System.out.println("27-Imprimir Estatística de Compras por Fornecedor por período de Compras");
			
			
			
			
			System.out.println("0-Sair");
			opcao = Console.readInt("\nOpção: ");
			switch (opcao) {
				case 1:
					inserirFornecedor();
					break;
				case 2:
					excluirFonecedor();
					break;
				case 3:
					inserirCliente();
					
					break;
				case 4:
					excluirCliente();
					break;	
				case 5:
					inserirProduto();
					break;
				case 6:
					excluirProduto();
					break;	
				case 7:
					inserirVendedor();
					break;	
				case 8:
					excluirVendedor();
		     		break;	
				case 9:
					fazerCompraFornecedor();
		     		break;
				case 10:
					excluirCompraFornecedor();
		     		break;		     		
				case 11:
					fazerVendaCliente();
					break;
				case 12:
					excluirVendaCliente();
					break;
				case 13:
					consultarFornecedor();
					break;
				case 14:
					imprimirListaFornecedores();
				    break;
				case 15:
					consultarCliente();
				    break;
				case 16:					    
					imprimirListaClientes();
				    break;
				case 17:    
				    consultarVendedor();
				    break;
				case 18:    
					imprimirListaVendedores();
				    break;
				case 19:    
					consultarProduto();
				    break;
				case 20:
					ImprimirListaProdutosNome();
				    break;
				case 21:
					ImprimirListaProdutosEstoqueMin();
				    break;
				case 22:					    
				
				    break;
				case 23:    
				    
				    break;
				case 24:    
				
				    break;
				case 25:    
					
				    break;
				case 26:    
					
				    break;
				case 0:
					//sai do sistema e salva.
					
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void inserirFornecedor() {
		
			int codigo = 0;
			
			if(Comercial.getListaPessoas().isEmpty()) {
				codigo = 1;
			}else {
				codigo = Comercial.getListaPessoas().size() + 1;
			}
			
			String nome = Console.readLine("Nome do Fornecedor: ");
			String telefone = Console.readLine("Telefone do Fornecedor: ");
			String email = Console.readLine("Email do Fornecedor: ");
			Date dataCadastrada = new Date();
			String cnpj = Console.readLine("CNPJ do Fornecedor: ");
			String nomeContato = Console.readLine("Nome do Contato: ");
			
			Fornecedor fornecedor = new Fornecedor(codigo, nome, telefone, email, dataCadastrada, cnpj, nomeContato);
			Comercial.getListaPessoas().add(fornecedor);
			
		
	}
	private static void excluirFonecedor() {
		
	}
	
	private static void inserirCliente() {
		int codigo = 0;
		String nome = "";
		String telefone;
		String email;
		Date dataCadastrada;
		String cpf;
		double limiteCredito;
		
		if(Comercial.getListaPessoas().isEmpty()) {
			codigo = 1;
		}else {
			codigo = Comercial.getListaPessoas().size() + 1;
		}
		
		nome = Console.readLine("Nome do Cliente: ");
		telefone = Console.readLine("Telefone do Cliente: ");
		email = Console.readLine("Email do Cliente: ");
		dataCadastrada = new Date();
		cpf = Console.readLine("CPF do Cliente: ");
		limiteCredito = Console.readDouble("limite de credito do Cliente: ");
		
		Cliente cliente = new Cliente(codigo, nome, telefone, email, dataCadastrada, cpf, limiteCredito);
		Comercial.getListaPessoas().add(cliente);
		
	}
	
	private static void excluirCliente() {
		
	}
	
	

	private static void inserirProduto() {
		int codigo = 0;
		String nome = "";
		double precoUnitario;
		int estoque;
		int estoqueMinimo;
		Date dataCadastrada;
		if(Comercial.getListaProdutos().isEmpty()) {
			codigo = 1;
		}else {
			codigo = Comercial.getListaProdutos().size() + 1;
		}
		
		nome = Console.readLine("Nome do Produto: ");
		precoUnitario = Console.readDouble("Preço Unitário: ");
		estoque = Console.readInt("Quantidade de estoque: ");
		estoqueMinimo = Console.readInt("Quantidade de Estoque minímo: ");
		dataCadastrada= new Date();
		
		Produto produto = new Produto(codigo, nome, precoUnitario, estoque, estoqueMinimo, dataCadastrada);
		Comercial.getListaProdutos().add(produto);
		
	}
	
	private static void excluirProduto() {
		// TODO Auto-generated method stub
		
	}
	
	private static void inserirVendedor() {
		int codigo = 0;
		String nome = "";
		String telefone;
		String email;
		Date dataCadastrada;
		String cpf;
		double metaMensal;
		
		if(Comercial.getListaPessoas().isEmpty()) {
			codigo = 1;
		}else {
			codigo = Comercial.getListaPessoas().size() + 1;
		}
		
		nome = Console.readLine("Nome do Cliente: ");
		telefone = Console.readLine("Telefone do Cliente: ");
		email = Console.readLine("Email do Cliente: ");
		dataCadastrada = new Date();
		cpf = Console.readLine("CPF do Cliente: ");
		metaMensal = Console.readDouble("meta Mensal: ");
		
		Vendedor vendedor = new Vendedor(codigo, nome, telefone, email, dataCadastrada, cpf, metaMensal);
		Comercial.getListaPessoas().add(vendedor);
		
	}
	private static void excluirVendedor() {
		//TODO
		
		
	}
	public static void fazerCompraFornecedor() {
		String cnpj = Console.readLine("Digite CNPJ do fornecedor");
		
		Fornecedor fornecedor = null;
		try {
			fornecedor = (Fornecedor) comercial.consultarCpf(cnpj,"fornecedor");
		} catch (SisComException e) {
			
			System.out.println(e.getMessage());
		}
		Produto produto = new Produto(1, "Lucas", 200, 1, 0, new Date());
		ItemCompra itemCompra = new ItemCompra(produto, 1, 1200);
		
		objCompra.getCompraItens().add(itemCompra);

		comercial.fazerCompraFornecedor(fornecedor, objCompra.getCompraItens());
		
	}
	
	
	
	public static void consultarClienteCpf() {
		String cpf = Console.readLine("Digite o CPF do cliente");
		
		Cliente cliente;
		try {
			cliente = comercial.consultarClienteCpf(cpf);
			System.out.println(cliente.toString());
		} catch (SisComException e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	public static void excluirCompraFornecedor () {
		
	}
	
	public static void fazerVendaCliente() {
		
	}
	
	public static void excluirVendaCliente() {
		
	}
	/**
	 * consultar Fornecedor
	 */
	public static void consultarFornecedor() {
		String cnpj = Console.readLine("Digite CNPJ do fornecedor: ");
		
		try {
			comercial.consultarCpf(cnpj, "fornecedor");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void imprimirListaFornecedores() {

		try {
			ArrayList<Pessoa> fornecedores = comercial.consultarPessoas("fornecedor");
			
			for (Pessoa fornecedor : fornecedores) {
				System.out.println(fornecedor.toString());
			}
//		System.out.println(comercial.consultarPessoas("fornecedor"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * consultar cliente
	 */
	public static void consultarCliente() {
		String cpf = Console.readLine("Digite o CPF do cliente: ");
		
		try {
			System.out.println(comercial.consultarCpf(cpf, "cliente").toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Listar todos clientes
	 */
	public static void imprimirListaClientes() {
		
		
		try {
			System.out.println(comercial.consultarPessoas("cliente"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * método Consultar vendedor
	 */
	public static void consultarVendedor () {
		String cpf = Console.readLine("Digite o CPF do vendedor: ");
		
		try {
			System.out.println(comercial.consultarCpf(cpf, "vendedor").toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 */
	public static void imprimirListaVendedores() {

		try {
			ArrayList<Pessoa> vendedores = comercial.consultarPessoas("vendedor");
			
			for (Pessoa vendedor : vendedores) {
				System.out.println(vendedor.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 */
	public static void consultarProduto() {
		
		int codigoProduto = Console.readInt("Digite o código do produto: ");
		try {
			System.out.println("----PRODUTO ENCONTRADO----");
			System.out.println(comercial.consultarProduto(codigoProduto).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void ImprimirListaProdutosNome() {
		try {
			
			
			for (Produto produto : comercial.obterListaProdutosNomeOrdenada()) {
				System.out.println(produto.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void ImprimirListaProdutosEstoqueMin() {
		try {
			
			for (Produto produto : comercial.obterListaProdutosEstoqueMin()) {
				System.out.println(produto.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void lerArquivo() {
		
		// ler cadastro de Compras
		if (new File("Compras.obj").exists()) {
			try {
				Comercial.setListaCompras(LtpLib.lerArquivoObjetosArray("Compras.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		// ler cadastro de Produtos
		if (new File("Produtos.obj").exists()) {
			try {
				Comercial.setListaProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
				Comercial.setTemporariaListaProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(2);
			}
		}
		// ler cadastro de Pessoas
		if (new File("Pessoas.obj").exists()) {
			try {
				Comercial.setListaPessoas(LtpLib.lerArquivoObjetosArray("Pessoas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(3);
			}
		}
		
		// ler cadastro de Vendas
		if (new File("Vendas.obj").exists()) {
			try {
				Comercial.setListaVendas(LtpLib.lerArquivoObjetosArray("Vendas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(4);
			}
		}
		
		// ler cadastro de Estatísticas Fornecedor
		if (new File("ListaEstatisticaVendasFornecedor.obj").exists()) {
			try {
				Comercial.setListaEstatisticaVendasFornecedor(
						(LtpLib.lerArquivoObjetosHashMap("ListaEstatisticaVendasFornecedor.obj")));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(5);
			}
		}
		
		// ler cadastro de Estatísticas Vendedor
		if (new File("ListaEstatisticaVendasVendedor.obj").exists()) {
			try {
				Comercial.setListaEstatisticaVendasVendedor((
						(LtpLib.lerArquivoObjetosHashMap("ListaEstatisticaVendasVendedor.obj"))));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(6);
			}
		}
		
		// ler cadastro de Estatísticas Compras
		if (new File("ListaEstatisticaComprasCliente.obj").exists()) {
			try {
				Comercial.setListaEstatisticaComprasCliente((
						(LtpLib.lerArquivoObjetosHashMap("ListaEstatisticaComprasCliente.obj"))));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(7);
			}
		}
		
		
		
		
	}
	public static void gravarArquivo() {
		
		// gravar cadastro de alunos
		try {
			LtpLib.gravarArquivoObjetosArray("Compras.obj", Comercial.getListaCompras());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(5);
		}

		// gravar cadastro de cursos
		try {
			LtpLib.gravarArquivoObjetosArray("Produtos.obj", Comercial.getListaProdutos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(6);
		}

		// gravar cadastro de matriculas
		try {
			LtpLib.gravarArquivoObjetosArray("Pessoas.obj", Comercial.getListaPessoas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(7);
		}
		
		// gravar cadastro de matriculas
		try {
			LtpLib.gravarArquivoObjetosArray("Vendas.obj", Comercial.getListaVendas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(7);
		}
		
		// Gravar Estatistica de fornecedor
		try {
			LtpLib.gravarArquivoObjetosHashMap(
					"ListaEstatisticaVendasFornecedor.obj", Comercial.getListaEstatisticaVendasFornecedor());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(8);
		}
		
		// Gravar Estatistica de Vendedor
		try {
			LtpLib.gravarArquivoObjetosHashMap(
					"ListaEstatisticaVendasVendedor.obj", Comercial.getListaEstatisticaVendasVendedor());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(9);
		}
		
		// Gravar Estatistica de Cliente
		try {
			LtpLib.gravarArquivoObjetosHashMap(
					"ListaEstatisticaComprasCliente.obj", Comercial.getListaEstatisticaComprasCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(10);
		}

		// fechamento da aplicação
		System.out.println("Sistema finalizado.");
		System.exit(0);
		
	}
	
	
	
	

}
