package com.generation.prodigio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.prodigio.model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository <Categoria, Long>{

	public List <Categoria>findAllByMateriaContainingIgnoreCase(String materia);
}
