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
public class Oab {
    private int cod_cod_oab;
    private String codigo;
    private Advogado cod_advogado;

    public int getCod_cod_oab() {
        return cod_cod_oab;
    }

    public void setCod_cod_oab(int cod_cod_oab) {
        this.cod_cod_oab = cod_cod_oab;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Advogado getCod_advogado() {
        return cod_advogado;
    }

    public void setCod_advogado(Advogado cod_advogado) {
        this.cod_advogado = cod_advogado;
    }
    

}
