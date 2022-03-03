package com.generation.prodigio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.prodigio.model.Produto;
import com.generation.prodigio.repository.ProdutosRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
    
    @Autowired
    private ProdutosRepository produtosRepository;
    
    @GetMapping /*Listar todas os Produtos*/
    public ResponseEntity<List <Produto>> getAll() { 
        return ResponseEntity.ok(produtosRepository.findAll());
    }    
    
    @GetMapping("/{id}")    /*Listar todos os Produtos por ID*/
    public ResponseEntity<Produto> getById(@PathVariable Long id) { 
            return produtosRepository.findById(id) 
                    .map(resposta -> ResponseEntity.ok(resposta)) 
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/nome/{nome}") /*Listar Produtos atravez do nome*/
    public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String nomeMateria) {
        return ResponseEntity.ok(produtosRepository.findAllByNomeMateriaContainingIgnoreCase(nomeMateria));
    }

    @PostMapping /*Para Criar um novo produto*/
    public ResponseEntity<Produto> postCategoria(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
    }

    @PutMapping /*Para atualizar um produto existente*/
    public ResponseEntity<Produto> putCategoria(@Valid @RequestBody Produto produto) {
        return produtosRepository.findById(produto.getId()).map(resposta -> {
            return ResponseEntity.ok().body(produtosRepository.save(produto));})
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}") /*Para Deletar um produto por ID*/
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
        return produtosRepository.findById(id).map(resposta -> {
            produtosRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
                .orElse(ResponseEntity.notFound().build());
    }

}