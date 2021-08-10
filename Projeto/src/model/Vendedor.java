/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import controller.Comercial;
import error.SisComException;

/**
 * @author lucas
 *
 */
public class Vendedor extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private double metaMensal;
	/**
	 * @param codigo Description codigo
	 * @param nome Description nome
	 * @param telefone Description telefone
	 * @param email Description email
	 * @param dataCadastrada Description data Cadastrada
	 * @param cpf Description cpf
	 * @param metaMensal Description meta Mensal
	 */
	public Vendedor(int codigo, String nome, String telefone, String email, Date dataCadastrada, String cpf,
			double metaMensal) {
		super(codigo, nome, telefone, email, dataCadastrada);
		this.cpf = cpf;
		this.metaMensal = metaMensal;
	}
	
	/**
	 * Contrutor Vazio
	 */
	
	public Vendedor() {
		
	}


	/**
	 * Método toString
	 */
	public String toString() 
	{
		return super.toString() +
		"CPF    : " + cpf + "\n" +
		"Meta mensal   : " + metaMensal+ "\n";
	}
	
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the metaMensal
	 */
	public double getMetaMensal() {
		return metaMensal;
	}
	/**
	 * @param metaMensal the metaMensal to set
	 */
	public void setMetaMensal(double metaMensal) {
		this.metaMensal = metaMensal;
	}
	
	public boolean verificaMetaMensal(double metaMensal) throws SisComException {
		if(metaMensal <= 0) {
			return false;
		}
		return true;
	}

	@Override
	public String tipoPessoa() {
		
		return "vendedor";
	}

	@Override
	public void atualizarEstatistica(Estatistica objEstatistica) {
		
		HashMap<String, Estatistica> listaEstatisticaVendas = Comercial.getListaEstatisticaVendasVendedor();
		
		if(listaEstatisticaVendas.isEmpty()) {
			
			
			listaEstatisticaVendas.put(objEstatistica.getNome(), objEstatistica);
			
			
		}else if(listaEstatisticaVendas.containsKey(objEstatistica.getNome())) {
			listaEstatisticaVendas.get(objEstatistica.getNome()).incrementaQuantidade();
			listaEstatisticaVendas.get(objEstatistica.getNome()).incrementaValorTotal(objEstatistica.getValorTotal());
		}else {
			listaEstatisticaVendas.put(objEstatistica.getNome(), objEstatistica);
		}
		
	}
	
	
}
