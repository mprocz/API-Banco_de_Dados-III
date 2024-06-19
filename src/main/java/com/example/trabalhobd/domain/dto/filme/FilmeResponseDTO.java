package com.example.trabalhobd.domain.dto.filme;

import java.util.List;

import com.example.trabalhobd.domain.Enum.EGenero;

public class FilmeResponseDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String produtor;
    private int duracao;
    private int ano;
    private int classificacaoIndicativa;
    private List<EGenero> genero;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getProdutor() {
        return produtor;
    }
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }
    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public List<EGenero> getGenero() {
        return genero;
    }
    public void setGenero(List<EGenero> genero) {
        this.genero = genero;
    }
}
