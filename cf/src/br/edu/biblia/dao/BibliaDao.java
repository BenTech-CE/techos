/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.biblia.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BibliaDao {
    String sql;
    PreparedStatement stm;
    ResultSet resultado;
    
    public List<String> consultarVersosDoCapítulo(int livro, int cap) throws SQLException {
        sql = "SELECT * FROM verse WHERE book_id = " + livro + " AND chapter = " + cap;
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
    
        resultado = stm.executeQuery();
        
        List<String> versos = new ArrayList<String>();
        
        while (resultado.next()) {
            versos.add(resultado.getString("text"));
        }
        
        return versos;
    }
    
    public String consultarLivro(int livro) throws SQLException {
        sql = "SELECT * FROM book WHERE book_reference_id = " + livro;
        
        stm = ConexaoBanco.abreConexao().prepareStatement(sql);
    
        resultado = stm.executeQuery();
        
        while (resultado.next()) {
            return resultado.getString("name");
        }
        return null;
    }
}
