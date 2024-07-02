package com.example.academia.academia_digital.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisica {


    private Long ind;

    private Aluno aluno;

    private LocalDateTime dataDaAvaliacao;

    private double peso;

    private double altura;

}
