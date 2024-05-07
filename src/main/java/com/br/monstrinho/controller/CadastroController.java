package com.br.monstrinho.controller;

import com.br.monstrinho.dto.CreateCadastroRequestDTO;
import com.br.monstrinho.dto.UpdateCadastroRequestDTO;
import com.br.monstrinho.model.Cadastro;
import com.br.monstrinho.service.CadastroService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;


@RestController
@RequestMapping("/cadastros")
@Validated
public class CadastroController {

    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService){
        this.cadastroService = cadastroService;
    }

    @Operation(summary = "Find All Cadastro")
    @GetMapping
    public ResponseEntity<List<Cadastro>> findAllCadastro(){
        List<Cadastro> all =cadastroService.findAllCadastro();
        if (isEmpty(all)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Operation(summary = "Create Cadastro")
    @PostMapping("/create")
    public ResponseEntity<Void> createCadastro(@RequestBody CreateCadastroRequestDTO dto) {
        cadastroService.createCadastro(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Find Cadastro by Id")
    @GetMapping("{id}")
    public ResponseEntity<Cadastro> findCadastroById(@PathVariable Long id){
        Cadastro response = cadastroService.findCadastroById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Delete Cadastro by Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCadastro(@PathVariable("id") Long id){
        return cadastroService.deleteCadastro(id).getStatusCode() == HttpStatus.OK ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update Cadastro by Id")
    @PutMapping("update/{id}")
    @Transactional
    public ResponseEntity<Object> updateCadastro(@PathVariable("id") Long id,
                                                 @RequestBody UpdateCadastroRequestDTO dto){
        return cadastroService.updateCadastro(id, dto)
                .map(cadastro -> new ResponseEntity<>(HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}





