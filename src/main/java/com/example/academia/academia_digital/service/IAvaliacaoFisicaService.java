package com.example.academia.academia_digital.service;

import java.util.List;

import com.example.academia.academia_digital.model.AvaliacaoFisica;
import com.example.academia.academia_digital.model.form.AvaliacaoFisicaForm;
import com.example.academia.academia_digital.model.form.AvaliacaoFisicaUpdateForm;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaForm form);

    AvaliacaoFisica get(Long id);

    List<AvaliacaoFisica> getall();

    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);
    
    void delete(Long id);
}
