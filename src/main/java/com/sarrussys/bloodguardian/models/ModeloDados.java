package com.sarrussys.bloodguardian.models;

import static java.lang.Integer.parseInt;

public class ModeloDados {
    private String tipoSanguineo;
    private String quantidade;
    private String duracao;

    public ModeloDados(String tipoSanguineo, String quantidade){
        this.tipoSanguineo = tipoSanguineo;
        this.quantidade = quantidade;
        this.duracao = ""+parseInt(quantidade)*3;
    }

    public String getQuantidade(){
        return this.quantidade;
    }
    public String getDuracao(){
        return this.duracao;
    }
    public String getTipoSanguineo(){
        return this.tipoSanguineo;
    }





}
