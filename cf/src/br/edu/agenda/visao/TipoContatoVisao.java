
package br.edu.agenda.visao;

import br.edu.agenda.controle.TipoContatoControle;
import br.edu.agenda.util.Tabela;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoContatoVisao extends FormPadrao {
    TipoContatoVisao(){
        setTitle("Cadastro de Tipo de Contato");
        consultaVisao();
    }
    
    //Todos os componentes que serão criados na tela via codificação, serão inseridos dentro do inicializar componentes.
    @Override
    public void inicializarComponentes() {
        //Inserir componentes aqui.  
    }

    //Instância de controle.
    TipoContatoControle tcc = new TipoContatoControle();
    
    @Override
    public void salvarVisao() {
        tcc.salvarControle(jtfID.getText(), jtfDescricao.getText());
    }

    @Override
    public void criarTabela() {
        Tabela.criarTabela(
                tabela, 
                new int[] { 60, 800 }, 
                new String[] { "centro", "esquerda" }, 
                new String[] { "ID", "Descrição" }
        );
        
        modelo = (DefaultTableModel) tabela.getModel();
    }

    @Override
    public void habilitaCampos(boolean estado) {
        jtfDescricao.setEnabled(estado);
    }

    @Override
    public void consultaVisao() {
        modelo.setNumRows(0);
        tcc.consultarControle(jtfConsulta.getText(), modelo);
    }

    @Override
    public void atualizarFormulario() {
        jtfID.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        jtfDescricao.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
    }

    @Override
    public void excluirVisao() {
        if (!jtfID.getText().equals("1"))
            tcc.excluirControle(Integer.parseInt(jtfID.getText()));
        else
            JOptionPane.showMessageDialog(null, "Você não pode excluir este Tipo de Contato.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void limpaCampo() {
        jtfID.setText("");
        jtfDescricao.setText("");
    }

    @Override
    public boolean validaCampos() {
        if (jtfDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo \"Descrição\".", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
}
