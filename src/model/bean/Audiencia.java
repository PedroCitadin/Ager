/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Pedro
 */
public class Audiencia {
    private Date data;
    private int cod_audiencia;
    private Processo processo;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;
    private Time hora;
    private int resposta; 

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
    
   
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCod_audiencia() {
        return cod_audiencia;
    }

    public void setCod_audiencia(int cod_audiencia) {
        this.cod_audiencia = cod_audiencia;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo_Cod_processo) {
        this.processo = processo_Cod_processo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String escreveEstado(String est){
        String estado = null;
        if(est.equalsIgnoreCase("AC")){
            estado = "Acre"; 
        }else if(est.equalsIgnoreCase("AL")){
            estado = "Alagoas";
        }else if(est.equalsIgnoreCase("AP")){
            estado = "Amapá";
        }else if(est.equalsIgnoreCase("AM")){
            estado = "Amazonas";
        }else if(est.equalsIgnoreCase("BA")){
            estado = "Bahia";
        }else if(est.equalsIgnoreCase("CE")){
            estado = "Ceará";
        }else if(est.equalsIgnoreCase("DF")){
            estado = "Distrito Federal";
        }else if(est.equalsIgnoreCase("ES")){
            estado = "Espírito Santo";
        }else if(est.equalsIgnoreCase("GO")){
            estado = "Goiás";
        }else if(est.equalsIgnoreCase("MA")){
            estado = "Maranhão";
        }else if(est.equalsIgnoreCase("MT")){
            estado = "Mato Grosso";
        }else if(est.equalsIgnoreCase("MS")){
            estado = "Mato Grosso do Sul";
        }else if(est.equalsIgnoreCase("MG")){
            estado = "Minas Gerais";
        }else if(est.equalsIgnoreCase("PA")){
            estado = "Pará";
        }else if(est.equalsIgnoreCase("PB")){
            estado = "Paraíba";
        }else if(est.equalsIgnoreCase("PR")){
            estado = "Paraná";
        }else if(est.equalsIgnoreCase("PE")){
            estado = "Pernambuco";
        }else if(est.equalsIgnoreCase("PI")){
            estado = "Piauí";
        }else if(est.equalsIgnoreCase("RJ")){
            estado = "Rio de Janeiro";
        }else if(est.equalsIgnoreCase("RN")){
            estado = "Rio Grande do Norte";
        }else if(est.equalsIgnoreCase("RS")){
            estado = "Rio Grande do Sul";
        }else if(est.equalsIgnoreCase("RO")){
            estado = "Rondônia";
        }else if(est.equalsIgnoreCase("RR")){
            estado = "Roraima";
        }else if(est.equalsIgnoreCase("SC")){
            estado = "Santa Catarina";
        }else if(est.equalsIgnoreCase("SP")){
            estado = "São Paulo";
        }else if(est.equalsIgnoreCase("SE")){
            estado = "Sergipe";
        }else if(est.equalsIgnoreCase("TO")){
            estado = "Tocantins";
        }
        return estado;
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
    
    
}
