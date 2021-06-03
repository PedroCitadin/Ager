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
import model.bean.Email;
import model.connection.ConnectionFactory;

/**
 *
 * @author Pedro
 */
public class EmailDAO {
            public void inserirEmailAdvogado(Email emi){
       
            Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO email (descricao, advogado) VALUES(?, ?)");
            pstmt.setString(1, emi.getDescricao());
            pstmt.setInt(2, emi.getAdvogado().getCod_adv());
            
           
            pstmt.executeUpdate();
             
        
       
            JOptionPane.showMessageDialog(null, "Email inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
            public void inserirEmailCliente(Email emi){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO email (descricao, cliente) VALUES(?, ?)");
            pstmt.setString(1, emi.getDescricao());
            pstmt.setInt(2, emi.getCliente().getCod_cliente());
            
            pstmt.executeUpdate();
             
        
       
            JOptionPane.showMessageDialog(null, "Email inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
            public List<Email> listarEmailAdvogado(Email emi) {
       
        Connection connection = null;
        List<Email> email = new ArrayList<>();
        Advogado advo = new Advogado();
        advo = emi.getAdvogado();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM email WHERE advogado=? ");
            
           
            pstmt.setInt(1, advo.getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Email em = new Email();
                Advogado adv = new Advogado();
                em.setCod_email(rs.getInt("cod_email"));
                adv.setCod_adv(rs.getInt("advogado"));
                em.setDescricao(rs.getString("descricao"));
                em.setAdvogado(advo);
                email.add(em);
            }
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return email;
    }
            public List<Email> listarEmailCliente(Email emi) {
       
        Connection connection = null;
        List<Email> email = new ArrayList<>();
        Cliente clint = new Cliente();
        clint = emi.getCliente();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM email WHERE cliente=? ");
            
           
            pstmt.setInt(1, clint.getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Email em = new Email();
                Cliente cli = new Cliente();
                em.setCod_email(rs.getInt("cod_email"));
                cli.setCod_cliente(rs.getInt("cliente"));
                em.setDescricao(rs.getString("descricao"));
                em.setCliente(cli);
                email.add(em);
            }
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return email;
    }
            public void deletarEmail(Email emi) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM email WHERE cod_email=?");
            pstmt.setInt(1, emi.getCod_email());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Email excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
            public void editarEmail(Email emi) {
                Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE email set descricao=? where cod_email=?");
            pstmt.setString(1, emi.getDescricao());
            pstmt.setInt(2, emi.getCod_email());
            
           
            
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Email alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
            public Email buscarEmailAdvogado(Email emi ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM email where cod_email = ?");
            pstmt.setInt(1, emi.getCod_email());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                emi.setDescricao(rs.getString("descricao"));
                adv.setCod_adv(rs.getInt("advogado"));
                emi.setAdvogado(adv);
                
                
            }
            connection.close();
            return emi;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
            public Email buscarEmailCliente(Email emi ) {
        Connection connection = null;
        Cliente cli = new Cliente();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM email where cod_email = ?");
            pstmt.setInt(1, emi.getCod_email());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                emi.setDescricao(rs.getString("descricao"));
                cli.setCod_cliente(rs.getInt("cliente"));
                emi.setCliente(cli);
                
                
            }
            connection.close();
            return emi;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
public Email buscarEmailPorAdvogado(Email emi ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM email where advogado = ?");
            pstmt.setInt(1, emi.getAdvogado().getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                emi.setDescricao(rs.getString("descricao"));
                adv.setCod_adv(rs.getInt("advogado"));
                emi.setAdvogado(adv);
                
                
            }
            connection.close();
            return emi;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
public Email buscarEmailPorCliente(Email emi ) {
        Connection connection = null;
        Cliente cli = new Cliente();
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM email where cliente = ?");
            pstmt.setInt(1, emi.getCliente().getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                emi.setDescricao(rs.getString("descricao"));
                cli.setCod_cliente(rs.getInt("cliente"));
                emi.setCliente(cli);
                
                
            }
            connection.close();
            return emi;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
