package com.example.trabalhobd.domain.dto.dashboard;

import java.util.List;

import com.example.trabalhobd.domain.dto.filme.FilmeResponseDTO;

public class ClassIndicativaDashboardResponseDTO {
    private int quantidade;
    private List<FilmeResponseDTO> filmes;

    public ClassIndicativaDashboardResponseDTO(){}

    public ClassIndicativaDashboardResponseDTO(int quantidade, List<FilmeResponseDTO> filmes) {
        this.quantidade = quantidade;
        this.filmes = filmes;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public List<FilmeResponseDTO> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<FilmeResponseDTO> filmes) {
        this.filmes = filmes;
    }
}
