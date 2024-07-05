package com.example.academia.academia_digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.academia_digital.model.Aluno;
import com.example.academia.academia_digital.model.AvaliacaoFisica;
import com.example.academia.academia_digital.model.form.AlunoForm;
import com.example.academia.academia_digital.model.form.AlunoUpdateForm;
import com.example.academia.academia_digital.service.impl.AlunoServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return service.create(form);
    }

    @GetMapping
    public List<Aluno> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public Aluno getId(@RequestParam Long id) {
        return service.get(id);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id) {
      return service.getAllAvaliacaoFisica(id);
    }

    @PutMapping("{id}")
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm formUpdate) {
        
        return service.update(id, formUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
