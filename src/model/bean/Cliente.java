/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import static java.lang.ProcessBuilder.Redirect.to;
import java.sql.Date;
import static jdk.nashorn.internal.objects.NativeJava.to;



/**
 *
 * @author Pedro
 */
public class Cliente {
    private int cod_cliente;
    private String nome;
    private Tipo_cliente tipo;
    
    ///Dados Exclusivos de Pessoa Fisica
    private String est_civ;
    private String cpf;
    private String profissao;
    private String sobrenome;
    private Date data_nasc;
    private String rg;
    private Sexo sexo;
    //////////
    ///Dados Exclusivos de Pessoa Jurídica
    private String nome_fant;
    private String cnpj;

    /////////
    private int resposta; 

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
    
    
    
    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo_cliente getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_cliente tipo) {
        this.tipo = tipo;
    }


    public String getEst_civ() {
        return est_civ;
    }

    public void setEst_civ(String estado_civil) {
        this.est_civ = estado_civil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String atividade_profissional) {
        this.profissao = atividade_profissional;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.sobrenome = Sobrenome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNome_fant() {
        return nome_fant;
    }

    public void setNome_fant(String nome_fantasia) {
        this.nome_fant = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean verificaNumero(String n){
        boolean veri= false;
        for (int i = 0; i < n.length(); i++) {
            if (Character.isLetter(n.charAt(i))) {
              veri = true;
                break; 
              
              
                
            }
        }
        
        
        
        return veri;
        
     
      
    }
        
    
    
    @Override
    public String toString() {
        
               
        if (sobrenome==null) {
             return " Nome: "+nome + " "+nome_fant;
        }else{
             return " Nome: "+nome + " "+sobrenome; 
        }
        
       
    
           
        
        }
    
    
    
    
    
}
