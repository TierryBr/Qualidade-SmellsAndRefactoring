package utilitarios;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

import javax.swing.JTable;
import javax.swing.TransferHandler;

import javax.swing.table.DefaultTableModel;

import controller.Comercial;
import model.Produto;


/**
 * 
 * @author lucas
 * 
 */
public class CustomTransferHandler extends TransferHandler{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void exportDone(JComponent comp, Transferable trans, int action) {
		
		// RETORNA FALSO SE NÂO ACHAR O COMPOENENT DROP
        if (action != MOVE) {
          return;
        }
       
        JTable tabelaClicada =(JTable)comp;
        
        DefaultTableModel tabelaClicadaModelo = (DefaultTableModel) tabelaClicada.getModel();
        
        int row = tabelaClicada.getSelectedRow();
        
      ArrayList<Produto> tempListaProd = Comercial.getTemporariaListaProdutos();
      int idProd = Integer.parseInt(tabelaClicada.getValueAt(row, 0).toString());
      
	  	try {
	  		// resolvendo o problema com foreach remove obj
	  		for (Iterator<Produto> it = tempListaProd.iterator(); it.hasNext();) {
	  			Produto prod = it.next();
				if(prod.getCodigo() == idProd) {
					it.remove();
				}
			}

	  		
	  		tabelaClicadaModelo.removeRow(row);
	 
	  		// ler cadastro de Produtos
			if (new File("Produtos.obj").exists()) {
				try {
					Comercial.setListaProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.exit(11);
				}
			}
	      
		} catch (Exception e) {
			System.out.println("Não foi possível remover produto temporário"+e.getMessage());
			
		}
		
        
      }
	
	@Override
	public int getSourceActions(JComponent c) {
         return MOVE;
     }
	 
	 //QUAndo CLICA FAZ ISSO
	@Override
     public Transferable createTransferable(JComponent comp) {
         JTable tabelaClicada =(JTable)comp;
        
         DefaultTableModel tabelaClicadaModelo = (DefaultTableModel) tabelaClicada.getModel();

         Object linhaCompleta = tabelaClicadaModelo.getDataVector().elementAt(tabelaClicada.getSelectedRow());
        
         StringSelection transferable = new StringSelection(""+linhaCompleta);
   
         return transferable;
     }
     @Override
     public boolean canImport(TransferHandler.TransferSupport info){
         if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)){
        	 System.out.println("Não importou ");
             return false;
         }
         
         return true;
     }
     @Override
     public boolean importData(TransferSupport support) {
    	
         if (!support.isDrop()) {
        	 System.out.println("importDataError");
             return false;
         }

         if (!canImport(support)) {
        	 System.out.println("Nao pode importar");
             return false;
             
         }
         
         // pega o component que vai dropar
         
         JTable table= (JTable)support.getComponent();
         
         
         DefaultTableModel tableModel=(DefaultTableModel)table.getModel();

        
         String data;
         try {
             data = (String)support.getTransferable().getTransferData(DataFlavor.stringFlavor);
             
            
         } catch (UnsupportedFlavorException e) {
             return false;
         } catch (IOException e) {
             return false;
         }
        
         
//         Remove os Colchetes
         data = data.replaceAll("\\[|\\]","");
         //remove a vírgula
         Object[] rows = data.split(",");

         tableModel.addRow(rows);
        
         return true;
     }
    
     
    
    
}
