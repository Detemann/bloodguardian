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
    @Column(name = "data_saida")
    private Date dtSaida;

    public Saidas() {
    }

    public Saidas(BolsaSangue bolsaSangue, Date dtSaida) {
        this.bolsaSangue = bolsaSangue;
        this.dtSaida = dtSaida;
    }
    public BolsaSangue getCodigoBolsa() {
        return bolsaSangue;
    }

    public void setCodigoBolsa(BolsaSangue codigoBolsa) {
        this.bolsaSangue = codigoBolsa;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }
}
