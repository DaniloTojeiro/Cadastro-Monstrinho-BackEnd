package com.br.monstrinho.exception;

import lombok.Getter;

@Getter
public enum ProblemType {

    RESOURCE_NOT_FOUND("/resource-not-found", "Recurso não encontrado");

    private String title;
    private String uri;

    private ProblemType(String path, String title){
        this.uri = "https://monstrinho.com.br" + path;
        this.title = title;
    }
}
