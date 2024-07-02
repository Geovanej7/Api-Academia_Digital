package com.example.academia.academia_digital.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    private Long id;

    private Aluno aluno;

    private LocalDateTime dataDeMatricula = LocalDateTime.now();

}
