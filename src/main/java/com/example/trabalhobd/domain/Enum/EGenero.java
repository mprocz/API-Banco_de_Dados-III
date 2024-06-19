package com.example.trabalhobd.domain.Enum;

public enum EGenero {
    ANIMACAO("animação"),
    AVENTURA("aventura"),
    ACAO("ação"),
    CINEMATV("cinema TV"),
    COMEDIA("comédia"),
    CRIME("crime"),
    DOCUMENTARIO("documentário"),
    DRAMA("drama"),
    FAMILIA("família"),
    FANTASIA("fantasia"),
    FAROESTE("faroeste"),
    FICCAOCIENTIFICA("ficção científica"),
    GUERRA("guerra"),
    HISTORIA("história"),
    INFANTIL("infantil"),
    MISTERIO("mistério"),
    MUSICA("música"),
    ROMANCE("romance"),
    TERROR("terror"),
    THRILLER("thriller"),
    SUSPENSE("suspense");

    private String valor;

    private EGenero(String valor){
        this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
}
