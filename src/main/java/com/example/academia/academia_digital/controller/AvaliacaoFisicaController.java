package com.example.academia.academia_digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.academia_digital.model.AvaliacaoFisica;
import com.example.academia.academia_digital.model.form.AvaliacaoFisicaForm;
import com.example.academia.academia_digital.model.form.AvaliacaoFisicaUpdateForm;
import com.example.academia.academia_digital.service.impl.AvaliacaoFisicaServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping("{id}")
    public AvaliacaoFisica getId(@RequestParam Long id) {
        return service.get(id);
    }
   
    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }
    
    @PutMapping("{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm formUpdate) {
        return service.update(id, formUpdate);
    }

}
