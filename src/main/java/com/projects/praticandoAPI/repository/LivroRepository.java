package com.projects.praticandoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.praticandoAPI.modelo.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
