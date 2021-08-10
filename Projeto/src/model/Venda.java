/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import utilitarios.LtpLib;

/**
 * @author lucas
 *
 */
public class Venda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ItemVenda> vendaItens = new ArrayList<ItemVenda>();
	
	private int numeroVenda;
	private Cliente cliente;
	private Vendedor vendedor;
	private int formaPagamento;
	private Date dataVenda;
	
	
	public Venda() {
		
	}
	
	/**
	 * @param vendaItens Description lista de iten venda
	 * @param numeroVenda Description numero da venda
	 * @param cliente Description objeto Cliente
	 * @param vendedor Description Objeto Vendedor
	 * @param formaPagamento Description forma de Pagamento
	 * @param dataVenda Description data da venda
	 */
	public Venda(ArrayList<ItemVenda> vendaItens, int numeroVenda, Cliente cliente, Vendedor vendedor, int formaPagamento,
			Date dataVenda) {
		
		this.vendaItens = vendaItens;
		this.numeroVenda = numeroVenda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.formaPagamento = formaPagamento;
		this.dataVenda = dataVenda;
	}

	/**
	 * Método toString
	 */
	public String toString() 
	{
		return
		"Numero de vendas    : " + numeroVenda + "\n" +
		"Cliente  : " + cliente + "\n"+
		"Vendedor : "+ vendedor + "\n" +
		"Forma de pagamento: " + formaPagamento + "\n" +
		"Data da venda: "+ LtpLib.obterDataFormatada(dataVenda) + "\n";
	}
	
	/**
	 * @return the vendaItens
	 */
	public ArrayList<ItemVenda> getVendaItens() {
		return vendaItens;
	}
	/**
	 * @param vendaItens the vendaItens to set
	 */
	public void setVendaItens(ArrayList<ItemVenda> vendaItens) {
		this.vendaItens = vendaItens;
	}
	/**
	 * @return the numeroVenda
	 */
	public int getNumeroVenda() {
		return numeroVenda;
	}
	/**
	 * @param numeroVenda the numeroVenda to set
	 */
	public void setNumeroVenda(int numeroVenda) {
		this.numeroVenda = numeroVenda;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the vendedor
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}
	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	/**
	 * @return the formaPagamento
	 */
	public int getFormaPagamento() {
		return formaPagamento;
	}
	/**
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	/**
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}
	/**
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
	
}
