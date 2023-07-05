package com.CourseSecurity.Security.controller;

import com.CourseSecurity.Security.entity.Produtos;
import com.CourseSecurity.Security.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:8081")
public class ProdutosController {

    private final ProdutosRepository produtosRepository;

    @Autowired
    public ProdutosController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> getAllProdutos() {
        List<Produtos> produtosList = produtosRepository.findAll();
        return ResponseEntity.ok(produtosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getProdutoById(@PathVariable UUID id) {
        Optional<Produtos> produtoOptional = produtosRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produtos produto = produtoOptional.get();
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Produtos> createProduto(@RequestBody Produtos produto) {
        Produtos createdProduto = produtosRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> updateProduto(@PathVariable UUID id, @RequestBody Produtos produto) {
        Optional<Produtos> existingProdutoOptional = produtosRepository.findById(id);
        if (existingProdutoOptional.isPresent()) {
            Produtos existingProduto = existingProdutoOptional.get();
            existingProduto.setNome(produto.getNome());
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setPreco(produto.getPreco());
            Produtos updatedProduto = produtosRepository.save(existingProduto);
            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable UUID id) {
        Optional<Produtos> produtoOptional = produtosRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
