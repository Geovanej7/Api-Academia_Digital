package com.example.academia.academia_digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.academia.academia_digital.infra.utils.JavaTimeUtils;
import com.example.academia.academia_digital.model.Aluno;
import com.example.academia.academia_digital.model.AvaliacaoFisica;
import com.example.academia.academia_digital.model.form.AlunoForm;
import com.example.academia.academia_digital.model.form.AlunoUpdateForm;
import com.example.academia.academia_digital.repository.AlunoRepository;
import com.example.academia.academia_digital.service.IAlunoService;

import jakarta.persistence.EntityNotFoundException;

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
        return repository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if(dataDeNascimento == null){
            return repository.findAll();
        }else{
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }
       
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno = repository.findById(id).get();
        
        return aluno.getAvaliacoes();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {

        Optional<Aluno> optionalAluno = repository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setNome(formUpdate.getNome());
            aluno.setBairro(formUpdate.getBairro());
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

            return repository.save(aluno);
        } else {
            throw new EntityNotFoundException("Aluno com id " + id + " não encontrado.");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
