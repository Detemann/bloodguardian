package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "tb_bolsas_sangue")
public class BolsaSangue {
    @Id
    @Column(name = "cod_bolsa")
    private String codigoBolsa;
    @ManyToOne
    @JoinColumn(name = "id_tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;
    @Column(name = "data_coleta")
    private Date dtColeta;
    @Column(name = "validade_bolsa")
    private Date validade;

    public BolsaSangue() {
    }

    public BolsaSangue(String codigoBolsa, Date dtColeta, Date validade) {
        this.codigoBolsa = codigoBolsa;
        this.dtColeta = dtColeta;
        this.validade = validade;
    }
    public String getCodigoBolsa() {
        return codigoBolsa;
    }

    public void setCodigoBolsa(String codigoBolsa) {
        this.codigoBolsa = codigoBolsa;
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

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public int calcularDuracao(AtomicInteger quant) {
        if (quant.get() < 1) {
            return 0;
        }

        return 3 * quant.get();
    }
}
