package utilitarios;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterfaceUtil {
	/**
	 * @author lucas B
	 * @param tabela Description componente tabela
	 * 
	 * 
	 */
	public static void limparTabela(DefaultTableModel tabela) {
		
		tabela.setRowCount(0);

//		int rowCount = tableConsulta.getRowCount();
//		
//		for (int i = rowCount - 1; i >= 0; i--) {
//			tableConsulta.removeRow(i);
//		}
	}
	
	public static int obterOpcaoCombo(JComboBox opcaoPagamento) {
		return opcaoPagamento.getSelectedIndex();
	}
	
	public static int obterOpcaoComboBox(JComboBox opcaoPagamento) {
		int op = 1;
		op = obterOpcaoCombo(opcaoPagamento) == -1 ? 1 :
			 obterOpcaoCombo(opcaoPagamento) == 0 ? 1  :
			 obterOpcaoCombo(opcaoPagamento) == 1 ? 2  : 2;
		
		return op;
	}
	
	public static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
				JTable table = (JTable) component;
				
		        int r = table.rowAtPoint(e.getPoint());
		        
		        if (r >= 0 && r < table.getRowCount()) {
		            table.setRowSelectionInterval(r, r);
		        } 

		        int rowindex = table.getSelectedRow();
		        if (rowindex < 0)
		            return;

			    
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	/**
	 * 
	 * @param string Description string para remover os acentos
	 * @return string
	 */
	public static String removeDiacriticalMarks(String string) {
	    return Normalizer.normalize(string, Form.NFD)
	        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
