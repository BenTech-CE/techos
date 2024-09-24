/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.agenda.visao;

import br.edu.agenda.controle.ContatoControle;
import br.edu.agenda.controle.TipoContatoControle;
import br.edu.agenda.modelo.ContatoModelo;
import br.edu.agenda.modelo.TipoContatoModelo;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Kaua Sousa
 */
public class ConsultaVisao extends JInternalFrame {
    private ImageIcon iconTipoContato = new ImageIcon(getClass().getResource("/br/edu/agenda/img/tipo.png"));
    private ImageIcon iconContato = new ImageIcon(getClass().getResource("/br/edu/agenda/img/name.png"));
    private ImageIcon iconPadrao = new ImageIcon(getClass().getResource("/br/edu/agenda/img/contact.png"));
    
    private ContatoControle cc = new ContatoControle();
    private List<ContatoModelo> listaContatos = new ArrayList<ContatoModelo>();
    private List<DefaultMutableTreeNode> nodesContato = new ArrayList<DefaultMutableTreeNode>();
    
    private TipoContatoControle tcc = new TipoContatoControle();
    private List<TipoContatoModelo> listaTipos = new ArrayList<TipoContatoModelo>();
    private List<DefaultMutableTreeNode> nodesTipo = new ArrayList<DefaultMutableTreeNode>();
    
    private DefaultTableModel modeloTabela;
    
    /**
     * Creates new form ConsultaVisao
     */
    public ConsultaVisao() {
        super("Consultar Contatos", true, true, true);
        
        initComponents();
        
        listaTipos = tcc.consultarControle();
        
        modeloTabela = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        jTable1.setModel(modeloTabela);
        
        jTree1.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
                
                if (nodo.getParent() != null && nodo.getParent().toString() == nodo.getRoot().toString()) {
                    setIcon(iconTipoContato); // ícone para tipo contato
                } else if (nodo.getParent() != null) {
                    setIcon(iconContato); // ícone para contato
                } else {
                    setIcon(iconPadrao); // ícone para "Contatos Cadastrados"
                } 
                
                if (nodo.getUserObject() instanceof TipoContatoModelo)
                    setText(((TipoContatoModelo) nodo.getUserObject()).getDescricao());
                
                if (nodo.getUserObject() instanceof ContatoModelo)
                    setText(((ContatoModelo) nodo.getUserObject()).getNome());
                
                return this;
                
            }
            
        });
        
        jpnContatoInfo.setVisible(false);
        
        configurarTabela();
        
        carregarTipoContatos();
        
        carregarContatos();
    }
    
    private void configurarTabela() {
        modeloTabela.addColumn("Nº");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Apelido");
        modeloTabela.addColumn("DDD");
        modeloTabela.addColumn("Telefone");
        modeloTabela.addColumn("UF");
        
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(40);
        
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                
                setIcon(iconContato);
                
                return this;
            }
            
        });
        
        jTable1.setRowHeight(40);
    }
    
    private void carregarTipoContatos() {
        listaTipos = tcc.consultarControle();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Contatos Cadastrados");
        
        for (TipoContatoModelo tcm : listaTipos) {
            DefaultMutableTreeNode tipo = new DefaultMutableTreeNode(tcm);
            nodesTipo.add(tipo);
            root.add(tipo);
        }
        
        DefaultTreeModel modelo = new DefaultTreeModel(root);
        jTree1.setModel(modelo);
    }
    
    private void carregarContatos() {
        listaContatos = cc.consultarControle();
        
        for (ContatoModelo cm : listaContatos) {
            DefaultMutableTreeNode tipoContatoSelecionado = nodesTipo
                    .stream()
                    .filter(t -> ((TipoContatoModelo)t.getUserObject()).getId() == cm.getTipoContato())
                    .findFirst()
                    .orElse(nodesTipo.getFirst());
            
            DefaultMutableTreeNode ctt = new DefaultMutableTreeNode(cm);
            nodesContato.add(ctt);
            tipoContatoSelecionado.add(ctt);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jspContatoInfo = new javax.swing.JScrollPane();
        jpnContatoInfo = new javax.swing.JPanel();
        jlInformacoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(864, 548));
        setPreferredSize(new java.awt.Dimension(864, 548));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(350, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 602));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(220, 602));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(220, 602));
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTree1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Contatos Cadastrados");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Geral");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("João");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Amigos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("José");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setRowHeight(30);
        jTree1.setVisibleRowCount(999);
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTree1MousePressed(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(1400, 2147483647));
        jPanel3.setMinimumSize(new java.awt.Dimension(350, 548));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 548));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setMaximumSize(new java.awt.Dimension(1300, 999999));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(350, 548));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(350, 548));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        jspContatoInfo.setMaximumSize(new java.awt.Dimension(1000, 32767));
        jspContatoInfo.setMinimumSize(new java.awt.Dimension(250, 602));
        jspContatoInfo.setPreferredSize(new java.awt.Dimension(250, 602));
        jspContatoInfo.setViewportView(jpnContatoInfo);

        jpnContatoInfo.setLayout(new javax.swing.BoxLayout(jpnContatoInfo, javax.swing.BoxLayout.Y_AXIS));

        jlInformacoes.setText("<html><h1 style=\"margin: 15px;\">Informações do Contato</h1><br><p style=\"margin-left: 15px; margin-right: 15px; font-weight: 800; font-size: 10px;\">Nome: xxx</p></html>");
        jlInformacoes.setToolTipText("");
        jlInformacoes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlInformacoes.setAlignmentY(0.0F);
        jlInformacoes.setMaximumSize(new java.awt.Dimension(2147483647, 602));
        jlInformacoes.setPreferredSize(new java.awt.Dimension(250, 99));
        jpnContatoInfo.add(jlInformacoes);

        jspContatoInfo.setViewportView(jpnContatoInfo);

        jPanel1.add(jspContatoInfo);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        DefaultMutableTreeNode no = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        
        if (no != null && no.getUserObject() instanceof TipoContatoModelo && !(no.getUserObject() instanceof ContatoModelo)) {
            modeloTabela.setNumRows(0);
            
            TipoContatoModelo tipo = (TipoContatoModelo) no.getUserObject();
            
            List<ContatoModelo> listaFiltrada = listaContatos.stream().filter(t -> t.getTipoContato() == tipo.getId()).toList();
            listaFiltrada.forEach(ctt -> modeloTabela.addRow(new Object[] {
                ctt.getId(),
                ctt.getNome(),
                ctt.getApelido(),
                ctt.getDDD() != 0 ? ctt.getDDD() : "",
                ctt.getTelefone() != 0 ? ctt.getTelefone() : "",
                ctt.getEstado()
            }));
            
            jTable1.clearSelection();
            jpnContatoInfo.setVisible(false);
            
        } else if (no != null && no.getUserObject() instanceof ContatoModelo) {
            modeloTabela.setNumRows(0);
            
            ContatoModelo ctt = (ContatoModelo) no.getUserObject();
            
            List<ContatoModelo> listaFiltrada = listaContatos.stream().filter(t -> t.getTipoContato() == ctt.getTipoContato()).toList();
            
            int idxSel = 0;
            int idxCur = 0;
            
            for (ContatoModelo ctt2 : listaFiltrada) {
                modeloTabela.addRow(new Object[] {
                    ctt2.getId(),
                    ctt2.getNome(),
                    ctt2.getApelido(),
                    ctt2.getDDD() != 0 ? ctt2.getDDD() : "",
                    ctt2.getTelefone() != 0 ? ctt2.getTelefone() : "",
                    ctt2.getEstado()
                });
        
                if (ctt2.getId() == ctt.getId()) {
                    idxSel = idxCur;
                }
                idxCur++;
            }

            jTable1.setRowSelectionInterval(idxSel, idxSel);
            
            mostrarInformaçõesContato(ctt);
        } else {
            modeloTabela.setNumRows(0);
            
            jTable1.clearSelection();
            jpnContatoInfo.setVisible(false);
            //jTable1.setModel(modeloLista);
        }
    }//GEN-LAST:event_jTree1ValueChanged

    private void jTree1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MousePressed
        jTree1.requestFocus();
    }//GEN-LAST:event_jTree1MousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        
        if (id != 0) {
            DefaultMutableTreeNode noCtt = nodesContato
                    .stream()
                    .filter(t -> ((ContatoModelo)t.getUserObject()).getId() == id)
                    .findFirst()
                    .orElse(null);

            if (noCtt != null) {
                jTree1.setSelectionPath(new TreePath(noCtt.getPath()));
            }            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel jlInformacoes;
    private javax.swing.JPanel jpnContatoInfo;
    private javax.swing.JScrollPane jspContatoInfo;
    // End of variables declaration//GEN-END:variables

    private void mostrarInformaçõesContato(ContatoModelo ctt) {
        jpnContatoInfo.setVisible(true);
        jlInformacoes.setText("<html><h1 style=\"margin: 10px;\">Informações do Contato</h1><br>" 
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Nome: " + ctt.getNome() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Descrição: " + ctt.getDescricao() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Apelido: " + ctt.getApelido() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Estado: " + ctt.getEstado() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Cidade: " + ctt.getCidade() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Bairro: " + ctt.getBairro() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Rua: " + ctt.getRua() + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">DDD: " + (ctt.getDDD() != 0 ? ctt.getDDD() : "") + "</p>"
                + "<p style=\"margin-left: 10px; margin-right: 10px; font-weight: 800; font-size: 10px;\">Telefone: " + (ctt.getTelefone() != 0 ? ctt.getTelefone() : "") + "</p>"
                + "</html>");
    }
}
