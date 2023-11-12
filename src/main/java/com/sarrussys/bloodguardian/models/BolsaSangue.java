package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_bolsas_sangue")
public class BolsaSangue {
    private Integer codigoBolsa;
    private TipoSanguineo tipoSanguineo;
    private Date dtColeta;
    private Date validade; //TODO esse atributo não seria uma data?

    public BolsaSangue() {
    }

    public BolsaSangue(Integer codigoBolsa, TipoSanguineo tipoSanguineo, Date dtColeta, Date validade) {
        this.codigoBolsa = codigoBolsa;
        this.tipoSanguineo = tipoSanguineo;
        this.dtColeta = dtColeta;
        this.validade = validade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getCodigoBolsa() {
        return codigoBolsa;
    }

    public void setCodigoBolsa(Integer codigoBolsa) {
        this.codigoBolsa = codigoBolsa;
    }

    @ManyToOne
    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Date getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(Date dtColeta) {
        this.dtColeta = dtColeta;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}
