package com.generation.prodigio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.prodigio.model.Produto;

@Repository
public interface ProdutosRepository  extends JpaRepository <Produto, Long>{

    public List <Produto>findAllByNomeMateriaContainingIgnoreCase(String nomeMateria);
    
    
    @Query(value="select * from tb_produto where categoria_id = :materia", nativeQuery=true)
    List<Produto> getProdutPorMateria(Long materia);

}