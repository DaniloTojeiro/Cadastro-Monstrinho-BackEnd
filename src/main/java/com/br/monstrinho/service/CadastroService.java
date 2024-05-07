package com.br.monstrinho.service;

import com.br.monstrinho.dto.CreateCadastroRequestDTO;
import com.br.monstrinho.dto.UpdateCadastroRequestDTO;
import com.br.monstrinho.exception.models.CadastroNotFoundException;
import com.br.monstrinho.model.Cadastro;
import com.br.monstrinho.repositories.CadastroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    @Autowired
    public CadastroService(CadastroRepository cadastroRepository){
        this.cadastroRepository = cadastroRepository;
    }

    public List<Cadastro> findAllCadastro(){
        return cadastroRepository.findAll();
    }

    public Cadastro findCadastroById(Long id){
        return cadastroRepository.findById(id)
                .orElseThrow(() -> new CadastroNotFoundException(id));
    }

    @Transactional
    public Cadastro createCadastro(CreateCadastroRequestDTO dto){
        Cadastro cadastro = new Cadastro(dto);
        return cadastroRepository.save(cadastro);
    }

    @Transactional
    public ResponseEntity<Void> deleteCadastro(Long id){
        Optional<Cadastro> cadastroOptional = cadastroRepository.findById(id);
        cadastroOptional.ifPresent(cadastro -> cadastroRepository.deleteById(id));
        return cadastroOptional.map(cadastro -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public Optional<Cadastro> updateCadastro(Long id, UpdateCadastroRequestDTO dto){
        return Optional.ofNullable(dto)
                .flatMap(d -> cadastroRepository.findById(id)
                    .map(existingCadastro -> {
                        existingCadastro.setNome(d.getNome());
                        existingCadastro.setEndereco(d.getEndereco());
                        existingCadastro.setRg(d.getRg());
                        existingCadastro.setCpf(d.getCpf());
                        existingCadastro.setDtNasc(d.getDtNasc());
                        existingCadastro.setCelular(d.getCelular());
                        existingCadastro.setTelefone(d.getTelefone());
                        existingCadastro.setEmail(d.getEmail());
                        existingCadastro.setCelResponsavel(d.getCelResponsavel());
                        existingCadastro.setHorario(d.getHorario());
                        existingCadastro.setGenero(d.getGenero());
                        existingCadastro.setPeriodo(d.getPeriodo());
                        existingCadastro.setNomeResponsavel(d.getNomeResponsavel());
                        return cadastroRepository.save(existingCadastro);
                    }));

    }
}
