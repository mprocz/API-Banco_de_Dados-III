package com.example.trabalhobd.common;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.trabalhobd.domain.model.Usuario;

public class GetCurrentUser {
    public static Usuario getUsuario(){
        return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
