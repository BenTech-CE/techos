
package br.edu.agenda.visao;

import br.edu.agenda.controle.ContatoControle;
import br.edu.agenda.modelo.TipoContatoModelo;
import br.edu.util.FuncoesUteis;
import br.edu.agenda.util.Tabela;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ContatoVisao extends FormPadrao{
    
    ContatoVisao(){
        
        setTitle("Cadastro de Contatos"); 
        consultaVisao();
        
        cc.carregarComboBox(jcbTipoContato);
        
        cidades = FuncoesUteis.getListaDeCidades("AC");
        jcbCidade.removeAllItems();
        for (String c : cidades) {
            jcbCidade.addItem(c);
        }
    }
    
    JLabel jlNome;
    JLabel jlApelido;
    JLabel jlEmail;
    JLabel jlDDD;
    JLabel jlTelefone;
    JLabel jlUF;
    JLabel jlBairro;
    JLabel jlRua;
    JLabel jlTipoContato;
    JLabel jlCidade;
    
    JTextField jtfNome;
    JTextField jtfApelido;
    JTextField jtfEmail;
    JTextField jtfDDD;
    JTextField jtfTelefone;
    JComboBox jcbUF;
    JTextField jtfBairro;
    JTextField jtfRua;
    JComboBox jcbTipoContato;
    JComboBox jcbCidade;
    
    String[] estados;
    String[] tiposContato;
    String[] cidades;
    
    //Todos os componentes que serão criados na tela via codificação, serão inseridos dentro do inicializar componentes.
    @Override
    public void inicializarComponentes() {
        estados = new String[]{ "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        tiposContato = new String[] { };
        cidades = new String[] { }; 
        
        setFrameIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/novocontato.png")));
        
        jlNome = new JLabel("Nome");
        jlNome.setBounds(29, 88, 80, 25);
        jlNome.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/name.png")));
        jpnFormulario.add(jlNome);
        
        jtfNome = new JTextField();
        jtfNome.setBounds(29, 113, 220, 30);
        jtfNome.setEnabled(false);
        jtfNome.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfNome);
        
        jlApelido = new JLabel("Apelido");
        jlApelido.setBounds(270, 88, 80, 25);
        jlApelido.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/apelido.png")));
        jpnFormulario.add(jlApelido);
        
        jtfApelido = new JTextField();
        jtfApelido.setBounds(270, 113, 209, 30);
        jtfApelido.setEnabled(false);
        jtfApelido.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfApelido);
        
        jlEmail = new JLabel("Email");
        jlEmail.setBounds(29, 150, 80, 25);
        jlEmail.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/email.png")));
        jpnFormulario.add(jlEmail);
        
        jtfEmail = new JTextField();
        jtfEmail.setBounds(29, 175, 220, 30);
        jtfEmail.setEnabled(false);
        jtfEmail.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfEmail);
        
        jlDDD = new JLabel("DDD");
        jlDDD.setBounds(270, 150, 80, 25);
        jlDDD.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/ddd.png")));
        jpnFormulario.add(jlDDD);
        
        jtfDDD = new JTextField();
        jtfDDD.setBounds(270, 175, 60, 30);
        jtfDDD.setEnabled(false);
        jtfDDD.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfDDD);
        
        jlTelefone = new JLabel("Telefone");
        jlTelefone.setBounds(350, 150, 80, 25);
        jlTelefone.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/telefone.png")));
        jpnFormulario.add(jlTelefone);
        
        jtfTelefone = new JTextField();
        jtfTelefone.setBounds(350, 175, 200, 30);
        jtfTelefone.setEnabled(false);
        jtfTelefone.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfTelefone);
        
        jlUF = new JLabel("Estado");
        jlUF.setBounds(500, 24, 80, 25);
        jlUF.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/uf.png")));
        jpnFormulario.add(jlUF);
        
        jcbUF = new JComboBox(estados);
        jcbUF.setBounds(500, 53, 70, 30);
        jcbUF.setEnabled(false);
        jcbUF.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jcbUF);
        
        jlCidade = new JLabel("Cidade");
        jlCidade.setBounds(590, 24, 80, 25);
        jlCidade.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/cidade.png")));
        jpnFormulario.add(jlCidade);
        
        jcbCidade = new JComboBox(cidades);
        jcbCidade.setBounds(590, 53, 230, 30);
        jcbCidade.setEnabled(false);
        jcbCidade.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jcbCidade);
        
        jcbUF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cidades = FuncoesUteis.getListaDeCidades(jcbUF.getSelectedItem().toString());
                jcbCidade.removeAllItems();
                for (String c : cidades) {
                    jcbCidade.addItem(c);
                }
            }
        });
        
        jlRua = new JLabel("Rua");
        jlRua.setBounds(500, 88, 80, 25);
        jlRua.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/cep.png")));
        jpnFormulario.add(jlRua);
        
        jtfRua = new JTextField();
        jtfRua.setBounds(500, 113, 320, 30);
        jtfRua.setEnabled(false);
        jtfRua.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfRua);
        
        jlBairro = new JLabel("Bairro");
        jlBairro.setBounds(570, 150, 80, 25);
        jlBairro.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/bairro.png")));
        jpnFormulario.add(jlBairro);
        
        jtfBairro = new JTextField();
        jtfBairro.setBounds(570, 175, 150, 30);
        jtfBairro.setEnabled(false);
        jtfBairro.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jtfBairro);
        
        jlTipoContato = new JLabel("Tipo");
        jlTipoContato.setBounds(740, 150, 80, 25);
        jlTipoContato.setIcon(new ImageIcon(getClass().getResource("/br/edu/agenda/img/tipo.png")));
        jpnFormulario.add(jlTipoContato);
        
        jcbTipoContato = new JComboBox(tiposContato);
        jcbTipoContato.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                
                if (value instanceof TipoContatoModelo) {
                    TipoContatoModelo tcm = (TipoContatoModelo) value;
                    
                    setText(tcm.getDescricao());
                }
                
                return this;
            }
        });
        jcbTipoContato.setBounds(740, 175, 80, 30);
        jcbTipoContato.setEnabled(false);
        jcbTipoContato.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jpnFormulario.add(jcbTipoContato);
    }
    
    //Instância de controle.
    ContatoControle cc = new ContatoControle();
    
    @Override
    public void salvarVisao() {
        TipoContatoModelo tipoContatoSelecionado = (TipoContatoModelo) jcbTipoContato.getSelectedItem();
        
        cc.salvarControle(jtfID.getText(), jtfDescricao.getText(), jtfNome.getText(), jtfApelido.getText(), jtfBairro.getText(), jcbUF.getSelectedItem().toString(), jcbCidade.getSelectedItem().toString(), jtfRua.getText(), jtfDDD.getText(), jtfTelefone.getText(), jtfEmail.getText(), ""+tipoContatoSelecionado.getId());
    }

    @Override
    public void criarTabela() {
        Tabela.criarTabela(
                tabela, 
                new int[] { 30, 250, 100, 150, 250, 80, 150, 45, 150, 150, 250, 250 }, 
                new String[] { "centro", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda", "esquerda" }, 
                new String[] { "ID", "Nome", "Apelido", "Tipo", "Email", "DDD", "Telefone", "UF", "Cidade", "Bairro", "Rua", "Descrição" }
        );
        
        modelo = (DefaultTableModel) tabela.getModel();
    }

    @Override
    public void habilitaCampos(boolean estado) {
        jtfDescricao.setEnabled(estado);
        jtfNome.setEnabled(estado);
        jtfApelido.setEnabled(estado);
        jtfEmail.setEnabled(estado);
        jtfDDD.setEnabled(estado);
        jtfTelefone.setEnabled(estado);
        jcbTipoContato.setEnabled(estado);
        jcbUF.setEnabled(estado);
        jtfRua.setEnabled(estado);
        jtfBairro.setEnabled(estado);
        jcbCidade.setEnabled(estado);
    }

    @Override
    public void consultaVisao() {
        modelo.setNumRows(0);
        cc.consultarControle(jtfConsulta.getText(), modelo);
    }

    @Override
    public void atualizarFormulario() {
        TipoContatoModelo tipoContatoSelecionado = null;
        
        if (tabela.getValueAt(tabela.getSelectedRow(), 3) != "") 
            tipoContatoSelecionado = (TipoContatoModelo) tabela.getValueAt(tabela.getSelectedRow(), 3);
        
        int selecionadoIndex = 0;
        
        if (tipoContatoSelecionado != null) 
            for (int i = 0; i < jcbTipoContato.getItemCount(); i++) {
                TipoContatoModelo item = (TipoContatoModelo) jcbTipoContato.getItemAt(i);
                if (tipoContatoSelecionado.getId() == item.getId()) {
                    selecionadoIndex = i;
                    break;
                }
            }
        
        jtfID.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        jtfNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        jtfApelido.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        jcbTipoContato.setSelectedIndex(selecionadoIndex);
        jtfEmail.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        jtfDDD.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
        jtfTelefone.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
        jcbUF.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 7).toString());
        jtfBairro.setText(tabela.getValueAt(tabela.getSelectedRow(), 9).toString());
        jtfRua.setText(tabela.getValueAt(tabela.getSelectedRow(), 10).toString());
        jtfDescricao.setText(tabela.getValueAt(tabela.getSelectedRow(), 11).toString());
        jcbCidade.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
    }

    @Override
    public void excluirVisao() {
        cc.excluirControle(Integer.parseInt(jtfID.getText()));
    }

    @Override
    public void limpaCampo() {
        jtfID.setText("");
        jtfNome.setText("");
        jtfApelido.setText("");
        if (jcbTipoContato.getItemCount() != 0) jcbTipoContato.setSelectedIndex(0);
        jtfEmail.setText("");
        jtfDDD.setText("");
        jtfTelefone.setText("");
        jcbUF.setSelectedIndex(0);
        if (jcbCidade.getItemCount() != 0) jcbCidade.setSelectedIndex(0);
        jtfBairro.setText("");
        jtfRua.setText("");
        jtfDescricao.setText("");
    }

    @Override
    public boolean validaCampos() {
        if (jtfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo \"Nome\".", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (jcbTipoContato.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "É necessário criar um Tipo de Contato para criar contatos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!jtfDDD.getText().equals("")) {
            try {
                Integer.parseInt(jtfDDD.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O campo \"DDD\" deve ser númerico.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } 
        
        if (!jtfTelefone.getText().equals("")) {
            try {
                Integer.parseInt(jtfTelefone.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O campo \"Telefone\" deve ser númerico.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
    
    
}
