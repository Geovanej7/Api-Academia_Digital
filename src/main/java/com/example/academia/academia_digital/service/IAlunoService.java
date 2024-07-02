package com.example.academia.academia_digital.service;

import java.util.List;

import com.example.academia.academia_digital.model.Aluno;
import com.example.academia.academia_digital.model.form.AlunoForm;
import com.example.academia.academia_digital.model.form.AlunoUpdateForm;

public interface IAlunoService {

    Aluno create(AlunoForm form);

    Aluno get(Long id);

    List <Aluno> getAll();

    Aluno update(Long id, AlunoUpdateForm formUpdate);

    void delete(Long id);
}
