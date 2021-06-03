
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Advogado;
import model.bean.Cliente;
import model.bean.Processo;
import model.bean.Tipo_cliente;
import model.connection.ConnectionFactory;

/**
 *
 * @author Pedro
 */
public class ProcessoDAO {
    public Processo inserirProcesso(Processo pro){
       
        Connection connection = null;
        try{
            
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO processo (acao, observacoes, advogado, cliente, descricao, codigo) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, pro.getAcao());
            pstmt.setString(2, pro.getObservacoes());
            pstmt.setInt(3, pro.getAdvogado().getCod_adv());
            pstmt.setInt(4, pro.getCliente().getCod_cliente());
            pstmt.setString(5, pro.getDescricao());
            pstmt.setString(6, pro.getCodigo());
           
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int codigo = 0;
            if (rs.next()) {
                codigo = Integer.parseInt(rs.getString(1));
            } 
            Object opcoes[] = {"Visualizar dados","Fechar", "Cadastrar outro processo"};
            pro.setCod_processo(codigo);
            pro.setResposta(JOptionPane.showOptionDialog(null,"Processo inserido, o que deseja fazer?","",1,3, null, opcoes, null));
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   return pro;
}
     public List<Processo> listarProcesso() {
       
        Connection connection = null;
        List<Processo> processo = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processo ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Advogado adv = new Advogado();
                Cliente cli = new Cliente();
                pro.setCod_processo(rs.getInt("cod_processo"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setObservacoes(rs.getString("observacoes"));
                pro.setAcao(rs.getString("acao"));
                adv.setCod_adv(rs.getInt("advogado"));
                cli.setCod_cliente(rs.getInt("cliente"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setAdvogado(adv);
                pro.setCliente(cli);
               processo.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return processo;
    }
    /////////Pesquisar
     public List<Processo> pesquisarProcessoPorAdvogado(String cod) {
       
        Connection connection = null;
        List<Processo> processo = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processo where advogado =?");
            pstmt.setString(1, cod);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Advogado adv = new Advogado();
                Cliente cli = new Cliente();
                pro.setCod_processo(rs.getInt("cod_processo"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setObservacoes(rs.getString("observacoes"));
                pro.setAcao(rs.getString("acao"));
                adv.setCod_adv(rs.getInt("advogado"));
                cli.setCod_cliente(rs.getInt("cliente"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setAdvogado(adv);
                pro.setCliente(cli);
               processo.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return processo;
    }
     public List<Processo> pesquisarProcessoPorCliente(String cod) {
       
        Connection connection = null;
        List<Processo> processo = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processo where cliente =?");
            pstmt.setString(1, cod);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Advogado adv = new Advogado();
                Cliente cli = new Cliente();
                pro.setCod_processo(rs.getInt("cod_processo"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setObservacoes(rs.getString("observacoes"));
                pro.setAcao(rs.getString("acao"));
                adv.setCod_adv(rs.getInt("advogado"));
                cli.setCod_cliente(rs.getInt("cliente"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setAdvogado(adv);
                pro.setCliente(cli);
               processo.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return processo;
    }
     public List<Processo> pesquisarProcessoPorAcao(String acao) {
       
        Connection connection = null;
        List<Processo> processo = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processo where acao like ?");
            pstmt.setString(1, "%"+acao+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Advogado adv = new Advogado();
                Cliente cli = new Cliente();
                pro.setCod_processo(rs.getInt("cod_processo"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setObservacoes(rs.getString("observacoes"));
                pro.setAcao(rs.getString("acao"));
                adv.setCod_adv(rs.getInt("advogado"));
                cli.setCod_cliente(rs.getInt("cliente"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setAdvogado(adv);
                pro.setCliente(cli);
               processo.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return processo;
    }
     public List<Processo> pesquisarProcessoPorDescricao(String desc) {
       
        Connection connection = null;
        List<Processo> processo = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM processo where descricao like ?");
            pstmt.setString(1, "%"+desc+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Processo pro = new Processo();
                Advogado adv = new Advogado();
                Cliente cli = new Cliente();
                pro.setCod_processo(rs.getInt("cod_processo"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setObservacoes(rs.getString("observacoes"));
                pro.setAcao(rs.getString("acao"));
                adv.setCod_adv(rs.getInt("advogado"));
                cli.setCod_cliente(rs.getInt("cliente"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setAdvogado(adv);
                pro.setCliente(cli);
               processo.add(pro);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return processo;
    } 
    ////////// 
    public Processo buscarProcesso(Processo pro ) {
        Connection connection = null;
        Advogado adv = new Advogado();
        Cliente cli = new Cliente();
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM processo where cod_processo = ?");
            pstmt.setInt(1, pro.getCod_processo());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pro.setCod_processo(rs.getInt("cod_processo"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setObservacoes(rs.getString("observacoes"));
                pro.setAcao(rs.getString("acao"));
                adv.setCod_adv(rs.getInt("advogado"));
                cli.setCod_cliente(rs.getInt("cliente"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setAdvogado(adv);
                pro.setCliente(cli);
                
                
            }
            connection.close();
            return pro;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void editarProcesso(Processo processo) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE processo set acao=?, observacoes=?, advogado=?, cliente=?, descricao=?, codigo=? where cod_processo=?");
            pstmt.setString(1, processo.getAcao());
            pstmt.setString(2, processo.getObservacoes());
            pstmt.setInt(3, processo.getAdvogado().getCod_adv());
            pstmt.setInt(4, processo.getCliente().getCod_cliente());
            pstmt.setString(5, processo.getDescricao());
            pstmt.setString(6, processo.getCodigo());
            pstmt.setInt(7, processo.getCod_processo());
            
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Processo alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    
    public void deletar(Processo pro) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM processo WHERE cod_processo=?");
            pstmt.setInt(1, pro.getCod_processo());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Processo excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
     public boolean verificaExclusao(int cod){
       Connection connection = null;
       boolean validador=false;
       try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM audiencia");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (cod==rs.getInt("processo")) {
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
}