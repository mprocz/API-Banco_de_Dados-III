package com.example.trabalhobd.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalhobd.domain.dto.dashboard.ClassIndicativaDashboardResponseDTO;
import com.example.trabalhobd.domain.dto.filme.FilmeResponseDTO;

@Service
public class DashboardService {
    @Autowired
    private FilmeService service;

    public ClassIndicativaDashboardResponseDTO obterFilmesPorClassificacaoIndicativa(String idadeInicial, String idadeFinal){
        List<FilmeResponseDTO> filmes = service.obterPorClassificacaoIndicativa(idadeInicial, idadeFinal);
        int counter = filmes.size();
        return new ClassIndicativaDashboardResponseDTO(counter, filmes);
    }

    public ClassIndicativaDashboardResponseDTO obterFilmesPorAno(String ano){
        List<FilmeResponseDTO> filmes = service.obterPorAno(ano);
        int counter = filmes.size();
        return new ClassIndicativaDashboardResponseDTO(counter, filmes);
    }

    public ClassIndicativaDashboardResponseDTO obterFilmesPorGenero(String genero){
        List<FilmeResponseDTO> filmes = service.obterPorGenero(genero);
        int counter = filmes.size();
        return new ClassIndicativaDashboardResponseDTO(counter, filmes);
    }
}
