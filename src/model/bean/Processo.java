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
public class Processo {
    private int cod_processo;
    private String acao;
    private String observacoes;
    private Advogado advogado;
    private Cliente cliente;
    private String descricao;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getCod_processo() {
        return cod_processo;
    }

    public void setCod_processo(int cod_processo) {
        this.cod_processo = cod_processo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String motivo) {
        this.acao = motivo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Tipo: "+acao+"      Descrição: "+descricao+"      Código de Registro:"+cod_processo;
    }
    
}
