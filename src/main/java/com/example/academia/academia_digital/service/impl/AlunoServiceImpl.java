package com.example.academia.academia_digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.academia.academia_digital.model.Aluno;
import com.example.academia.academia_digital.model.AvaliacaoFisica;
import com.example.academia.academia_digital.model.form.AlunoForm;
import com.example.academia.academia_digital.model.form.AlunoUpdateForm;
import com.example.academia.academia_digital.repository.AlunoRepository;
import com.example.academia.academia_digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll() {
       return repository.findAll();
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno = repository.findById(id).get();
        
        return aluno.getAvaliacoes();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
