
package br.edu.agenda.interfaces;

import br.edu.agenda.modelo.ContatoModelo;
import br.edu.agenda.modelo.TipoContatoModelo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public interface InterfaceDao{
    public void salvarDao(TipoContatoModelo valor);
    
    public void excluirDao(int id); 
    
    public void consultarDao(String consulta, DefaultTableModel modelo) throws SQLException;
    
    public List<?> consultarDao() throws SQLException;
    
    public void carregarComboBoxDao(JComboBox itens) throws SQLException;
    
    public void criarTableCasoNaoExista() throws SQLException;
}
