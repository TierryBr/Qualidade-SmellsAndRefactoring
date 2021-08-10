/**
 * 
 */
package model;


import java.io.Serializable;
import java.util.Date;

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

	
	
}
