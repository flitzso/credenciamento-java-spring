package com.credenciamento.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credenciamento")
public class Credenciamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @Column(name = "data_de_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String senha;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
