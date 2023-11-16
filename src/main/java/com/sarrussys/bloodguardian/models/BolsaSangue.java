package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_bolsas_sangue")
public class BolsaSangue {
    @Id
    @Column(name = "cod_bolsa")
    private Integer codigoBolsa;
    @ManyToOne
    @JoinColumn(name = "id_tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;
    @Column(name = "data_coleta")
    private Date dtColeta;
    @Column(name = "validade_bolsa")
    private Date validade;

    public BolsaSangue() {
    }

    public BolsaSangue(Integer codigoBolsa, Date dtColeta, Date validade) {
        this.codigoBolsa = codigoBolsa;
        this.dtColeta = dtColeta;
        this.validade = validade;
    }
    public Integer getCodigoBolsa() {
        return codigoBolsa;
    }

    public void setCodigoBolsa(Integer codigoBolsa) {
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
}
