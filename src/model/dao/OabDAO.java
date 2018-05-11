/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Advogado;
import model.bean.Oab;
import model.connection.ConnectionFactory;

/**
 *
 * @author Pedro
 */
public class OabDAO {
    public void inserirCodigoOab(Oab oab){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO oab (codigo, cod_advogado) VALUES(?, ?)");
            
            pstmt.setString(1, oab.getCodigo());
            
            pstmt.setInt(2, oab.getCod_advogado().getCod_adv());
            
           
            pstmt.executeUpdate();
             
        
       
            JOptionPane.showMessageDialog(null, "Código OAB inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
     public List<Oab> listarCodigoOab(Oab oab) {
       
        Connection connection = null;
        List<Oab> coab = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM oab WHERE cod_advogado=? ");
            
            
            pstmt.setInt(1, oab.getCod_advogado().getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               
                Advogado adv = new Advogado();
                oab.setCod_cod_oab(rs.getInt("cod_cod_oab"));
                oab.setCodigo(rs.getString("codigo"));
                adv.setCod_adv(rs.getInt("cod_advogado"));
                oab.setCod_advogado(adv);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return coab;
    }
      public void deletarCodigoOab(Oab oab) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM oab WHERE cod_cod_oab=?");
            pstmt.setInt(1, oab.getCod_cod_oab());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Código OAB excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
      public void editarCodigoOab(Oab oab) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE oab set codigo=?, cod_advogado where cod_cod_oab=?");
            pstmt.setString(1, oab.getCodigo());
            pstmt.setInt(2, oab.getCod_advogado().getCod_adv());
            pstmt.setInt(3, oab.getCod_cod_oab());
           
            
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Processo alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
      public Oab buscarCodigoOabPorAdvogado(Oab oab ) {
        Connection connection = null;
        Advogado adv = oab.getCod_advogado();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM oab where cod_advogado = ?");
            pstmt.setInt(1, adv.getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                oab.setCod_cod_oab(rs.getInt("cod_cod_oab"));
                oab.setCodigo(rs.getString("codigo"));
                adv.setCod_adv(rs.getInt("cod_advogado"));
                oab.setCod_advogado(adv);
                
                
            }
            connection.close();
            return oab;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
      public Oab buscarCodigoOab(Oab oab ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM oab where cod_cod_oab = ?");
            pstmt.setInt(1, oab.getCod_cod_oab());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                oab.setCod_cod_oab(rs.getInt("cod_cod_oab"));
                oab.setCodigo(rs.getString("codigo"));
                adv.setCod_adv(rs.getInt("cod_advogado"));
                oab.setCod_advogado(adv);
                
                
            }
            connection.close();
            return oab;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
