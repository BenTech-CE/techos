
package br.edu.agenda.controle;

import br.edu.agenda.dao.ContatoDao;
import br.edu.agenda.interfaces.InterfaceControle;
import br.edu.agenda.modelo.ContatoModelo;
import br.edu.agenda.modelo.TipoContatoModelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

//Implementando a interface.
public class ContatoControle implements InterfaceControle{

    ContatoModelo cm = new ContatoModelo();
    ContatoDao cd = new ContatoDao();
    
    @Override
    public void salvarControle(String... valores) {
        // 0 -> ID
        // 1 -> Descrição
        // 2 -> Nome
        // 3 -> Apelido
        // 4 -> Bairro
        // 5 -> Estado
        // 6 -> Cidade
        // 7 -> Rua
        // 8 -> DDD
        // 9 -> Telefone
        // 10 -> E-mail
        // 11 -> Tipo Contato
        
        if(valores[0].equals("")){
            cm.setId(0);
        }else{
            cm.setId(Integer.parseInt(valores[0]));
        }
        cm.setDescricao(valores[1]);
        
        cm.setNome(valores[2]);
        cm.setApelido(valores[3]);
        cm.setBairro(valores[4]);
        cm.setEstado(valores[5]);
        cm.setCidade(valores[6]);
        cm.setRua(valores[7]);
        if (!valores[8].equals(""))
            cm.setDDD(Integer.parseInt(valores[8]));
        if (!valores[9].equals(""))
            cm.setTelefone(Integer.parseInt(valores[9]));
        cm.setEmail(valores[10]);
        cm.setTipoContato(Integer.parseInt(valores[11]));
         
       
        //Enviar as informações para DAO
        cd.salvarDao(cm);
    }

    @Override
    public void excluirControle(int id) {
        cd.excluirDao(id);
    }

    @Override
    public void carregarComboBox(JComboBox itens) {
        try {
            cd.carregarComboBoxDao(itens);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consultarControle(String consulta, DefaultTableModel modelo) {
        try {
            cd.consultarDao(consulta, modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<ContatoModelo> consultarControle() {
        try {
            List<ContatoModelo> l = cd.consultarDao();
            
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return new ArrayList<ContatoModelo>();
    }
    
}
