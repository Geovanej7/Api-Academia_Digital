package com.example.academia.academia_digital.model.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaForm {

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "O Id do aluno precisa ser positivo.")
    private Long alunoId;
}
