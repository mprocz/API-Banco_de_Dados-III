package com.example.trabalhobd.domain.dto.filme;

import java.util.List;

import com.example.trabalhobd.domain.Enum.EGenero;

public class FilmeRequestDTO {
    private String titulo;
    private String autor;
    private String produtor;
    private int ano;
    private int duracao;
    private int classificacaoIndicativa;
    private List<EGenero> genero;
    
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
    public List<EGenero> getGenero() {
        return genero;
    }
    public void setGenero(List<EGenero> genero) {
        this.genero = genero;
    }
    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }
    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }
}
