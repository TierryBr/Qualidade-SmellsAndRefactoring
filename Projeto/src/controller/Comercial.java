/**
 * 
 */
package controller;

import java.io.Serializable;
import java.time.format.TextStyle;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import error.SisComException;
import model.Cliente;
import model.Compra;
import model.Estatistica;
import model.Fornecedor;
import model.ItemCompra;
import model.ItemVenda;
import model.Pessoa;
import model.Produto;
import model.Venda;
import model.Vendedor;
import utilitarios.InterfaceUtil;

/**
 * @author lucas
 *
 */


public class Comercial implements Serializable{
	/**
	 * data Array List
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private static ArrayList<Produto> temporariaListaProdutos = new ArrayList<Produto>();
	private static ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	private static ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	private static HashMap<String, Estatistica> listaEstatisticaVendasFornecedor = new HashMap<String,Estatistica>();
	private static HashMap<String, Estatistica> listaEstatisticaVendasVendedor = new HashMap<String,Estatistica>();
	private static HashMap<String, Estatistica> listaEstatisticaComprasCliente = new HashMap<String,Estatistica>();
	
	
	
	/**
	 * @return the temporariaListaProdutos
	 */
	public static ArrayList<Produto> getTemporariaListaProdutos() {
		return temporariaListaProdutos;
	}
	/**
	 * @param temporariaListaProdutos the temporariaListaProdutos to set
	 */
	public static void setTemporariaListaProdutos(ArrayList<Produto> temporariaListaProdutos) {
		Comercial.temporariaListaProdutos = temporariaListaProdutos;
	}
	/**
	 * @return the listaEstatisticaVendasFornecedor
	 */
	public static HashMap<String, Estatistica> getListaEstatisticaVendasFornecedor() {
		return listaEstatisticaVendasFornecedor;
	}
	/**
	 * @param listaEstatisticaVendasFornecedor the listaEstatisticaVendasFornecedor to set
	 */
	public static void setListaEstatisticaVendasFornecedor(HashMap<String, Estatistica> listaEstatisticaVendasFornecedor) {
		Comercial.listaEstatisticaVendasFornecedor = listaEstatisticaVendasFornecedor;
	}
	/**
	 * @return the listaEstatisticaVendasVendedor
	 */
	public static HashMap<String, Estatistica> getListaEstatisticaVendasVendedor() {
		return listaEstatisticaVendasVendedor;
	}
	/**
	 * @param listaEstatisticaVendasVendedor the listaEstatisticaVendasVendedor to set
	 */
	public static void setListaEstatisticaVendasVendedor(HashMap<String, Estatistica> listaEstatisticaVendasVendedor) {
		Comercial.listaEstatisticaVendasVendedor = listaEstatisticaVendasVendedor;
	}
	/**
	 * @return the listaEstatisticaComprasCliente
	 */
	public static HashMap<String, Estatistica> getListaEstatisticaComprasCliente() {
		return listaEstatisticaComprasCliente;
	}
	/**
	 * @param listaEstatisticaComprasCliente the listaEstatisticaComprasCliente to set
	 */
	public static void setListaEstatisticaComprasCliente(HashMap<String, Estatistica> listaEstatisticaComprasCliente) {
		Comercial.listaEstatisticaComprasCliente = listaEstatisticaComprasCliente;
	}
	/**
	 * 
	 * @param objPessoa Description Adiciona Pessoa na lista
	 */
	public void inserirPessoa(Pessoa objPessoa){
			
		listaPessoas.add(objPessoa);
		
	}
	/**
	 * 
	 * @param objPessoa Description Exclui Pessoa da Lista
	 */
	public void ExcluirPessoa(Pessoa objPessoa) {
		listaPessoas.remove(objPessoa);
	}
	
	/**
	 *  
	 * 
	 * @param cnpj Description Verifica Cnpj do fornecedor
	 * @throws SisComException Description Retorna CNPJ Já Cadastrado
	 */
	public void verificaFornecedorCnpj(String cnpj) throws SisComException {
		for (Pessoa fornecedor : listaPessoas) {
			if(fornecedor instanceof Fornecedor) {
				((Fornecedor) fornecedor).getCnpj().equals(cnpj);
				throw new SisComException("CNPJ Já Cadastrado.");
			}
			
		}
	}
	
	/**
	 * Verifica CPF de Cliente e Vendedor se já existe.
	 * 
	 * @param cpf Description CPF da pessoa
	 * @throws SisComException Description CPF já cadastrado
	 */
	public static void verificaCpf(String cpf) throws SisComException {
		for (Pessoa pessoa : listaPessoas) {
			if(pessoa instanceof Cliente) {
				((Cliente)pessoa).getCpf().equals(cpf);
				throw new SisComException("CPF já cadastrado.");
				
				
			}else if(pessoa instanceof Vendedor) {
				((Vendedor)pessoa).getCpf().equals(cpf);
				throw new SisComException("CPF já cadastrado.");
			}
			
		}
	}
	
	public void inserirProduto(Produto objProduto) throws SisComException {
		
		listaProdutos.add(objProduto);
	}
	
	
	/**
	 * @return the listaPessoas
	 */
	public static ArrayList<Pessoa> getListaPessoas() {
		return listaPessoas;
	}
	/**
	 * @param listaPessoas the listaPessoas to set
	 */
	public static void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
		Comercial.listaPessoas = listaPessoas;
	}
	/**
	 * @return the listaProdutos
	 */
	public static ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	/**
	 * @param listaProdutos the listaProdutos to set
	 */
	public static void setListaProdutos(ArrayList<Produto> listaProdutos) {
		Comercial.listaProdutos = listaProdutos;
	}
	/**
	 * @return the listaCompras
	 */
	public static ArrayList<Compra> getListaCompras() {
		return listaCompras;
	}
	/**
	 * @param listaCompras the listaCompras to set
	 */
	public static void setListaCompras(ArrayList<Compra> listaCompras) {
		Comercial.listaCompras = listaCompras;
	}
	/**
	 * @return the listaVendas
	 */
	public static ArrayList<Venda> getListaVendas() {
		return listaVendas;
	}
	/**
	 * @param listaVendas the listaVendas to set
	 */
	public static void setListaVendas(ArrayList<Venda> listaVendas) {
		Comercial.listaVendas = listaVendas;
	}

	/**
	 * 
	 * @param fornecedor Description objeto Fornecedor
	 * @param listaCompra Description arrayList listaCompra
	 */
	public void fazerCompraFornecedor(Fornecedor fornecedor, ArrayList<ItemCompra> listaCompra) {
		
		Compra compra = new Compra(listaCompra, 1, fornecedor, new Date());
		
		
	}
	
	
	/**
	 * 
	 * @param numeroDaCompra Description numero da compra
	 * @param listaCompra Description lista de compras
	 */
	public void excluirCompraFornecedor(int numeroDaCompra, ArrayList<ItemCompra> listaCompra) {
		for (ItemCompra itemCompra : listaCompra) {
			
			itemCompra.getProduto().decrementarProdutoEstoque(1);
		}
	}
	
	
	
	/**
	 * remove venda
	 * @param numeroVenda Description Numero da venda
	 */
	public void excluirVendaCliente(int numeroVenda) {
		ItemVenda produtoVenda = new ItemVenda();
		for (Venda venda : listaVendas) {
			
			if(venda.getNumeroVenda() == numeroVenda) {
				listaVendas.remove(venda);
				produtoVenda.getProduto().incrementarProdutoEstoque(1);
			}
			
			
		}
		
		
	}
	/**
	 * 
	 * @param tipo Description tipo de pessoa
	 * @return array Pessoas (fornecedor,cliente ou vendedor)
	 * @throws SisComException Description Lista de pessoas vazias
	 */
	public static ArrayList<Pessoa> consultarPessoas(String tipo) throws SisComException {
		ArrayList<Pessoa> pessoasNovas = new ArrayList<Pessoa>();
		if( pessoasNovas.isEmpty()) {
			 throw new SisComException("Não Existem Pessoas para Listar");
		};
	
		for (Pessoa pessoas : listaPessoas) {
			if(tipo == "fornecedor") {
				if(pessoas instanceof Fornecedor) {
					pessoasNovas.add(pessoas);
				}
			}else if(tipo == "cliente") {
				if(pessoas instanceof Cliente) {
					pessoasNovas.add(pessoas);
				}
			}else if(tipo == "vendedor"){
				if(pessoas instanceof Vendedor) {
					pessoasNovas.add(pessoas);
				}
			}
		}
		
		
		try {
			ordenarArrayListNome(pessoasNovas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return pessoasNovas;
	}
	/**
	 * 
	 * @return lista de fornecedores
	 * @throws SisComException Description Não existem fornecedores na lista
	 */
	public static ArrayList<Fornecedor> listaFornecedores() throws SisComException{
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		
		try {
			for (Pessoa fornecedores : listaPessoas) {
				if(fornecedores instanceof Fornecedor) {
					listaFornecedores.add((Fornecedor) fornecedores);
				}
			}
		} catch (Exception e) {
			System.out.println("Não tem Fornecedores na lista"+ e.getMessage());
		}
		
		
		return listaFornecedores;
	}
	
	/**
	 * 
	 * @return lista de fornecedores
	 * @throws SisComException Description nao existem fornecedores na lista
	 */
	public static ArrayList<Vendedor> listaVendedor() throws SisComException{
		ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
		
		try {
			for (Pessoa vendedor : listaPessoas) {
				if(vendedor instanceof Vendedor) {
					listaVendedores.add((Vendedor) vendedor);
				}
			}
		} catch (Exception e) {
			System.out.println("Não tem Fornecedores na lista"+ e.getMessage());
		}
		
		
		return listaVendedores;
	}
	/**
	 * 
	 * @return lista de Clientes
	 * @throws SisComException Description Nao existem clientes na lista
	 */
	public static ArrayList<Cliente> listaClientes() throws SisComException{
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {
			for (Pessoa cliente : listaPessoas) {
				if(cliente instanceof Cliente) {
					listaClientes.add((Cliente) cliente);
				}
			}
		} catch (Exception e) {
			System.out.println("Não tem Clientes na lista"+ e.getMessage());
		}
		
		
		return listaClientes;
	}
	
	public Cliente consultarClienteCpf(String cpf) throws SisComException {
		for (Pessoa cliente : listaPessoas) {
			if(((Cliente)cliente).getCpf().equals(cpf)) {
				return (Cliente) cliente;
			}
		}
		throw new SisComException("Não Existe cliente com esse CPF");
	}
	/**
	 * 
	 * @param cpf Description cpf da pessoa
	 * @param tipo Description string tipo de pessoa
	 * @return objPessoa (fornecedor ou cliente ou vendedor)
	 * @throws SisComException Description Pessoa não encontrada na lista
	 */
	public Pessoa consultarCpf(String cpf, String tipo) throws SisComException {
		for (Pessoa pessoa : listaPessoas) {
			if(tipo == "fornecedor") {
				if(pessoa instanceof Fornecedor) {
					
					if(((Fornecedor) pessoa).getCnpj().contains(cpf)) {
						return (Fornecedor)pessoa;
					}
				}
				
			}else if(tipo == "cliente") {
				if(pessoa instanceof Cliente) {
					if(((Cliente) pessoa).getCpf().contains(cpf)) {
						return (Pessoa)pessoa;
					}
				}
			}else if(tipo == "vendedor"){
				if(pessoa instanceof Vendedor) {
					if(((Vendedor) pessoa).getCpf().contains(cpf)) {
						return (Vendedor)pessoa;
					}
				}
			}
		}
		
		throw new SisComException("Erro! Pessoa não existe.");
	}
	/**
	 * 
	 * @param codigoProduto Description Codigo do produto
	 * @return produto
	 * @throws SisComException Description Não existem produtos na lista
	 */
	public Produto consultarProduto(int codigoProduto)throws SisComException {
	
		for (Produto produto : listaProdutos) {
			if(produto.getCodigo() == codigoProduto) {
				return produto;
			}
		}
		throw new SisComException("Erro, produto não existe");
	}
	/**
	 * 
	 * @return arrayListaOrdenada
	 * @throws SisComException Description Lista de produtos vazia
	 */
	public ArrayList<Produto> obterListaProdutosNomeOrdenada() throws SisComException{
		if(listaProdutos.isEmpty()) {
			throw new SisComException("Erro, Não existe produtos na Lista");
		}
		
		ArrayList<Produto> listaProdutosOrdenada = new ArrayList<Produto>();
		listaProdutosOrdenada.addAll(listaProdutos);
		Collections.sort(listaProdutosOrdenada, new Comparator<Produto>() {
			@Override
			public int compare(Produto o1, Produto o2) {
				
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		return listaProdutosOrdenada;
		
		
	}
	/**
	 * 
	 * @return listaProdutosEstoqueMin
	 * @throws SisComException Description Lista de produtos vazia
	 */
	public ArrayList<Produto> obterListaProdutosEstoqueMin() throws SisComException{
		if(listaProdutos.isEmpty()) {
			throw new SisComException("Erro, não existem produtos");
		}
		ArrayList<Produto> listaProdutosEstoqueMin = new ArrayList<Produto>();
		for (Produto produto : listaProdutos) {
			if(produto.getEstoque() < produto.getEstoqueMinimo()) {
				listaProdutosEstoqueMin.add(produto);
			}
		}
		
		Collections.sort(listaProdutosEstoqueMin, new Comparator<Produto>() {
			@Override
			public int compare(Produto o1, Produto o2) {
				
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		return listaProdutosEstoqueMin;
	}
	
	
	/**
	 * 
	 * @param pessoa Description Objeto pessoa
	 */
	public static void ordenarArrayListNome(ArrayList<Pessoa> pessoa) {
		
		Collections.sort(pessoa,new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		
		
	}
	/**
	 * 
	 * @param id Description id da Pessoa
	 * @return boolean
	 * @throws SisComException Description Pessoa não encontrada para remover
	 */
	public static boolean removerPessoaId(int id) throws SisComException{
		
		for (Pessoa pessoa : listaPessoas) {
			
			if(pessoa.getCodigo() == id) {
				
				listaPessoas.remove(pessoa);
				
				return true;
			}
			
		}
		
		throw new SisComException("Não foi possível remover");
		
	}
	/**
	 * 
	 * @param id Description id do produto
	 * @return boolean
	 * @throws SisComException Description Não existem produtos na lista
	 */
	public static boolean removerProdutoId(int id) throws SisComException{
		
		for (Produto prod: listaProdutos) {
			
			if(prod.getCodigo() == id) {
				
				listaProdutos.remove(prod);
				System.out.println("produtoRemovido"+prod.getNome());
				return true;
			}
			
		}
		
		throw new SisComException("Não foi possível remover produtos");
		
	}
	/**
	 * 
	 * @param search Description Pesquisa da pessoa
	 * @return produtosEncontrados
	 */
	public static ArrayList<Produto> procurarProdutoNome(String search) {
		ArrayList<Produto> produtosEncontrados = new ArrayList<>();
		ArrayList<Produto> todosProdutos = temporariaListaProdutos;
	
		for (Produto produto : todosProdutos) {
			//remove os acentos das String para pesquisa.
			String nomeProd = InterfaceUtil.removeDiacriticalMarks(produto.getNome());
			search = InterfaceUtil.removeDiacriticalMarks(search);
			Matcher regex = Pattern.compile("(?i)"+search).matcher(nomeProd);
			
			if(regex.find()) {
				produtosEncontrados.add(produto);
				
			}
			
		}
		
		return produtosEncontrados;
	}

	
	
	
}
