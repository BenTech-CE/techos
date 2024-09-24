
package br.edu.agenda.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

//Aula 28.

public class ConexaoBanco {
    private static final String driverClass = "org.sqlite.JDBC";
    private static final String url = "jdbc:sqlite:contatos.db";
    private static final String usuario = "root";
    private static final String senha  = "";
    
    /*
        Por que foi utilizado o SQLite?
        - O SQLite permite usar do SQL sem a necessidade de criar um servidor próprio para hospedar o banco de dados.
          O SQLite permite que o banco de dados seja um único árquivo criado e guardado na pasta do programa.
          Assim permitindo que qualquer outra pessoa use o programa sem se preocupar em instalar MySQL ou conectar a um servidor externo.
    
    */
    
    public static Connection abreConexao(){
        Connection con = null;
        
        //Se der um erro no driver, cai na mensagem de erro!
        try {
            Class.forName(driverClass);
            //3 valores: arquivo do sqlite, usuário cadastrado na instalação e senha da conexão.  
            con = DriverManager.getConnection(url,usuario,senha);
            
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de Dados: "+erro+".");
        }        
        return con;
    }
}
