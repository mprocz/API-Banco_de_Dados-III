package com.example.trabalhobd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.trabalhobd.domain.dto.filme.FilmeRequestDTO;
import com.example.trabalhobd.domain.dto.filme.FilmeResponseDTO;
import com.example.trabalhobd.domain.service.FilmeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
    @Autowired
    private FilmeService service;

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> obterTodos() {
        return ResponseEntity.ok(service.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> cadastrar(@RequestBody FilmeRequestDTO dto) {
        //System.out.println("ola marilene");
        FilmeResponseDTO filme = service.cadastrar(dto);
        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> atualizar(@PathVariable Long id, @RequestBody FilmeRequestDTO dto) {
        FilmeResponseDTO filme = service.atualizar(id, dto);
        return ResponseEntity.ok(filme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
