package com.example.academia.academia_digital.service;

import java.util.List;

import com.example.academia.academia_digital.model.Matricula;
import com.example.academia.academia_digital.model.form.MatriculaForm;

public interface IMatriculaService {

    Matricula create(MatriculaForm form);

    Matricula get(Long id);

    List<Matricula> getAll();

    void delete(Long id);

    
    
}
