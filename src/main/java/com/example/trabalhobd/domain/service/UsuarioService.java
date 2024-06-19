package com.example.trabalhobd.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.trabalhobd.domain.dto.usuario.UsuarioRequestDTO;
import com.example.trabalhobd.domain.dto.usuario.UsuarioResponseDTO;
import com.example.trabalhobd.domain.exception.BadRequestException;
import com.example.trabalhobd.domain.exception.ResourceNotFoundException;
import com.example.trabalhobd.domain.model.Usuario;
import com.example.trabalhobd.domain.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICRUDService<UsuarioRequestDTO, UsuarioResponseDTO> {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public List<UsuarioResponseDTO> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO obterPorId(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }
        return mapper.map(optUsuario.get(), UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        verificarDTO(dto);
        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(dto.getEmail());
        if(optUsuario.isPresent()){
            throw new BadRequestException("Já existe um usuário com esse email");
        }
        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setDataCadastro(new Date());
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        verificarDTO(dto);
        UsuarioResponseDTO usuarioBanco = obterPorId(id);
        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setId(id);
        usuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));
        usuario.setDataInativacao(usuarioBanco.getDataInativacao());
        usuario.setDataCadastro(usuarioBanco.getDataCadastro());
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }
        Usuario usuario = optUsuario.get();
        usuario.setDataInativacao(new Date());
        usuarioRepository.save(usuario);
    }

    private void verificarDTO(UsuarioRequestDTO dto){
        if(dto.getEmail() == null || dto.getEmail() == "" || dto.getSenha() == null || dto.getSenha() == ""){
            throw new BadRequestException("Email e Senha são obrigatórios");
        }
    }
}
