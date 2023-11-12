package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tipos_sanguineos")
public class TipoSanguineo {
    private Integer idTipoSanguineo;
    private String tipoSanguineo;
    //private List<Doador> doador;

    //private List<BolsaSangue> bolsaSangue;

    public TipoSanguineo() {
    }

    public TipoSanguineo(Integer idTipoSanguineo, String tipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
        this.tipoSanguineo = tipoSanguineo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdTipoSanguineo() {
        return idTipoSanguineo;
    }

    public void setIdTipoSanguineo(Integer idTipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    /*@OneToMany(mappedBy = "idTipoSanguineo")
    public List<Doador> getDoador() {
        return doador;
    }

    public void setDoador(List<Doador> doador) {
        this.doador = doador;
    }

    @OneToMany(mappedBy = "tipoSanguineo")
    public List<BolsaSangue> getBolsaSangue() {
        return bolsaSangue;
    }

    public void setBolsaSangue(List<BolsaSangue> bolsaSangue) {
        this.bolsaSangue = bolsaSangue;
    }*/
}
