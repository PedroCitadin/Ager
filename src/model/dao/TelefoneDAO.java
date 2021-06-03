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
import model.bean.Cliente;
import model.bean.Telefone;
import model.connection.ConnectionFactory;

/**
 *
 * @author Pedro
 */
public class TelefoneDAO {
        public void inserirTelefoneAdvogado(Telefone tele){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO telefone (ddd, numero, advogado) VALUES(?, ?, ?)");
            pstmt.setString(1, tele.getDdd());
            pstmt.setString(2, tele.getNumero());
            pstmt.setInt(3, tele.getAdvogado().getCod_adv());
           
            pstmt.executeUpdate();
             
        
       
            JOptionPane.showMessageDialog(null, "Telefone inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
        public void inserirTelefoneCliente(Telefone tele){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO telefone (ddd, numero, cliente) VALUES(?, ?, ?)");
            pstmt.setString(1, tele.getDdd());
            pstmt.setString(2, tele.getNumero());
            pstmt.setInt(3, tele.getCliente().getCod_cliente());
           
            pstmt.executeUpdate();
             
        
       
            JOptionPane.showMessageDialog(null, "Telefone inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
        public List<Telefone> listarTelefoneAdvogado(Telefone tele) {
       
        Connection connection = null;
        List<Telefone> tel = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM telefone WHERE advogado=? ");
            
           
            pstmt.setInt(1, tele.getAdvogado().getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
               Telefone te = new Telefone();
                Advogado adv = new Advogado();
                te.setCod_telefone(rs.getInt("cod_telefone"));
                te.setDdd(rs.getString("ddd"));
                te.setNumero(rs.getString("numero"));
                adv.setCod_adv(rs.getInt("advogado"));
                te.setAdvogado(adv);
                tel.add(te);
            }
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return tel;
    }
        public List<Telefone> listarTelefoneCliente(Telefone tele) {
       
        Connection connection = null;
        List<Telefone> tel = new ArrayList<>();
        Cliente clint = new Cliente();
        clint = tele.getCliente();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM telefone WHERE cliente=? ");
            
           
            pstmt.setInt(1, clint.getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
               Telefone te = new Telefone();
                Cliente cli = new Cliente();
                te.setCod_telefone(rs.getInt("cod_telefone"));
                te.setDdd(rs.getString("ddd"));
                te.setNumero(rs.getString("numero"));
                cli.setCod_cliente(rs.getInt("cliente"));
                te.setCliente(clint);
                tel.add(te);
            }
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return tel;
    }
        public void deletarTelefone(Telefone tel) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM telefone WHERE cod_telefone=?");
            pstmt.setInt(1, tel.getCod_telefone());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Telefone excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
        public void editarTelefone(Telefone tel) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE telefone set ddd=?, numero=? where cod_telefone=?");
            pstmt.setString(1, tel.getDdd());
            pstmt.setString(2, tel.getNumero());
            pstmt.setInt(3, tel.getCod_telefone());
           
            
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Telefone alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
        public Telefone buscarTelefoneAdvogado(Telefone tel ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM telefone where cod_telefone = ?");
            pstmt.setInt(1, tel.getCod_telefone());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tel.setDdd(rs.getString("ddd"));
                tel.setNumero(rs.getString("numero"));
                adv.setCod_adv(rs.getInt("advogado"));
                tel.setAdvogado(adv);
                
                
            }
            connection.close();
            return tel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
        public Telefone buscarTelefoneCliente(Telefone tel ) {
        Connection connection = null;
        Cliente cli = new Cliente();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM telefone where cod_telefone = ?");
            pstmt.setInt(1, tel.getCod_telefone());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tel.setDdd(rs.getString("ddd"));
                tel.setNumero(rs.getString("numero"));
                cli.setCod_cliente(rs.getInt("cliente"));
                tel.setCliente(cli);
                
                
            }
            connection.close();
            return tel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
        public Telefone buscarTelefonePorAdvogado(Telefone tel ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM telefone where advogado = ?");
            pstmt.setInt(1, tel.getAdvogado().getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tel.setDdd(rs.getString("ddd"));
                tel.setNumero(rs.getString("numero"));
                adv.setCod_adv(rs.getInt("advogado"));
                tel.setAdvogado(adv);
                
                
            }
            connection.close();
            return tel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Telefone buscarTelefonePorCliente(Telefone tel ) {
        Connection connection = null;
        Cliente cli = new Cliente();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM telefone where cliente = ?");
            pstmt.setInt(1, tel.getCliente().getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tel.setDdd(rs.getString("ddd"));
                tel.setNumero(rs.getString("numero"));
                cli.setCod_cliente(rs.getInt("cliente"));
                tel.setCliente(cli);
                
                
            }
            connection.close();
            return tel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }    
}
