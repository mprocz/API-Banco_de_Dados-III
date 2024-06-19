package com.example.trabalhobd.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.trabalhobd.domain.model.Filme;
import com.example.trabalhobd.domain.model.Usuario;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM public.filme WHERE classificacao_indicativa BETWEEN CAST(:idadeInicial as INT) AND CAST(:idadeFinal as INT)")
    List<Filme> obterFilmesPorClassificacaoIndicativa(
        @Param("idadeInicial") String idadeInicial,
        @Param("idadeFinal") String idadeFinal
    );

    @Query(nativeQuery = true, value = "SELECT * FROM public.filme WHERE ano = CAST(:ano as INT)")
    List<Filme> obterFilmesPorAno(
        @Param("ano") String ano
    );

    @Query(nativeQuery = true, value = "select f.*, fg.genero from public.filme f join public.filme_genero fg on f.id_filme=fg.id_filme where fg.genero=:genero;")

    List<Filme> obterFilmesPorGenero(
        @Param("genero") String genero
    );

    List<Filme> findByUsuario(Usuario usuario);
}
