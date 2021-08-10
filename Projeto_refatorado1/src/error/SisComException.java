/**
 * 
 */
package error;

/**
 * @author lucas
 *
 */
public class SisComException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeProduto;
	private int estoque;
	private String messageError;
	
	
	/**
	 * 
	 * @param nomeProduto Description Nome do produto
	 * @param estoque Description Quantidade no Estoque
	 * @param messageError Description Mensagem de erro
	 */
	public SisComException(String nomeProduto, int estoque, String messageError) {
		super(messageError);
		this.nomeProduto = nomeProduto;
		this.estoque = estoque;
		
		
	}


	
	public SisComException(String messageError) {
	
		super(messageError);
	}


	/**
	 * @return nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}


	/**
	 * @param nomeProduto Description seta nome do produto
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	/**
	 * @return estoque
	 */
	public int getEstoque() {
		return estoque;
	}


	/**
	 * 
	 * @param estoque Description text text text
	 */
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	/**
	 * @return messageError
	 */
	public String getMessageError() {
		return messageError;
	}


	/**
	 * @param messageError the messageError to set
	 */
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	
	
}
