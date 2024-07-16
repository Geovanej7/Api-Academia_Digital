package com.example.academia.academia_digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.academia.academia_digital.model.Aluno;
import java.util.List;
import java.time.LocalDate;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
}
