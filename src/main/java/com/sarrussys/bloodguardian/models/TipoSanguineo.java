package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tipos_sanguineos")
public class TipoSanguineo {
    @Id
    @Column(name = "id_tipo_sanguineo")
    private Integer idTipoSanguineo;
    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;

    public TipoSanguineo() {
    }

    public TipoSanguineo(Integer idTipoSanguineo, String tipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
        this.tipoSanguineo = tipoSanguineo;
    }

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
}
