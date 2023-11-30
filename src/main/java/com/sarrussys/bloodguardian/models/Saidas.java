package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_saidas")
public class Saidas implements Serializable {
    @Id
    @ManyToOne
    private BolsaSangue bolsaSangue;
    @Column(name = "nome_paciente")
    private String nomePaciente;
    @Column(name = "nome_hospital")
    private String nomeHospital;
    @Column(name = "data_saida")
    private Date dtSaida;

    public Saidas() {
    }

    public Saidas(BolsaSangue bolsaSangue, String nomePaciente, String nomeHospital, Date dtSaida) {
        this.bolsaSangue = bolsaSangue;
        this.nomePaciente = nomePaciente;
        this.nomeHospital = nomeHospital;
        this.dtSaida = dtSaida;
    }
    public BolsaSangue getCodigoBolsa() {
        return bolsaSangue;
    }

    public void setCodigoBolsa(BolsaSangue codigoBolsa) {
        this.bolsaSangue = codigoBolsa;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }
}
