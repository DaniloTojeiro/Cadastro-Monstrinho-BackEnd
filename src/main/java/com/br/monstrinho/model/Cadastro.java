package com.br.monstrinho.model;

import com.br.monstrinho.dto.CreateCadastroRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cadastro_db")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumModalidade modalidade;

    private String nome;
    private String endereco;
    private String rg;
    private String cpf;

    @Column(name = "dt_nasc")
    private LocalDate dtNasc;

    private String celular;
    private String telefone;
    private String email;

    @Column(name = "cel_responsavel")
    private String celResponsavel;

    @JsonFormat(pattern = "HH:mm:ss")
    private Time horario;

    @Enumerated(EnumType.STRING)
    private EnumGenero genero;

    @Enumerated(EnumType.STRING)
    private EnumPeriodo periodo;

    @Enumerated(EnumType.STRING)
    private EnumEsportes esportes;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @Enumerated(EnumType.STRING)
    private EnumTurma turma;

    public Cadastro(CreateCadastroRequestDTO dto){
        this.modalidade = dto.getModalidade();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.dtNasc = dto.getDtNasc();
        this.celular = dto.getCelular();
        this.telefone = dto.getTelefone();
        this.email = dto.getEmail();
        this.celResponsavel = dto.getCelResponsavel();
        this.horario = dto.getHorario();
        this.genero = dto.getGenero();
        this.periodo = dto.getPeriodo();
        this.esportes = dto.getEsportes();
        this.nomeResponsavel = dto.getNomeResponsavel();
        this.turma = dto.getTurma();
    }
}

