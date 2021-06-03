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
import model.bean.Cliente;
import model.bean.Email;
import model.bean.Endereco;
import model.bean.Oab;
import model.bean.Sexo;
import model.bean.Telefone;

import model.connection.ConnectionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class AdvogadoDAO {
    public Advogado inserirAdvogado(Advogado adv, Endereco end, Oab oab, Telefone tel, Email emi){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            
                           PreparedStatement pstm = connection
                   .prepareStatement("INSERT INTO advogado (nome, est_civ, cpf, sexo, sobrenome, rg, data_nasc) VALUES(?, ?, ?, ?, ?, ?, ?); ", Statement.RETURN_GENERATED_KEYS);
                           
                           PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO endereco(numero, cep, cidade, estado, rua, bairro, complemento, cod_end_adv)VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                           
                           PreparedStatement pst = connection
                   .prepareStatement("INSERT INTO oab(codigo, cod_advogado)VALUES(?, ?)");
                           
                           PreparedStatement ps = connection
                   .prepareStatement("INSERT INTO telefone(ddd, numero, advogado)VALUES(?, ?, ?)");
                           
                           PreparedStatement ps2 = connection
                   .prepareStatement("INSERT INTO email(descricao, advogado)VALUES(?, ?)");
                           
            
            /////////
            pstm.setString(1, adv.getNome());
            
            pstm.setString(2, adv.getEst_civ());
            pstm.setString(3, adv.getCpf());
            pstm.setInt(4, adv.getSexo().getId());
            pstm.setString(5, adv.getSobrenome());

            pstm.setString(6, adv.getRg());
            pstm.setDate(7, adv.getData_nasc());
            pstm.execute();
            /////endereço/////
            ResultSet rs = pstm.getGeneratedKeys();
            int codigo = 0;
            if (rs.next()) {
                codigo = Integer.parseInt(rs.getString(1));
            }
            pstmt.setInt(1, end.getNumero());
            pstmt.setString(2, end.getCep());
            pstmt.setString(3, end.getCidade());
            pstmt.setString(4, end.getEstado());
            pstmt.setString(5, end.getRua());
            pstmt.setString(6, end.getBairro());
            pstmt.setString(7, end.getComplemento());
            pstmt.setInt(8, codigo);
            if ((!end.getCep().equalsIgnoreCase(""))&&(!end.getCidade().equalsIgnoreCase(""))&&(!end.getRua().equalsIgnoreCase(""))&&(!end.getBairro().equalsIgnoreCase(""))&&(!end.getComplemento().equalsIgnoreCase(""))) {
                pstmt.execute();
            }
 
           
           
           pst.setString(1, oab.getCodigo());
           pst.setInt(2, codigo);
           pst.execute();
           /////////////////
           ps.setString(1, tel.getDdd());
           ps.setString(2, tel.getNumero());
           ps.setInt(3, codigo);
           if(!tel.getDdd().equalsIgnoreCase("  ")){
            if(!tel.getNumero().equalsIgnoreCase("     -    ")){
                ps.execute();
            }
           
           }
           
           ///////////
           ps2.setString(1, emi.getDescricao());
           ps2.setInt(2, codigo);
            if (!emi.getDescricao().equalsIgnoreCase("")) {
                ps2.execute();
            }
           
            Object opcoes[] = {"Visualizar dados","Fechar", "Cadastrar outro advogado"};
            adv.setCod_adv(codigo);
            adv.setResposta(JOptionPane.showOptionDialog(null,"Advogado inserido, o que deseja fazer?","",1,3, null, opcoes, null));
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
        return adv;
}
public void deletar(Advogado adv) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM advogado WHERE cod_adv=?");
            pstmt.setInt(1, adv.getCod_adv());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Advogado excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }    
   public List<Advogado> listarAdvogado() {

        Connection connection = null;
        List<Advogado> advogado = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogado");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Advogado adv = new Advogado();
                adv.setCod_adv(rs.getInt("cod_adv"));
                adv.setNome(rs.getString("nome"));
                adv.setSobrenome(rs.getString("sobrenome"));
                
                adv.setCpf(rs.getString("cpf"));
                advogado.add(adv);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return advogado;
    }
   public List<Advogado> pesquisarAdvogadoPorNome(String nomes) {

        Connection connection = null;
        List<Advogado> advogado = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogado where nome like ?");
            pstmt.setString(1, "%"+nomes+"%");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Advogado adv = new Advogado();
                adv.setCod_adv(rs.getInt("cod_adv"));
                adv.setNome(rs.getString("nome"));
                adv.setSobrenome(rs.getString("sobrenome"));
                
                adv.setCpf(rs.getString("cpf"));
                advogado.add(adv);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return advogado;
    }
    public List<Advogado> pesquisarAdvogadoPorSobrenome(String nomes) {

        Connection connection = null;
        List<Advogado> advogado = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogado where sobrenome like ?");
            pstmt.setString(1, "%"+nomes+"%");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Advogado adv = new Advogado();
                adv.setCod_adv(rs.getInt("cod_adv"));
                adv.setNome(rs.getString("nome"));
                adv.setSobrenome(rs.getString("sobrenome"));
               
                adv.setCpf(rs.getString("cpf"));
                advogado.add(adv);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return advogado;
    }
    public List<Advogado> pesquisarAdvogadoPorEmail(String nomes) {

        Connection connection = null;
        List<Advogado> advogado = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogado where email like ?");
            pstmt.setString(1, "%"+nomes+"%");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Advogado adv = new Advogado();
                adv.setCod_adv(rs.getInt("cod_adv"));
                adv.setNome(rs.getString("nome"));
                adv.setSobrenome(rs.getString("sobrenome"));
                
                adv.setCpf(rs.getString("cpf"));
                advogado.add(adv);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return advogado;
    }
    public List<Advogado> pesquisarAdvogadoPorCidade(String nomes) {

        Connection connection = null;
        List<Advogado> advogado = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogado where cidade like ?");
            pstmt.setString(1, "%"+nomes+"%");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Advogado adv = new Advogado();
                adv.setCod_adv(rs.getInt("cod_adv"));
                adv.setNome(rs.getString("nome"));
                adv.setSobrenome(rs.getString("sobrenome"));
                
                adv.setCpf(rs.getString("cpf"));
                advogado.add(adv);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return advogado;
    }
   public Advogado buscarAdvogado(Advogado adv) {
        Connection connection = null;
       
        Sexo sex = new Sexo();
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM advogado where cod_adv = ?");
            pstmt.setInt(1, adv.getCod_adv());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                adv.setCod_adv(rs.getInt("cod_adv"));
              
                adv.setEst_civ(rs.getString("est_civ"));
                adv.setCpf(rs.getString("cpf"));
                
                adv.setNome(rs.getString("nome"));
                adv.setSobrenome(rs.getString("sobrenome"));
                sex.setId(rs.getInt("sexo"));
                adv.setSexo(sex);
               
                adv.setData_nasc(rs.getDate("data_nasc"));
                adv.setRg(rs.getString("rg"));
            }
            connection.close();
            return adv;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
   
   public void editarAdvogado(Advogado adv) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE advogado set nome=?, sobrenome=?, cpf=?, rg=?, sexo=?, data_nasc=?, est_civ=? where cod_adv=?");
            pstmt.setString(1, adv.getNome());
           
           
           pstmt.setString(2, adv.getSobrenome());
           pstmt.setString(3, adv.getCpf());
           pstmt.setString(4, adv.getRg());
           pstmt.setInt(5, adv.getSexo().getId());
           pstmt.setDate(6, adv.getData_nasc());
           pstmt.setString(7, adv.getEst_civ());
           
           pstmt.setInt(8, adv.getCod_adv()); 
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Advogado alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
   public boolean verificaCPF(String cpf){
       Connection connection = null;
       boolean validador=false;
       try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM advogado");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (cpf.equals(rs.getString("cpf"))) {
                    validador = true;
                    break;
                }
                
                
                
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
   return validador;
   }
   public boolean verificaExclusao(int cod){
       Connection connection = null;
       boolean validador=false;
       try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processo");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (cod==rs.getInt("advogado")) {
                    validador = true;
                    break;
                }
                
                
                
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
   return validador;
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
