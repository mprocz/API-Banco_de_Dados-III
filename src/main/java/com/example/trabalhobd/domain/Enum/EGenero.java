package com.example.trabalhobd.domain.Enum;

public enum EGenero {
    AVENTURA("aventura"),
    FANTASIA("fantasia"),
    INFANTIL("infantil"),
    COMEDIA("comédia"),
    FICCAOCIENTIFICA("ficção científica"),
    ACAO("ação"),
    DOCUMENTARIO("documentário"),
    TERROR("terror"),
    SUSPENSE("suspense");

    private String valor;

    private EGenero(String valor){
        this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
}
