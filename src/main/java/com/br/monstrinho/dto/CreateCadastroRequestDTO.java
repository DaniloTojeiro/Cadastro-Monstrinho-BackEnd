package com.br.monstrinho.dto;

import com.br.monstrinho.model.EnumEsportes;
import com.br.monstrinho.model.EnumGenero;
import com.br.monstrinho.model.EnumModalidade;
import com.br.monstrinho.model.EnumPeriodo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateCadastroRequestDTO {
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O endereço não pode estar em branco")
    private String endereco;

    @NotBlank(message = "O RG não pode estar em branco")
    private String rg;

    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    private LocalDate dtNasc;

    @NotBlank(message = "O número de celular não pode estar em branco")
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{5}-\\d{4}", message = "O celular deve estar no formato (XX) XXXXX-XXXX")
    private String celular;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXX-XXXX")
    private String telefone;

    @NotBlank(message = "O e-mail não pode estar em branco")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{5}-\\d{4}", message = "O celular do responsável deve estar no formato (XX) XXXXX-XXXX")
    private String celResponsavel;

    private Time horario;

    private EnumGenero genero;

    private EnumPeriodo periodo;

    private EnumModalidade modalidade;

    private EnumEsportes esportes;

    private String nomeResponsavel;
}
