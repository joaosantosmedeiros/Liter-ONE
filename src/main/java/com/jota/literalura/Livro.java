package com.jota.literalura;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Livro {
    private String title;
    private String[] languages;
    private Integer download_count;
    private Author[] authors;

    public Livro() {
    }

    public Livro(String title, String[] languages, Integer download_count, Author[] authors) {
        this.title = title;
        this.languages = languages;
        this.download_count = download_count;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public void exibirLivro() {
        System.out.println("----- LIVRO -----");
        System.out.println("Título: " + this.getTitle());
        System.out.println("Autor: " + Arrays.stream(this.getAuthors()).map(Author::getName).collect(Collectors.joining()));
        System.out.println("Idioma: " + String.join(", ", this.getLanguages()));
        System.out.println("Número de downloads: " + this.getDownload_count());
        System.out.println("-----------------\n");
    }
}


