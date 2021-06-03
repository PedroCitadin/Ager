/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Pedro
 */
public class Endereco {
    private int cod_end;
    private Advogado cod_end_adv;
    private Cliente cod_end_cli;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;

    public int getCod_end() {
        return cod_end;
    }

    public void setCod_end(int cod_end) {
        this.cod_end = cod_end;
    }

    public Advogado getCod_end_adv() {
        return cod_end_adv;
    }

    public void setCod_end_adv(Advogado cod_end_adv) {
        this.cod_end_adv = cod_end_adv;
    }

    public Cliente getCod_end_cli() {
        return cod_end_cli;
    }

    public void setCod_end_cli(Cliente cod_end_cli) {
        this.cod_end_cli = cod_end_cli;
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
    
    
}
