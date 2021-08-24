/**
 * 
 */
package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

import controller.Comercial;
import error.SisComException;
import utilitarios.Console;

/**
 * @author lucas
 *
 */

public class Produto implements Comparable<Produto>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueMinimo;
	private Date dataCadastrada;
	private static Comercial comercial = new Comercial();
	
	private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	

	/**
	 * @param codigo Description codigo
	 * @param nome Description nome 
	 * @param precoUnitario Description preco unitário
	 * @param estoque Description estoque
	 * @param estoqueMinimo Description estoque minímo
	 * @param dataCadastrada Description data cadastrada
	 */
	public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueMinimo, Date dataCadastrada) {
	
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueMinimo = estoqueMinimo;
		this.dataCadastrada = dataCadastrada;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Método toString
	 */
	public String toString() 
	{
		return
		"Codigo    : " + codigo + "\n" +
		"Nome  : " + nome + "\n"+
		"Preço Unitário : "+ precoUnitario + "\n"+
		"Estoque : "+ estoque + "\n" +
		"Estoque mínimo : " +estoqueMinimo+ "\n" +
		"Data Cadastrada :  " + dataCadastrada +"\n";
	}
	
	/**
	 * 
	 * @param quantidade Description quantidade de prod para incrementar
	 */
	public void incrementarProdutoEstoque(int quantidade) {
		this.estoque += quantidade;
	}
	
	/**
	 * 
	 * @param quantidade Description quantidade de produtos para decrementar
	 */
	public void decrementarProdutoEstoque(int quantidade) {
		this.estoque -= quantidade;
	}
	@Override
	public int compareTo(Produto objProduto) {
	
		return this.nome.compareTo(objProduto.nome);
	}
	

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the precoUnitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * @return the estoque
	 */
	public int getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque the estoque to set
	 */
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	/**
	 * @return the estoqueMinimo
	 */
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	/**
	 * @param estoqueMinimo the estoqueMinimo to set
	 */
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	/**
	 * @return the dataCadastrada
	 */
	public Date getDataCadastrada() {
		return dataCadastrada;
	}

	/**
	 * @param dataCadastrada the dataCadastrada to set
	 */
	public void setDataCadastrada(Date dataCadastrada) {
		this.dataCadastrada = dataCadastrada;
	}

	public DefaultTableModel mostraTabelaDeProdutosUnico() {
		Object[] titleRow = { "Código", "Nome", "Preço Unitário", "Quantidade" };
		Object[][] data = new Object[1][titleRow.length];
		for (int i = 0; i < 1; i++) {
			data[i][0] = getCodigo();
			data[i][1] = getNome();
			data[i][2] = getPrecoUnitario();
			data[i][3] = 1;
		}
		DefaultTableModel model = new DefaultTableModel(data, titleRow);
		return model;
	}
	
	
	public static ArrayList<Produto> obterListaProdutosEstoqueMin() throws SisComException{
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
	
	
	public static void consultarProduto() {
		
		int codigoProduto = Console.readInt("Digite o código do produto: ");
		
		Produto produto;
		try {
			//System.out.println("----PRODUTO ENCONTRADO----");
			produto = consultarProduto(codigoProduto);
			System.out.println(produto.toString());
			
		} catch (Exception e) {
			System.out.println("Codigo invalido");
		}
	}
	
	public static Produto consultarProduto(int codigoProduto) {
		
		for (Produto produto : listaProdutos) {
			if(produto.getCodigo() == codigoProduto) {
				return produto;
			}
		}
		return null;
	}

	
	
}
