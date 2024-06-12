package com.example.trabalhobd.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalhobd.domain.model.Filme;
import com.example.trabalhobd.domain.model.Usuario;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
    List<Filme> findByUsuario(Usuario usuario);
}
