package com.example.academia.academia_digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.academia.academia_digital.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

     List<Matricula> findByAlunoBairro(String bairro);
}
