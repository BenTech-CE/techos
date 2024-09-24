
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

public class ContatoDao implements InterfaceDao {
    
    //Armazenará os comandos para inclusão, alteração, consulta e exclusão.
    String sql;
    PreparedStatement stm;
    ResultSet resultado;
    
    @Override
    public void salvarDao(TipoContatoModelo tcm){
        try {
            // Para evitar erros, é necessário que a tabela tipo_contato exista! Fazemos uma verificação e se não existir, criamos agora mesmo.
            criarTableCasoNaoExista();
        
            //Objeto tcm tem acesso aos métodos da classe modelo!
            ContatoModelo cm = (ContatoModelo) tcm;
        
            //Descobrir se é uma inclusão ou alteração.
            if (cm.getId() == 0) {
                sql = "INSERT INTO contato (nome, apelido, bairro, estado, cidade, rua, email, ddd, telefone, id_tipo_contato, descricao) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            } else {
                sql = "UPDATE contato SET nome=?, apelido=?, bairro=?, estado=?, cidade=?, rua=?, email=?, ddd=?, telefone=?, id_tipo_contato=?, descricao=? " +
                      "WHERE id_contato=?";
            }
            
            // Preparando e manipulando os dados
            stm = ConexaoBanco.abreConexao().prepareStatement(sql);
            
            //1° ? encontrado será substituído pela descrição, o segundo, pelo ID.
            
            //Porém, se o ID for zero ele faz a inclusão e não utiliza a outra linha de código, dedicada à alteração.
            stm.setString(1, cm.getNome());
            stm.setString(2, cm.getApelido());
            stm.setString(3, cm.getBairro());
            stm.setString(4, cm.getEstado());
            stm.setString(5, cm.getCidade());
            stm.setString(6, cm.getRua());
            stm.setString(7, cm.getEmail());
            stm.setInt(8, cm.getDDD());
            stm.setInt(9, cm.getTelefone());
            stm.setInt(10, cm.getTipoContato());
            stm.setString(11, cm.getDescricao());
            
            //Nesse caso, é uma alteração, já que o ID é maior que zero!
            if(tcm.getId() != 0){
                stm.setInt(12, cm.getId());
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
        
            sql = "DELETE FROM contato WHERE id_contato=?";
            
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
        
        List<TipoContatoModelo> tiposContato = new ArrayList<TipoContatoModelo>();
        
        sql = "SELECT * FROM tipo_contato";
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();   
        
        while (resultado.next()) {
            TipoContatoModelo tcm = new TipoContatoModelo();
            tcm.setId(resultado.getInt("id_tipo_contato"));
            tcm.setDescricao(resultado.getString("descricao"));
            
            tiposContato.add(tcm);
        }
        
        stm.close();
        
        if (consulta.equals(""))
            sql = "SELECT * FROM contato";
        else 
            sql = "SELECT * FROM contato WHERE nome LIKE '%"+ consulta + "%'";
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();
        
        while (resultado.next()) {
            int tid = resultado.getInt("id_tipo_contato");
            TipoContatoModelo tipoContatoSelecionado = tiposContato.stream().filter(t -> t.getId() == tid).findFirst().orElse(null);
            
            modelo.addRow(
                    new Object[] {
                        resultado.getInt("id_contato"),
                        resultado.getString("nome"),
                        resultado.getString("apelido"),
                        (tipoContatoSelecionado != null) ? tipoContatoSelecionado : "",
                        resultado.getString("email"),
                        (resultado.getInt("ddd") != 0) ? resultado.getInt("ddd") : "",
                        (resultado.getInt("telefone") != 0) ? resultado.getInt("telefone") : "",
                        resultado.getString("estado"),
                        resultado.getString("cidade"),
                        resultado.getString("bairro"),
                        resultado.getString("rua"),
                        resultado.getString("descricao")
                    }
            );
        }
        
        stm.close();
    }
    
    @Override
    public void carregarComboBoxDao(JComboBox itens) throws SQLException{
        sql = "SELECT * FROM tipo_contato";
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();
        
        while (resultado.next()) {
            TipoContatoModelo tcm = new TipoContatoModelo();
            tcm.setId(resultado.getInt("id_tipo_contato"));
            tcm.setDescricao(resultado.getString("descricao"));
            
            itens.addItem(tcm);
        }
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
    public List<ContatoModelo> consultarDao() throws SQLException {
        // Para evitar erros, é necessário que a tabela tipo_contato exista! Fazemos uma verificação e se não existir, criamos agora mesmo.
        criarTableCasoNaoExista();   

        List<ContatoModelo> listaContatos = new ArrayList<ContatoModelo>();
        
        sql = "SELECT * FROM contato";
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
        resultado = stm.executeQuery();
        
        while (resultado.next()) {
            ContatoModelo novocm = new ContatoModelo();
            
            novocm.setId(resultado.getInt("id_contato"));
            novocm.setNome(resultado.getString("nome"));
            novocm.setApelido(resultado.getString("apelido"));
            novocm.setTipoContato(resultado.getInt("id_tipo_contato"));
            novocm.setEmail(resultado.getString("email"));
            novocm.setDDD(resultado.getInt("ddd"));
            novocm.setTelefone(resultado.getInt("telefone"));
            novocm.setEstado(resultado.getString("estado"));
            novocm.setCidade(resultado.getString("cidade"));
            novocm.setBairro(resultado.getString("bairro"));
            novocm.setRua(resultado.getString("rua"));
            novocm.setDescricao(resultado.getString("descricao"));
            
            listaContatos.add(novocm);
        }
        
        stm.close();
        
        return listaContatos;
    }
}
