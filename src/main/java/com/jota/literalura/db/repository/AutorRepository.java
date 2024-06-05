package com.jota.literalura.db.repository;

import com.jota.literalura.db.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorModel, Integer> {

    Optional<AutorModel> findByNome(String nome);

}
