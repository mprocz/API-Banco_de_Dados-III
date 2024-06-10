package com.example.trabalhobd.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.trabalhobd.domain.model.Usuario;
import com.example.trabalhobd.domain.repository.UsuarioRepository;

@Component
public class UserDetailsSecurityServer implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(username);
        if(optUsuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário ou senha incorretos!");
        }
        return optUsuario.get();
    }
}
