package model;

import java.io.Serializable;
import java.util.Date;


public class Estatistica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int quantidade;
	private double valorTotal;
	private Date dataCompra;
	
	/**
	 * 
	 * @param nome Description nome
	 * @param quantidade Description quantidade
	 * @param valorTotal Description valor total da compra
	 * @param dataCompra Description data da compra
	 */
	public Estatistica(String nome, int quantidade, double valorTotal,Date dataCompra) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.dataCompra = dataCompra;
	}
	
	/**
	 * @return the dataCompra
	 */
	public Date getDataCompra() {
		return dataCompra;
	}

	/**
	 * @param dataCompra the dataCompra to set
	 */
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
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
	 * @return the quantCompra
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantCompra the quantCompra to set
	 */
	public void setQuantidade(int quantCompra) {
		this.quantidade = quantCompra;
	}
	/**
	 * @return the valorTotal
	 */
	public double getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * Decrementa produto
	 */
	public void incrementaQuantidade() {
		this.quantidade++;
	}
	/**
	 * 
	 * @param valor Description valor para incrementar
	 */
	public void incrementaValorTotal(double valor) {
		this.valorTotal += valor;
	}
	
	public String toString() 
	{
		return
		"\nNome : " + nome + "\n" +
		"Quantidade de vendas  : " + quantidade + "\n"+
		"Valor total de vendas: "+ valorTotal + "\n";
	}
	
	
	
	
}
