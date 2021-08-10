/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author lucas
 *
 */
public class Compra implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ItemCompra> itemCompra = new ArrayList<ItemCompra>();
	private int numeroCompra;
	private Fornecedor fornecedor;
	private Date dataCompra;
	/**
	 * @param numeroCompra
	 * @param fornecedor
	 * @param compraItens
	 * @param dataCompra
	 */
	
	/**
	 * Construct vazio
	 */
	public Compra() {
		
	}
	/**
	 * @param itemCompra Description lista item compra
	 * @param numeroCompra Description numero da compra
	 * @param fornecedor Description objeto Fornecedor
	 * @param dataCompra Description data da compra
	 */
	public Compra (ArrayList<ItemCompra> itemCompra, int numeroCompra, Fornecedor fornecedor, Date dataCompra) {
		this.itemCompra = itemCompra;
		this.numeroCompra = numeroCompra;
		this.fornecedor = fornecedor;
		this.dataCompra = dataCompra;
	}
	public String toString() 
	{
		return
		"Numero de compras    : " + numeroCompra + "\n" +
		"Fornecedor  : " + fornecedor + "\n"+
		"Data da compra: "+ dataCompra + "\n";
	}
	/**
	 * @return the numeroCompra
	 */
	public int getNumeroCompra() {
		return numeroCompra;
	}
	/**
	 * @param numeroCompra the numeroCompra to set
	 */
	public void setNumeroCompra(int numeroCompra) {
		this.numeroCompra = numeroCompra;
	}
	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	/**
	 * @return the compraItens
	 */
	public ArrayList<ItemCompra> getCompraItens() {
		return this.itemCompra;
	}
	/**
	 * @param compraItens the compraItens to set
	 */
	public void setCompraItens(ArrayList<ItemCompra> compraItens) {
		this.itemCompra = compraItens;
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
	
	
}
