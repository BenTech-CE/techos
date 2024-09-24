
package br.edu.agenda.controle;

import br.edu.agenda.dao.TipoContatoDao;
import br.edu.agenda.interfaces.InterfaceControle;
import br.edu.agenda.modelo.ContatoModelo;
import br.edu.agenda.modelo.TipoContatoModelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

//Implementando a interface.
public class TipoContatoControle implements InterfaceControle{

    TipoContatoModelo tcm = new TipoContatoModelo();
    TipoContatoDao tcd = new TipoContatoDao();
    
    @Override
    public void salvarControle(String... valores) {
        // 0 -> ID
        // 1 -> Descrição
        
        if(valores[0].equals("")){
            tcm.setId(0);
        }else{
            tcm.setId(Integer.parseInt(valores[0]));
        }
        tcm.setDescricao(valores[1]);
         
       
        //Enviar as informações para DAO
        tcd.salvarDao(tcm);
    }

    @Override
    public void excluirControle(int id) {
        tcd.excluirDao(id);
    }

    @Override
    public void carregarComboBox(JComboBox itens) {
        
    }

    @Override
    public void consultarControle(String consulta, DefaultTableModel modelo) {
        try {
            tcd.consultarDao(consulta, modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TipoContatoModelo> consultarControle() {
        try {
            List<TipoContatoModelo> l = tcd.consultarDao();
            
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return new ArrayList<TipoContatoModelo>();
    }
    
}
