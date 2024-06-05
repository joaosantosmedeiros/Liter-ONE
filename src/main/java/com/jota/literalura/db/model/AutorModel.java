package com.jota.literalura.db.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTORES")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    @OneToMany(fetch = FetchType.EAGER)
    private List<LivroModel> livros = new ArrayList<>();

    public AutorModel(String nome, Integer anoNascimento, Integer anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }
    public AutorModel() {}

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

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<LivroModel> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroModel> livros) {
        this.livros = livros;
    }

    public void exibirAutor() {
        System.out.println("----- AUTOR -----");
        System.out.println("Autor: " + this.nome);
        System.out.println("Ano de nascimento: " + this.anoNascimento);
        System.out.println("Ano de falecimento: " + this.anoFalecimento);
        System.out.println("Livros: " + this.livros.stream().map(LivroModel::getTitulo).toList());
        System.out.println("-----------------\n");
    }

    @Override
    public String toString() {
        return "AutorModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoFalecimento=" + anoFalecimento +
                ", livros=" + livros +
                '}';
    }
}
