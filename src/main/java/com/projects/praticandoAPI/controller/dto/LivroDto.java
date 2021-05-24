package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.modelo.Topico;
import com.projects.praticandoAPI.modelo.Usuario;

public class LivroDto {

	private String nomeLivro;
	private double valorMoeda;
	private boolean relidadeAumentada;
	private boolean gamificacao;
	private long id;
	
	
	public LivroDto(Livro livro) {
		this.nomeLivro = livro.getNomeLivro();
		this.valorMoeda = livro.getValorMoeda();
		this.relidadeAumentada = livro.isRelidadeAumentada();
		this.gamificacao = livro.isGamificacao();
		this.id = livro.getId();
	}
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public boolean isRelidadeAumentada() {
		return relidadeAumentada;
	}
	public void setRelidadeAumentada(boolean relidadeAumentada) {
		this.relidadeAumentada = relidadeAumentada;
	}
	public double getValorMoeda() {
		return valorMoeda;
	}
	public void setValorMoeda(double valorMoeda) {
		this.valorMoeda = valorMoeda;
	}
	public boolean isGamificacao() {
		return gamificacao;
	}
	public void setGamificacao(boolean gamificacao) {
		this.gamificacao = gamificacao;
	}
	
	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}
	

}
