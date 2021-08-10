/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author lucas
 *
 */
public class ItemVenda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private int quantidadeVenda;
	private double valorVenda;
	
	
	/**
	 * @param produto Description objeto produto
	 * @param quantidadeVenda Description quantidade de vendas
	 * @param valorVenda Description valor da venda
	 */
	public ItemVenda(Produto produto, int quantidadeVenda, double valorVenda) {
		
		this.produto = produto;
		this.quantidadeVenda = quantidadeVenda;
		this.valorVenda = valorVenda;
	}
	public ItemVenda() {
		
	}

	/**
	 * Método toString
	 */
	public String toString() 
	{
		return
		"Produto    : " + produto + "\n" +
		"Quantidade Vendida  : " + quantidadeVenda + "\n"+
		"Valor Venda : "+ valorVenda + "\n";
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
	 * @return the quantidadeVenda
	 */
	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}

	/**
	 * @param quantidadeVenda the quantidadeVenda to set
	 */
	public void setQuantidadeVenda(int quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}

	/**
	 * @return the valorVenda
	 */
	public double getValorVenda() {
		return valorVenda;
	}

	/**
	 * @param valorVenda the valorVenda to set
	 */
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
	
}
