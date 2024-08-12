package org.javaexercises.lojaservice.model;

import jakarta.persistence.*;

@Entity
@Table(name="lojas")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    public Loja(String telefone, String endereco, String nome, Long id) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.nome = nome;
        this.id = id;
    }

    public Loja() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
