/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Date;


import utilitarios.LtpLib;



/**
 * @author lucas
 *
 */
public abstract class Pessoa implements Serializable, Comparable<Pessoa>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private Date dataCadastrada;
	

	
	/**
	 * @param codigo Description codigo
	 * @param nome Description nome
	 * @param telefone Description telefone
	 * @param email Description email
	 * @param dataCadastrada Description data Cadastrada
	 */
	public Pessoa(int codigo, String nome, String telefone, String email, Date dataCadastrada) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastrada = dataCadastrada;
		
	}
	
	
	public Pessoa() {
		
	}
	/**
	 * Método toString
	 */
	public String toString() 
	{
		return
		"Código    : " + codigo + "\n" +
		"Nome    : " + nome + "\n" +
		"Telefone   : " + telefone + "\n" +
		"E-mail    : " + email + "\n" +
		"Data cadastrada   : " + LtpLib.obterDataFormatada(dataCadastrada) + "\n";
	}
		
	
	/**
	 * Método compareTo
	 */
	public int compareTo(Pessoa objPessoa){
		return this.nome.compareTo(objPessoa.nome);
	}
	
	/**
	 * 
	 * @return string
	 */
	public abstract String tipoPessoa();
	
	 /**
	  * 
	  * @param objEstatistica Description objeto estatistica
	  */
	public abstract void atualizarEstatistica(Estatistica objEstatistica);


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
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
