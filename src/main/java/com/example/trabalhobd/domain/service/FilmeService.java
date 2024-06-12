package com.example.trabalhobd.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalhobd.common.GetCurrentUser;
import com.example.trabalhobd.domain.dto.filme.FilmeRequestDTO;
import com.example.trabalhobd.domain.dto.filme.FilmeResponseDTO;
import com.example.trabalhobd.domain.exception.ResourceNotFoundException;
import com.example.trabalhobd.domain.model.Filme;
import com.example.trabalhobd.domain.model.Usuario;
import com.example.trabalhobd.domain.repository.FilmeRepository;

@Service
public class FilmeService implements ICRUDService<FilmeRequestDTO, FilmeResponseDTO>{
    @Autowired
    private FilmeRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<FilmeResponseDTO> obterTodos() {
        Usuario usuario = GetCurrentUser.getUsuario();
        List<Filme> list = repository.findByUsuario(usuario);
        return list.stream().map(filme -> mapper.map(filme, FilmeResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public FilmeResponseDTO obterPorId(Long id) {
        Optional<Filme> optFilme = repository.findById(id);
        if(optFilme.isEmpty()){
            throw new ResourceNotFoundException("Filme não encontrado");
        }
        Usuario usuario = GetCurrentUser.getUsuario();
        if(optFilme.get().getUsuario().getId() != usuario.getId()){
            throw new ResourceNotFoundException("O titulo com o Id:" + id +" Não existe");
        }
        return mapper.map(optFilme.get(), FilmeResponseDTO.class);
    }

    @Override
    public FilmeResponseDTO cadastrar(FilmeRequestDTO dto) {
        Filme filme = mapper.map(dto, Filme.class);
        Usuario usuario = GetCurrentUser.getUsuario();
        filme.setUsuario(usuario);
        filme.setId(null);
        filme = repository.save(filme);
        return mapper.map(filme, FilmeResponseDTO.class);
    }

    @Override
    public FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto) {
        obterPorId(id);
        Filme filme = mapper.map(dto, Filme.class);
        Usuario usuario = GetCurrentUser.getUsuario();
        filme.setUsuario(usuario);
        filme.setId(id);
        filme = repository.save(filme);
        return mapper.map(filme, FilmeResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        repository.deleteById(id);
    }

}
