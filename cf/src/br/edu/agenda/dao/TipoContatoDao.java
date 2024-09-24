
package br.edu.agenda.dao;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.edu.agenda.interfaces.InterfaceDao;
import br.edu.agenda.modelo.ContatoModelo;
import br.edu.agenda.modelo.TipoContatoModelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoContatoDao implements InterfaceDao {
    
    //Armazenará os comandos para inclusão, alteração, consulta e exclusão.
    String sql;
    PreparedStatement stm;
    ResultSet resultado;
    
    
    @Override
    public void salvarDao(TipoContatoModelo tcm){
        try {
            // Para evitar erros, é necessário que a tabela tipo_contato exista! Fazemos uma verificação e se não existir, criamos agora mesmo.
            criarTableCasoNaoExista();
        
            //Descobrir se é uma inclusão ou alteração.
            if(tcm.getId() == 0){
                sql = "INSERT INTO tipo_contato (descricao) VALUES (?)";
            }else{
                sql = "UPDATE tipo_contato SET descricao=? WHERE id_tipo_contato=?";
            }
            
            // Preparando e manipulando os dados
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            
            //1° ? encontrado será substituído pela descrição, o segundo, pelo ID.
            
            //Porém, se o ID for zero ele faz a inclusão e não utiliza a outra linha de código, dedicada à alteração.
            stm.setString(1, tcm.getDescricao());
            
            //Nesse caso, é uma alteração, já que o ID é maior que zero!
            if(tcm.getId() > 0){
                stm.setInt(2, tcm.getId());
            }
            
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Registro criado!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void excluirDao(int id){
        try {
            // Para evitar erros, é necessário que a tabela tipo_contato exista! Fazemos uma verificação e se não existir, criamos agora mesmo.
            criarTableCasoNaoExista();
            
            sql = "DELETE FROM tipo_contato WHERE id_tipo_contato=?";
            
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o registro.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    @Override
    public void consultarDao(String consulta, DefaultTableModel modelo) throws SQLException{
        // Para evitar erros, é necessário que a tabela tipo_contato exista! Fazemos uma verificação e se não existir, criamos agora mesmo.
        criarTableCasoNaoExista();
        
        if (consulta.equals(""))
            sql = "SELECT * FROM tipo_contato";
        else 
            sql = "SELECT * FROM tipo_contato WHERE descricao LIKE '%"+ consulta + "%'";
                
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();
        
        while (resultado.next()) {
            modelo.addRow(
                    new Object[] {
                        resultado.getInt("id_tipo_contato"),
                        resultado.getString("descricao")
                    }
            );
        }
        
        stm.close();
    }
    
    @Override
    public void carregarComboBoxDao(JComboBox itens) throws SQLException{
    
    }
    
    @Override
    public void criarTableCasoNaoExista() throws SQLException {
        sql = "CREATE TABLE IF NOT EXISTS tipo_contato ("
                    + "\"id_tipo_contato\" INTEGER, "
                    + "\"descricao\" TEXT, "
                    + "PRIMARY KEY(\"id_tipo_contato\")"
                    + ");";
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        stm.executeUpdate();
        stm.close();
        
        sql = "INSERT or IGNORE INTO tipo_contato (id_tipo_contato, descricao) VALUES (?, ?)";
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        stm.setInt(1, 1);
        stm.setString(2, "Geral");
        stm.executeUpdate();
        stm.close();
        
        sql = "CREATE TABLE IF NOT EXISTS contato ("
                    + "id_contato INTEGER, "
                    + "nome TEXT, "
                    + "apelido TEXT, "
                    + "bairro TEXT, "
                    + "estado TEXT, "
                    + "cidade TEXT, "
                    + "rua TEXT, "
                    + "email TEXT, "
                    + "ddd INTEGER, "
                    + "telefone INTEGER, "
                    + "id_tipo_contato INTEGER, "
                    + "descricao TEXT, "
                    + "FOREIGN KEY (id_tipo_contato) REFERENCES tipo_contato (id_tipo_contato)"
                    + "PRIMARY KEY (id_contato)"
                    + ");";
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        stm.executeUpdate();
        stm.close();
            
        stm = null;
    }
    
    @Override
    public List<TipoContatoModelo> consultarDao() throws SQLException {
        // Para evitar erros, é necessário que a tabela tipo_contato exista! Fazemos uma verificação e se não existir, criamos agora mesmo.
        criarTableCasoNaoExista();   

        List<TipoContatoModelo> lista = new ArrayList<TipoContatoModelo>();
        
        sql = "SELECT * FROM tipo_contato";
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();
        
        while (resultado.next()) {
            TipoContatoModelo novocm = new TipoContatoModelo();
            
            novocm.setId(resultado.getInt("id_tipo_contato"));
            novocm.setDescricao(resultado.getString("descricao"));
            
            lista.add(novocm);
        }
        
        stm.close();
        
        return lista;
    }
}
