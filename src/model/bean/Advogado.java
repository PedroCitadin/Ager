/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Pedro
 */
public class Advogado {
  private int cod_adv;
  private String nome;
  
  private String est_civ;
  private String cpf;
  private Sexo sexo;
  private String sobrenome;
  private String rg;
  private Date data_nasc;
  
  ////Dados de contato
  private String email;
  private String ddd;
  private String num_telefone;

    public int getCod_adv() {
        return cod_adv;
    }

    public void setCod_adv(int cod_adv) {
        this.cod_adv = cod_adv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo id_sexo_adv) {
        this.sexo= id_sexo_adv;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNum_telefone() {
        return num_telefone;
    }

    public void setNum_telefone(String numero_telefone) {
        this.num_telefone = numero_telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    @Override
    public String toString() {
        return " Nome: "+nome + " "+sobrenome+"      CPF: "+cpf+" Codigo:"+cod_adv; 
    }

 
   
   
}
