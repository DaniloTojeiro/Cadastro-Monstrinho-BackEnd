package com.br.monstrinho.exception.models;

import com.br.monstrinho.repositories.CadastroRepository;

public class CadastroNotFoundException extends EntityNotFoundException{

    private static final long serialVersionUID = 1L;

    public CadastroNotFoundException(String msg){
        super(msg);
    }

    public CadastroNotFoundException(Long id){
        this(String.format("Cadastro com o id %id não pode ser encontrado", id));
    }
}
