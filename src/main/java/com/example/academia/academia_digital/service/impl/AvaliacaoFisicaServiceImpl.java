package com.example.academia.academia_digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.academia.academia_digital.model.Aluno;
import com.example.academia.academia_digital.model.AvaliacaoFisica;
import com.example.academia.academia_digital.model.form.AvaliacaoFisicaForm;
import com.example.academia.academia_digital.model.form.AvaliacaoFisicaUpdateForm;
import com.example.academia.academia_digital.repository.AlunoRepository;
import com.example.academia.academia_digital.repository.AvaliacaoFisicaRepository;
import com.example.academia.academia_digital.service.IAvaliacaoFisicaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
    
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());
    
        return avaliacaoRepository.save(avaliacaoFisica);
      }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoRepository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        Optional<AvaliacaoFisica> optionalAvaliacao = avaliacaoRepository.findById(id);
        if(optionalAvaliacao.isPresent()){
            AvaliacaoFisica avaliacaoFisica = optionalAvaliacao.get();
            avaliacaoFisica.setPeso(formUpdate.getPeso());
            avaliacaoFisica.setAltura(formUpdate.getAltura());
            return avaliacaoRepository.save(avaliacaoFisica);
        }else {
            throw new EntityNotFoundException("Avaliação com id " + id + " não encontrado.");
        }
        
    }
    /* escolhi não implementar o método delete pois para nossa lógica não é preciso deletar uma avaliação fisica*/
    @Override
    public void delete(Long id) {
    }

}
