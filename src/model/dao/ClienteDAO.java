/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.connection.ConnectionFactory;
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
import model.bean.Sexo;
import model.bean.Telefone;
import model.bean.Tipo_cliente;




/**
 *
 * @author Pedro
 */
public class ClienteDAO {
    public Cliente inserirPessoaFisica(Cliente cliente, Endereco end, Telefone tel, Email emi){
       
        Connection connection = null;
        try{
           connection = ConnectionFactory.getConnection();
            
                           PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO cliente (nome, tipo, est_Civ, cpf, sobrenome, sexo, rg, Profissao, data_nasc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                           
                         
                            PreparedStatement pstm = connection
                   .prepareStatement("INSERT INTO endereco(numero, cep, cidade, estado, rua, bairro, complemento, cod_end_cli)VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            
                            PreparedStatement ps = connection
                   .prepareStatement("INSERT INTO telefone(ddd, numero, cliente)VALUES(?, ?, ?)");
                           
                           PreparedStatement ps2 = connection
                   .prepareStatement("INSERT INTO email(descricao, cliente)VALUES(?, ?)");
                            
           pstmt.setString(1, cliente.getNome());
           pstmt.setInt(2, cliente.getTipo().getCod_tipo());
           
           pstmt.setString(3, cliente.getEst_civ());
           pstmt.setString(4, cliente.getCpf());
           pstmt.setString(5, cliente.getSobrenome());
           pstmt.setInt(6, cliente.getSexo().getId());
         
           pstmt.setString(7, cliente.getRg());
           pstmt.setString(8, cliente.getProfissao());
           pstmt.setDate(9, cliente.getData_nasc());
           pstmt.executeUpdate();
          
            /////endereço/////
            ResultSet rs = pstmt.getGeneratedKeys();
            int codigo = 0;
            if (rs.next()) {
                codigo = Integer.parseInt(rs.getString(1));
            }
            pstm.setInt(1, end.getNumero());
            pstm.setString(2, end.getCep());
            pstm.setString(3, end.getCidade());
            pstm.setString(4, end.getEstado());
            pstm.setString(5, end.getRua());
            pstm.setString(6, end.getBairro());
            pstm.setString(7, end.getComplemento());
            pstm.setInt(8, codigo);
            
           if ((!end.getCep().equalsIgnoreCase(""))&&(!end.getCidade().equalsIgnoreCase(""))&&(!end.getRua().equalsIgnoreCase(""))&&(!end.getBairro().equalsIgnoreCase(""))&&(!end.getComplemento().equalsIgnoreCase(""))) {
                pstm.execute();
            }
           /////////////////
           ps.setString(1, tel.getDdd());
           ps.setString(2, tel.getNumero());
           ps.setInt(3, codigo);
           ps.execute();
           ///////////
           ps2.setString(1, emi.getDescricao());
           ps2.setInt(2, codigo);
          if (!emi.getDescricao().equalsIgnoreCase("")) {
                ps2.execute();
            }
            
            Object opcoes[] = {"Visualizar dados","Fechar", "Cadastrar outro cliente"};
            cliente.setCod_cliente(codigo);
            cliente.setResposta(JOptionPane.showOptionDialog(null,"Cliente inserido, o que deseja fazer?","",1,3, null, opcoes, null));
           
          connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   return cliente;
}
 public void inserirPessoaJuridica(Cliente cliente, Endereco end, Telefone tel, Email emi){
       
     
        Connection connection = null;
        try{
        connection = ConnectionFactory.getConnection();
            
                           PreparedStatement pstmt = connection
                   .prepareStatement("INSERT INTO cliente (nome, tipo, nome_fant, cnpj) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                           
                    PreparedStatement pstm = connection
                   .prepareStatement("INSERT INTO endereco(numero, cep, cidade, estado, rua, bairro, complemento, cod_end_cli)VALUES(?, ?, ?, ?, ?, ?, ?, ?)");     
            
                    
                            PreparedStatement ps = connection
                   .prepareStatement("INSERT INTO telefone(ddd, numero, cliente)VALUES(?, ?, ?)");
                           
                           PreparedStatement ps2 = connection
                   .prepareStatement("INSERT INTO email(descricao, cliente)VALUES(?, ?)");
                            
                
            
           pstmt.setString(1, cliente.getNome());
           pstmt.setInt(2, cliente.getTipo().getCod_tipo());
           
           pstmt.setString(3, cliente.getNome_fant());
           pstmt.setString(4, cliente.getCnpj());
           pstmt.executeUpdate();
           
           /////endereço/////
            ResultSet rs = pstmt.getGeneratedKeys();
            int codigo = 0;
            if (rs.next()) {
                codigo = Integer.parseInt(rs.getString(1));
            }
            pstm.setInt(1, end.getNumero());
            pstm.setString(2, end.getCep());
            pstm.setString(3, end.getCidade());
            pstm.setString(4, end.getEstado());
            pstm.setString(5, end.getRua());
            pstm.setString(6, end.getBairro());
            pstm.setString(7, end.getComplemento());
            pstm.setInt(8, codigo);
            if ((!end.getCep().equalsIgnoreCase(""))&&(!end.getCidade().equalsIgnoreCase(""))&&(!end.getRua().equalsIgnoreCase(""))&&(!end.getBairro().equalsIgnoreCase(""))&&(!end.getComplemento().equalsIgnoreCase(""))) {
                pstm.execute();
            }
            
            
            ps.setString(1, tel.getDdd());
           ps.setString(2, tel.getNumero());
           ps.setInt(3, codigo);
           ps.execute();
           ///////////
           ps2.setString(1, emi.getDescricao());
           ps2.setInt(2, codigo);
           if (!emi.getDescricao().equalsIgnoreCase("")) {
                ps2.execute();
            }
           Object opcoes[] = {"Visualizar dados","Fechar", "Cadastrar outro cliente"};
            cliente.setCod_cliente(codigo);
            cliente.setResposta(JOptionPane.showOptionDialog(null,"Cliente inserido, o que deseja fazer?","",1,3, null, opcoes, null));
           
           connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
            
            
            
        }
   
}
public void deletar(Cliente cli) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM cliente WHERE cod_cliente=?");
            pstmt.setInt(1, cli.getCod_cliente());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluído.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }


public List<Cliente> listarFisica() {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
                cli.setCpf(rs.getString("cpf"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }
   ///Pesquisar Fisica
public List<Cliente> pesquisarFisicaPorNome(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=1 and nome like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
                cli.setCpf(rs.getString("cpf"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }

public List<Cliente> pesquisarFisicaPorSobrenome(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=1 and sobrenome like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
                cli.setCpf(rs.getString("cpf"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }

public List<Cliente> pesquisarFisicaPorCidade(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=1 and cidade like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
                cli.setCpf(rs.getString("cpf"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }
public List<Cliente> pesquisarFisicaPorEmail(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=1 and email like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
                cli.setCpf(rs.getString("cpf"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }


















///
 ///Pesquisar Juridica
public List<Cliente> pesquisarJuridicaPorNome(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=2 and nome like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setNome_fant(rs.getString("nome_fant"));
                cli.setCnpj(rs.getString("cnpj"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }

public List<Cliente> pesquisarJuridicaPorFantasia(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=2 and nome_fant like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setNome_fant(rs.getString("nome_fant"));
                cli.setCnpj(rs.getString("cnpj"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }

public List<Cliente> pesquisarJuridicaPorCidade(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=2 and cidade like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
               cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setNome_fant(rs.getString("nome_fant"));
                cli.setCnpj(rs.getString("cnpj"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }
public List<Cliente> pesquisarJuridicaPorEmail(String nomes) {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=2 and email like ?");
            pstmt.setString(1, "%"+nomes+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setNome_fant(rs.getString("nome_fant"));
                cli.setCnpj(rs.getString("cnpj"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }


















///
public List<Cliente> listarJuridica() {

        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente where tipo=2");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setNome_fant(rs.getString("nome_fant"));
                cli.setCnpj(rs.getString("cnpj"));
               
                cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }    
    
public Cliente buscarFisica(Cliente cli ) {
        Connection connection = null;
       
        Sexo sex = new Sexo();
        Tipo_cliente tip = new Tipo_cliente();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM cliente where cod_cliente = ?");
            pstmt.setInt(1, cli.getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setEst_civ(rs.getString("est_civ"));
                cli.setCpf(rs.getString("cpf"));
                cli.setProfissao(rs.getString("profissao"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
                sex.setId(rs.getInt("sexo"));
                cli.setSexo(sex);
                tip.setCod_tipo(rs.getInt("tipo"));
                cli.setData_nasc(rs.getDate("data_nasc"));
                cli.setRg(rs.getString("rg"));
            }
            connection.close();
            return cli;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente buscarJuridica(Cliente cli ) {
        Connection connection = null;
       
        
        Tipo_cliente tip = new Tipo_cliente();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM cliente where cod_cliente = ?");
            pstmt.setInt(1, cli.getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setCnpj(rs.getString("cnpj"));
                cli.setNome_fant(rs.getString("nome_fant"));
                
                cli.setNome(rs.getString("nome"));
                
               
                tip.setCod_tipo(rs.getInt("tipo"));
                
                
            }
            connection.close();
            return cli;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void editarJuridica(Cliente cliente) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE cliente set nome=?, tipo=?, nome_fant=?, cnpj=? where cod_cliente=?");
            pstmt.setString(1, cliente.getNome());
           pstmt.setInt(2, 2);
           
           pstmt.setString(3, cliente.getNome_fant());
           pstmt.setString(4, cliente.getCnpj());
            pstmt.setInt(5, cliente.getCod_cliente()); 
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    public void editarFisica(Cliente cliente) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE cliente set nome=?,tipo=?, sobrenome=?, cpf=?, rg=?, sexo=?, data_nasc=?, est_civ=?, profissao=? where cod_cliente=?");
            pstmt.setString(1, cliente.getNome());
           pstmt.setInt(2, 1);
           
           pstmt.setString(3, cliente.getSobrenome());
           pstmt.setString(4, cliente.getCpf());
           pstmt.setString(5, cliente.getRg());
           pstmt.setInt(6, cliente.getSexo().getId());
           pstmt.setDate(7, cliente.getData_nasc());
           pstmt.setString(8, cliente.getEst_civ());
           pstmt.setString(9, cliente.getProfissao());
           pstmt.setInt(10, cliente.getCod_cliente()); 
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }
    public List<Cliente> listarCliente() {
        Tipo_cliente tip = new Tipo_cliente();
        Connection connection = null;
        List<Cliente> cliente = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setNome(rs.getString("nome"));
                cli.setSobrenome(rs.getString("sobrenome"));
               cli.setNome_fant(rs.getString("nome_fant"));
               cli.setCpf(rs.getString("cpf"));
               cli.setCnpj(rs.getString("cnpj"));
               tip.setCod_tipo(rs.getInt("tipo"));
               cli.setTipo(tip);
               cliente.add(cli);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return cliente;
    }
    
    
    
    
     public Cliente buscarCliente(Cliente cli ) {
        Connection connection = null;
       Tipo_cliente tip = new Tipo_cliente();
        
        
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM cliente where cod_cliente = ?");
            pstmt.setInt(1, cli.getCod_cliente());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                tip.setCod_tipo(rs.getInt("tipo"));
                cli.setTipo(tip);
                cli.setNome_fant(rs.getString("nome_fant"));
                cli.setSobrenome(rs.getString("Sobrenome"));
                cli.setNome(rs.getString("nome"));
                
               
                
                
                
            }
            connection.close();
            return cli;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     public boolean verificaCPF(String cpf){
       Connection connection = null;
       boolean validador=false;
       try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente");
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
 public boolean verificaCNPJ(String cnpj){
       Connection connection = null;
       boolean validador=false;
       try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (cnpj.equals(rs.getString("cnpj"))) {
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
                if (cod==rs.getInt("cliente")) {
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