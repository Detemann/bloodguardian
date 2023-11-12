package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_doadores")
public class Doador {
    private Integer cpf;
    private TipoSanguineo idTipoSanguineo;
    private String nome;
    private Date dtNascimento;
    private String email;
    private String telefone;

    public Doador() {
    }

    public Doador(Integer cpf, TipoSanguineo idTipoSanguineo, String nome, Date dtNascimento, String email, String telefone) {
        this.cpf = cpf;
        this.idTipoSanguineo = idTipoSanguineo;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }
    @ManyToOne
    public TipoSanguineo getIdTipoSanguineo() {
        return idTipoSanguineo;
    }

    public void setIdTipoSanguineo(TipoSanguineo idTipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
