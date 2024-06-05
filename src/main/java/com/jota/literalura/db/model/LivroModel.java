package com.jota.literalura.db.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "LIVROS")
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String idioma;
    private String autor;
    private Integer downloads;

    public LivroModel() {
    }

    public LivroModel(String titulo, String idioma, String autor, Integer downloads) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.autor = autor;
        this.downloads = downloads;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroModel that = (LivroModel) o;
        return id == that.id && Objects.equals(titulo, that.titulo) && Objects.equals(idioma, that.idioma) && Objects.equals(autor, that.autor) && Objects.equals(downloads, that.downloads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, idioma, autor, downloads);
    }

    public void exibirLivro() {
        System.out.println("----- LIVRO -----");
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Idioma: " + this.getIdioma());
        System.out.println("Número de downloads: " + this.getDownloads());
        System.out.println("-----------------\n");
    }

    @Override
    public String toString() {
        return "LivroModel{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", autor=" + autor +
                ", downloads=" + downloads +
                '}';
    }
}
