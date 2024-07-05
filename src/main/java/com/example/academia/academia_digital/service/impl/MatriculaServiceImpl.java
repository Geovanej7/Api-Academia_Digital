package com.example.academia.academia_digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.academia.academia_digital.model.Aluno;
import com.example.academia.academia_digital.model.Matricula;
import com.example.academia.academia_digital.model.form.MatriculaForm;
import com.example.academia.academia_digital.repository.AlunoRepository;
import com.example.academia.academia_digital.repository.MatriculaRepository;
import com.example.academia.academia_digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
       
        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findByAlunoBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }

}
