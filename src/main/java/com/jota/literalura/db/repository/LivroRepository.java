package com.jota.literalura.db.repository;

import com.jota.literalura.db.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroModel, Integer> {

    Optional<LivroModel> findByTitulo(String titulo);
    List<LivroModel> findByIdioma(String idioma);
}
