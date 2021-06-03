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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Advogado;
import model.bean.Audiencia;
import model.bean.Cliente;
import model.bean.Processo;
import model.connection.ConnectionFactory;

/**
 *
 * @author Pedro
 */
public class AudienciaDAO {
    public Audiencia inserirAudiencia(Audiencia aud){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO audiencia (data, processo, rua, bairro, cidade, numero, estado, complemento, cep, hora) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
           pstmt.setDate(1, aud.getData());
           pstmt.setInt(2, aud.getProcesso().getCod_processo());
           pstmt.setString(3, aud.getRua());
           pstmt.setString(4, aud.getBairro());
           pstmt.setString(5, aud.getCidade());
           pstmt.setInt(6, aud.getNumero());
           pstmt.setString(7, aud.getEstado());
           pstmt.setString(8, aud.getComplemento());
           pstmt.setString(9, aud.getCep());
           pstmt.setTime(10, aud.getHora());  
           pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int codigo = 0;
            if (rs.next()) {
                codigo = Integer.parseInt(rs.getString(1));
            } 
            
            Object opcoes[] = {"Visualizar dados","Fechar", "Cadastrar outra audiência"};
            aud.setCod_audiencia(codigo);
            aud.setResposta(JOptionPane.showOptionDialog(null,"Audiência inserida, o que deseja fazer?","",1,3, null, opcoes, null));
            
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   return aud;
}
public List<Audiencia> listarAudiencia() {
       
        Connection connection = null;
        List<Audiencia> audiencia = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM audiencia ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Audiencia aud = new Audiencia();
                
                aud.setCod_audiencia(rs.getInt("cod_audiencia"));
                aud.setData(rs.getDate("data"));
                aud.setHora(rs.getTime("hora"));
                aud.setRua(rs.getString("rua"));
                aud.setBairro(rs.getString("bairro"));
                aud.setCidade(rs.getString("cidade"));
                aud.setNumero(rs.getInt("numero"));
                aud.setEstado(rs.getString("estado"));
                aud.setComplemento(rs.getString("complemento"));
                aud.setCep(rs.getString("cep"));
               audiencia.add(aud);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return audiencia;
    }    
    //////////Pesquisar
public List<Audiencia> pesquisarAudienciaPorProcesso(String cod) {
       
        Connection connection = null;
        List<Audiencia> audiencia = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM audiencia where processo= ?");
            pstmt.setString(1, cod);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Audiencia aud = new Audiencia();
                
                aud.setCod_audiencia(rs.getInt("cod_audiencia"));
                aud.setData(rs.getDate("data"));
                aud.setHora(rs.getTime("hora"));
                aud.setRua(rs.getString("rua"));
                aud.setBairro(rs.getString("bairro"));
                aud.setCidade(rs.getString("cidade"));
                aud.setNumero(rs.getInt("numero"));
                aud.setEstado(rs.getString("estado"));
                aud.setComplemento(rs.getString("complemento"));
                aud.setCep(rs.getString("cep"));
               audiencia.add(aud);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return audiencia;
    }    
public List<Audiencia> pesquisarAudienciaPorData(String dat) {
       
        Connection connection = null;
        List<Audiencia> audiencia = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM audiencia where data= ?");
            pstmt.setString(1, dat);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Audiencia aud = new Audiencia();
                
                aud.setCod_audiencia(rs.getInt("cod_audiencia"));
                aud.setData(rs.getDate("data"));
                aud.setHora(rs.getTime("hora"));
                aud.setRua(rs.getString("rua"));
                aud.setBairro(rs.getString("bairro"));
                aud.setCidade(rs.getString("cidade"));
                aud.setNumero(rs.getInt("numero"));
                aud.setEstado(rs.getString("estado"));
                aud.setComplemento(rs.getString("complemento"));
                aud.setCep(rs.getString("cep"));
               audiencia.add(aud);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return audiencia;
    } 
//////////
    public void deletar(Audiencia aud) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM audiencia WHERE cod_audiencia=?");
            pstmt.setInt(1, aud.getCod_audiencia());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Audiência excluída.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    
    public Processo buscarAudiencia(Audiencia aud) {
        Connection connection = null;
        Processo pro = new Processo();
        
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM audiencia where cod_audiencia = ?");
            pstmt.setInt(1, aud.getCod_audiencia());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                pro.setCod_processo(rs.getInt("processo"));
                aud.setCod_audiencia(rs.getInt("cod_audiencia"));
                aud.setData(rs.getDate("data"));
                aud.setHora(rs.getTime("hora"));
                aud.setRua(rs.getString("rua"));
                aud.setBairro(rs.getString("bairro"));
                aud.setCidade(rs.getString("cidade"));
                aud.setNumero(rs.getInt("numero"));
                aud.setEstado(rs.getString("estado"));
                aud.setComplemento(rs.getString("complemento"));
                aud.setCep(rs.getString("cep"));
                aud.setProcesso(pro);
                
            }
            connection.close();
            return pro;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void editarAudiencia(Audiencia aud) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE audiencia set data=?, processo=?, rua=?, bairro=?, cidade=?, numero=?, estado=?, complemento=?, cep=?, hora=?  where cod_audiencia=?");
            pstmt.setDate(1, aud.getData());
            pstmt.setInt(2, aud.getProcesso().getCod_processo());
            pstmt.setString(3, aud.getRua());
            pstmt.setString(4, aud.getBairro());
            pstmt.setString(5, aud.getCidade());
            pstmt.setInt(6, aud.getNumero());
            pstmt.setString(7, aud.getEstado());
            pstmt.setString(8, aud.getComplemento());
            pstmt.setString(9, aud.getCep());
            pstmt.setTime(10, aud.getHora());
            pstmt.setInt(11, aud.getCod_audiencia());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Audiência alterada.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    public String buscaPorCEP(String cep){
     Connection connection = null;
     String cidade = null;
     try{
         connection = ConnectionFactory.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cep where cep =?;");
         pstmt.setString(1, cep);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()){
             cidade = rs.getString("cidade");
         } 
     }catch(SQLException e){
         e.printStackTrace();
     }
     return cidade;
 }
}
