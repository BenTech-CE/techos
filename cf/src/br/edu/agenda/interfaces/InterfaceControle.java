
package br.edu.agenda.interfaces;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public interface InterfaceControle {
    public void salvarControle(String... valores);
    public void excluirControle(int id);
    public void consultarControle(String consulta, DefaultTableModel modelo);
    public List<?> consultarControle();
    public void carregarComboBox(JComboBox itens);
    
    
}
