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
	private static Produto produto = new Produto();
	private static Cliente cliente = new Cliente();
	private static Vendedor vendedor = new Vendedor();
	
	public static void main(String[] args){


		lerArquivoCompras();
		lerArquivoProdutos();
		lerArquivoPessoas();
		lerArquivoVendas();
		lerArquivoEstatísticasFornecedor();
		lerArquivoEstatísticasVendedor();
		lerArquivoEstatísticasCompras();
	
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
	public static void menu() 
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
					Comercial.inserirFornecedor();
					break;
				case 2:
					InterfaceComercial.excluirFonecedor();
					break;
				case 3:
					Comercial.inserirCliente();
					
					break;
				case 4:
					InterfaceComercial.excluirCliente();
					break;	
				case 5:
					Comercial.inserirProduto();
					break;
				case 6:
					InterfaceComercial.excluirProduto();
					break;	
				case 7:
					Comercial.inserirVendedor();
					break;	
				case 8:
					InterfaceComercial.excluirVendedor();
		     		break;	
				case 9:
					InterfaceComercial.fazerCompraFornecedor();
		     		break;
				case 10:
					InterfaceComercial.excluirCompraFornecedor();
		     		break;		     		
				case 11:
					InterfaceComercial.fazerVendaCliente();
					break;
				case 12:
					InterfaceComercial.excluirVendaCliente();
					break;
				case 13:
					InterfaceComercial.consultarFornecedor();
					break;
				case 14:
					InterfaceComercial.imprimirListaFornecedores();
				    break;
				case 15:
					Cliente.consultarCliente();
				    break;
				case 16:					    
					InterfaceComercial.imprimirListaClientes();
				    break;
				case 17:    
					Vendedor.consultarVendedor();
				    break;
				case 18:    
					InterfaceComercial.imprimirListaVendedores();
				    break;
				case 19:    
					Produto.consultarProduto();
				    break;
				case 20:
					InterfaceComercial.ImprimirListaProdutosNome();
				    break;
				case 21:
					InterfaceComercial.ImprimirListaProdutosEstoqueMin();
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

	
	public static void excluirFonecedor() {
		
	}
	
	
	
	public static void excluirCliente() {
		
	}
	
	
	
	public static void excluirProduto() {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void excluirVendedor() {
		//TODO
		
		
	}
	public static void fazerCompraFornecedor() {
		String cnpj = Console.readLine("Digite CNPJ do fornecedor");
		
		Fornecedor fornecedor = null;
		try {
			fornecedor = (Fornecedor) Comercial.consultarCpf(cnpj,"fornecedor");
		} catch (SisComException e) {
			
			System.out.println(e.getMessage());
		}
		Produto produto = new Produto(1, "Lucas", 200, 1, 0, new Date());
		ItemCompra itemCompra = new ItemCompra(produto, 1, 1200);
		
		objCompra.getCompraItens().add(itemCompra);

		comercial.fazerCompraFornecedor(fornecedor, objCompra.getCompraItens());
		
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
			Comercial.consultarCpf(cnpj, "fornecedor");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void imprimirListaFornecedores() {

		try {
			ArrayList<Pessoa> fornecedores = Comercial.consultarPessoas("fornecedor");
			
			for (Pessoa fornecedor : fornecedores) {
				System.out.println(fornecedor.toString());
			}
//		System.out.println(comercial.consultarPessoas("fornecedor"));
		} catch (Exception e) {
			System.out.println("Erro ao imprimir lista");
		}
	}
	
	/**
	 * Listar todos clientes
	 */
	public static void imprimirListaClientes() {
		
		
		try {
			System.out.println(Comercial.consultarPessoas("cliente"));
		} catch (Exception e) {
			System.out.println("Erro ao imprimir lista");
		}
	}
	/**
	 * método Consultar vendedor
	 */
	
	/**
	 * 
	 */
	public static void imprimirListaVendedores() {

		try {
			ArrayList<Pessoa> vendedores = Comercial.consultarPessoas("vendedor");
			
			for (Pessoa vendedor : vendedores) {
				System.out.println(vendedor.toString());
			}

		} catch (Exception e) {
			System.out.println("Erro ao imprimir lista");
		}
	}
	/**
	 * 
	 */
	
	
	public static void ImprimirListaProdutosNome() {
		try {
			
			
			for (Produto produto : comercial.obterListaProdutosNomeOrdenada()) {
				System.out.println(produto.toString());
			}

		} catch (Exception e) {
			System.out.println("Erro ao imprimir lista");
		}
	}
	
	public static void ImprimirListaProdutosEstoqueMin() {
		try {
			
			for (Produto produto : Produto.obterListaProdutosEstoqueMin()) {
				System.out.println(produto.toString());
			}
		} catch (Exception e) {
			System.out.println("Erro ao imprimir lista");
		}
	}
	

	public static void lerArquivoCompras() {
		// ler cadastro de Compras
		if (new File("Compras.obj").exists()) {
			try {
				Comercial.setListaCompras(LtpLib.lerArquivoObjetosArray("Compras.obj"));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de compras" + e);
				System.exit(1);
			}
		}
	}
	
	public static void lerArquivoProdutos() {
		// ler cadastro de Produtos
		if (new File("Produtos.obj").exists()) {
			try {
				Comercial.setListaProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
				Comercial.setTemporariaListaProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de produtos" + e);
				System.exit(2);
			}
		}
	}
	
	public static void lerArquivoPessoas() {
		// ler cadastro de Pessoas
		if (new File("Pessoas.obj").exists()) {
			try {
				Comercial.setListaPessoas(LtpLib.lerArquivoObjetosArray("Pessoas.obj"));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de pessoas" + e);
				System.exit(3);
			}
		}
	}
	
	public static void lerArquivoVendas() {
		// ler cadastro de Vendas
		if (new File("Vendas.obj").exists()) {
			try {
				Comercial.setListaVendas(LtpLib.lerArquivoObjetosArray("Vendas.obj"));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de vendas" + e);
				System.exit(4);
			}
		}
	}
	
	public static void lerArquivoEstatísticasFornecedor() {
		// ler cadastro de Estatísticas Fornecedor
		if (new File("ListaEstatisticaVendasFornecedor.obj").exists()) {
			try {
				Comercial.setListaEstatisticaVendasFornecedor(
						(LtpLib.lerArquivoObjetosHashMap("ListaEstatisticaVendasFornecedor.obj")));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de estatistica de fornecedor" + e);
				System.exit(5);
			}
		}
	}
	
	public static void lerArquivoEstatísticasVendedor() {
		// ler cadastro de Estatísticas Vendedor
		if (new File("ListaEstatisticaVendasVendedor.obj").exists()) {
			try {
				Comercial.setListaEstatisticaVendasVendedor((
						(LtpLib.lerArquivoObjetosHashMap("ListaEstatisticaVendasVendedor.obj"))));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de estatistica do vendedor" + e);
				System.exit(6);
			}
		}
	}
	
	public static void lerArquivoEstatísticasCompras() {
		// ler cadastro de Estatísticas Compras
		if (new File("ListaEstatisticaComprasCliente.obj").exists()) {
			try {
				Comercial.setListaEstatisticaComprasCliente((
						(LtpLib.lerArquivoObjetosHashMap("ListaEstatisticaComprasCliente.obj"))));
			} catch (Exception e) {
				System.out.println("Erro ao ler arquivos de estatica de compras" + e);
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
