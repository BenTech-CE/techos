package br.edu.agenda.util;

import br.edu.agenda.modelo.TipoContatoModelo;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Tabela {
    public static void criarTabela(JTable tabela, int[] largura, String[] pos, String[] col) {
        tabela.setModel(new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }  
        });
        
        //tabela.setVisible(true);
        //tabela.getTableHeader().setReorderingAllowed(false);
        
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
    
        //tabela.setFont(new Font("Arial", Font.BOLD, 12));
        //tabela.setRowHeight(25);
        
        //JScrollPane jsp = new JScrollPane(tabela);
        //jsp.setBounds(15, 40, 830, 130);
        //jsp.setVisible(true);
        //jsp.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        //jpn.add(jsp);
        //jpn.revalidate();
        //jpn.repaint();

        // Ordenando ao clicar no titulo da coluna da tabela
        RowSorter<TableModel> sorter = new TableRowSorter(modeloTabela);
        tabela.setRowSorter(sorter);        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        //Adicionando coluna
        for (int i = 0; i < col.length; i++) {
            modeloTabela.addColumn(col[i]);
        }

        //Criando objeto para alinhamento dos dados dentro da tabela
        DefaultTableCellRenderer centro = new ObjectTableCellRenderer();
        DefaultTableCellRenderer direita = new ObjectTableCellRenderer();
        DefaultTableCellRenderer esquerda = new ObjectTableCellRenderer();

        //Adicionando as posiçoes
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);

        //Trabalhando com as colunas 
        for (int i = 0; i < largura.length; i++) {
            TableCellRenderer posConvertida;
            
            if (pos[i].equals("centro")) {
                posConvertida = centro;
            } else if (pos[i].equals("direita")) {
                posConvertida = direita;
            } else if (pos[i].equals("esquerda")) {
                posConvertida = esquerda;
            } else {
                posConvertida = esquerda;
            }

            tabela.getColumnModel().getColumn(i).setMaxWidth(largura[i]);

            tabela.getColumnModel().getColumn(i).setCellRenderer(posConvertida);

        }
    }
}


