package com.example.trabalhobd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalhobd.domain.dto.dashboard.ClassIndicativaDashboardResponseDTO;
import com.example.trabalhobd.domain.service.DashboardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;
    
    @GetMapping("/indicativa")
    public ResponseEntity<ClassIndicativaDashboardResponseDTO> obterFilmesByClassificacaoIndicativa(
        @RequestParam(name="idadeInicial") String idadeInicial,
        @RequestParam(name="idadeFinal") String idadeFinal){
        return ResponseEntity.ok(dashboardService.obterFilmesPorClassificacaoIndicativa(idadeInicial, idadeFinal));
    }

    @GetMapping("/ano")
    public ResponseEntity<ClassIndicativaDashboardResponseDTO> obterFilmesByAno(
        @RequestParam(name="ano") String ano){
        return ResponseEntity.ok(dashboardService.obterFilmesPorAno(ano));
    }

    @GetMapping("/genero")
    public ResponseEntity<ClassIndicativaDashboardResponseDTO> obterFilmesByGenero(
        @RequestParam(name="genero") String genero){
        return ResponseEntity.ok(dashboardService.obterFilmesPorGenero(genero));
    }
}
    