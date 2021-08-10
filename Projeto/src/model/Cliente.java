/**
 * 
 */
package model;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import controller.Comercial;



/**
 * @author lucas
 *
 */
public class Cliente extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private double limiteCredito;
	
	/**
	 * 
	 * @param codigo Codigo da pessoa
	 * @param nome Description nome
	 * @param telefone Description telefone
	 * @param email Description email
	 * @param dataCadastrada Description data Cadastrada
	 * @param cpf Description cpf
	 * @param limiteCredito Description limite de credito
	 */
	public Cliente(int codigo,String nome,String telefone,String email,Date dataCadastrada,String cpf, double limiteCredito) {
		super(codigo, nome, telefone, email, dataCadastrada);
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}
	public Cliente() {
		
	}
	/**
	 * Método toString
	 */
	public String toString() 
	{
		return super.toString() +
		"CPF    : " + cpf + "\n" +
		"limite Credito    : " + limiteCredito + "\n";
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
	 * @return the limiteCredito
	 */
	public double getLimiteCredito() {
		return limiteCredito;
	}

	/**
	 * @param limiteCredito the limiteCredito to set
	 */
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Override
	public String tipoPessoa() {
		
		return "cliente";
	}

	@Override
	public void atualizarEstatistica(Estatistica objEstatistica) {
		
		HashMap<String, Estatistica> listaEstatisticaCompras = Comercial.getListaEstatisticaComprasCliente();
		
		if(listaEstatisticaCompras.isEmpty()) {
			
			
			listaEstatisticaCompras.put(objEstatistica.getNome(), objEstatistica);
			
			
		}else if(listaEstatisticaCompras.containsKey(objEstatistica.getNome())) {
			listaEstatisticaCompras.get(objEstatistica.getNome()).incrementaQuantidade();
			listaEstatisticaCompras.get(objEstatistica.getNome()).incrementaValorTotal(objEstatistica.getValorTotal());
		}else {
			listaEstatisticaCompras.put(objEstatistica.getNome(), objEstatistica);
		}
		
	}

	
}
