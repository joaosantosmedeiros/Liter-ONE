package com.jota.literalura;

import com.jota.literalura.db.model.AutorModel;

public class Author {
    private String name;
    private Integer birth_year;
    private Integer death_year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public void exibirAutor() {
        System.out.println("Autor: " + this.name);
        System.out.println("Ano de nascimento: " + this.getBirth_year());
        System.out.println("Ano de falecimento: " + this.getDeath_year());
    }

    public AutorModel toAutorModel() {
        return new AutorModel(
                this.name,
                this.birth_year,
                this.death_year
        );
    }
}