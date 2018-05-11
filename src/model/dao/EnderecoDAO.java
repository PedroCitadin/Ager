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
import model.bean.Audiencia;
import model.bean.Cliente;
import model.bean.Endereco;
import model.bean.Processo;

import model.connection.ConnectionFactory;

/**
 *
 * @author Pedro
 */
public class EnderecoDAO {
    public void inserirEnderecoAdvogado(Endereco end){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO endereco(numero, cep, cidade, estado, rua, bairro, complemento, cod_end_adv)VALUES(?, ?, ?, ?, ?, ?, ?, ?)  " );
            pstmt.setInt(1, end.getNumero());
            pstmt.setString(2, end.getCep());
            pstmt.setString(3, end.getCidade());
            pstmt.setString(4, end.getEstado());
            pstmt.setString(5, end.getRua());
            pstmt.setString(6, end.getBairro());
            pstmt.setString(7, end.getComplemento());
            pstmt.setInt(8, end.getCod_end_adv().getCod_adv());
           
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Endereço inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
     public void inserirEnderecoCliente(Endereco end){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO endereco(numero, cep, cidade, estado, rua, bairro, complemento, cod_end_cli)VALUES(?, ?, ?, ?, ?, ?, ?, ?)  " );
            pstmt.setInt(1, end.getNumero());
            pstmt.setString(2, end.getCep());
            pstmt.setString(3, end.getCidade());
            pstmt.setString(4, end.getEstado());
            pstmt.setString(5, end.getRua());
            pstmt.setString(6, end.getBairro());
            pstmt.setString(7, end.getComplemento());
            pstmt.setInt(8, end.getCod_end_cli().getCod_cliente());
           
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Endereço inserido.");
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
///////////listar///////
public List<Endereco> listarEnderecoAdvogado(Endereco en) {
       
        Connection connection = null;
        List<Endereco> endereco = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM endereco WHERE cod_end_adv = ?");
            pstmt.setInt(1, en.getCod_end_adv().getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
               Endereco end = new Endereco();
               Advogado adv = new Advogado();
               end.setCod_end(rs.getInt("cod_end"));
               adv.setCod_adv(rs.getInt("cod_end_adv"));
               end.setCod_end_adv(adv);
               end.setBairro(rs.getString("bairro"));
               end.setCep(rs.getString("cep"));
               end.setRua(rs.getString("rua"));
               end.setCidade(rs.getString("cidade"));
               end.setEstado(rs.getString("estado"));
               end.setComplemento(rs.getString("complemento"));
               end.setNumero(rs.getInt("numero"));
               endereco.add(end);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return endereco;
    }     
public List<Endereco> listarEnderecoCliente(Endereco en) {
       
        Connection connection = null;
        List<Endereco> endereco = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM endereco WHERE cod_end_cli = ?");
            pstmt.setInt(1, en.getCod_end_cli().getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
               Endereco end = new Endereco();
               Cliente cli = new Cliente();
               end.setCod_end(rs.getInt("cod_end"));
               cli.setCod_cliente(rs.getInt("cod_end_cli"));
               end.setCod_end_cli(cli);
               end.setBairro(rs.getString("bairro"));
               end.setCep(rs.getString("cep"));
               end.setRua(rs.getString("rua"));
               end.setCidade(rs.getString("cidade"));
               end.setEstado(rs.getString("estado"));
               end.setComplemento(rs.getString("complemento"));
               end.setNumero(rs.getInt("numero"));
               endereco.add(end);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return endereco;
    }  
/////////////buscar//////
public Endereco buscarEnderecoAdvogado(Endereco end ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        Cliente cli = new Cliente();
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM endereco where cod_end = ?");
            
            pstmt.setInt(1, end.getCod_end());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               end.setCod_end(rs.getInt("cod_end"));
               adv.setCod_adv(rs.getInt("cod_end_adv"));
               end.setCod_end_adv(adv);
               end.setBairro(rs.getString("bairro"));
               end.setCep(rs.getString("cep"));
               end.setCidade(rs.getString("cidade"));
               end.setEstado(rs.getString("estado"));
               end.setComplemento(rs.getString("complemento"));
               end.setNumero(rs.getInt("numero"));
               end.setRua(rs.getString("rua"));
                
            }
            connection.close();
            return end;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
public Endereco buscarEnderecoAdvogadoUnico(Endereco end ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        adv=end.getCod_end_adv();
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM endereco where cod_end_adv = ?");
            
            pstmt.setInt(1, adv.getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               end.setCod_end(rs.getInt("cod_end"));
               adv.setCod_adv(rs.getInt("cod_end_adv"));
               end.setCod_end_adv(adv);
               end.setBairro(rs.getString("bairro"));
               end.setCep(rs.getString("cep"));
               end.setCidade(rs.getString("cidade"));
               end.setEstado(rs.getString("estado"));
               end.setComplemento(rs.getString("complemento"));
               end.setNumero(rs.getInt("numero"));
               end.setRua(rs.getString("rua"));
                
            }
            connection.close();
            return end;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
public Endereco buscarEnderecoCliente(Endereco end ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        Cliente cli = new Cliente();
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM endereco where cod_end_cli = ?");
            
            pstmt.setInt(1, end.getCod_end_cli().getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               end.setCod_end(rs.getInt("cod_end"));
               cli.setCod_cliente(rs.getInt("cod_end_cli"));
               end.setCod_end_cli(cli);
               end.setBairro(rs.getString("bairro"));
               end.setCep(rs.getString("cep"));
               end.setCidade(rs.getString("cidade"));
               end.setEstado(rs.getString("estado"));
               end.setComplemento(rs.getString("complemento"));
               end.setNumero(rs.getInt("numero"));
               end.setRua(rs.getString("rua"));
                
            }
            connection.close();
            return end;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
///////
    public void deletarEndereco(Endereco end) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM endereco WHERE cod_end=?");
            pstmt.setInt(1, end.getCod_end());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Endereço excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    
    public void editarEndereco(Endereco end) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE endereco set numero=?, cep=?, cidade=?, estado=?, rua=?, bairro=?, complemento=? where cod_end=?");
            pstmt.setInt(1, end.getNumero());
             pstmt.setString(2, end.getCep());
            pstmt.setString(3, end.getCidade());
            pstmt.setString(4, end.getEstado());
            pstmt.setString(5, end.getRua());
            pstmt.setString(6, end.getBairro());
            pstmt.setString(7, end.getComplemento());
            pstmt.setInt(8, end.getCod_end());






            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Endereço alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    
 }