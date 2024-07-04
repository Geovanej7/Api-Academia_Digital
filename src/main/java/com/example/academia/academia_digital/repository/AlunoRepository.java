package com.example.academia.academia_digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.academia.academia_digital.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
