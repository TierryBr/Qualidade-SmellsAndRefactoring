/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author lucas
 *
 */
public class ItemCompra implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private int quantidadeCompra;
	private double valorCompra;
	/**
	 * @param produto Description objeto produto
	 * @param quantidadeCompra Description qauntidade compra
	 * @param valorCompra Description valor total da compra
	 */
	public ItemCompra(Produto produto, int quantidadeCompra, double valorCompra) {
		
		this.produto = produto;
		this.quantidadeCompra = quantidadeCompra;
		this.valorCompra = valorCompra;
	}
	
	/**
	 * Método toString
	 */
	public String toString() 
	{
		return
		"Produto    : " + produto + "\n" +
		"Quantidade comprada  : " + quantidadeCompra + "\n"+
		"valor da compra : "+ valorCompra + "\n";
	}
	
	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}
	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	/**
	 * @return the quantidadeCompra
	 */
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}
	/**
	 * @param quantidadeCompra the quantidadeCompra to set
	 */
	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}
	/**
	 * @return the valorCompra
	 */
	public double getValorCompra() {
		return valorCompra;
	}
	/**
	 * @param valorCompra the valorCompra to set
	 */
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
}
