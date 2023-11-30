package com.sarrussys.bloodguardian.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_doadores")
public class Doador {
    @Id
    @Column(name = "cpf_doador")
    private String cpf;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;
    @Column(name = "nome_doador")
    private String nome;
    @Column(name = "data_nascimento")
    private Date dtNascimento;
    @Column(name = "email_doador")
    private String email;
    @Column(name = "telefone_doador")
    private String telefone;

    public Doador() {
    }

    public Doador(String cpf, String nome, Date dtNascimento, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.telefone = telefone;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
}
