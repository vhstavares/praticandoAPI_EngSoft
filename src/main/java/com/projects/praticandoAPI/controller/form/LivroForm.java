package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.modelo.Usuario;
import com.projects.praticandoAPI.repository.LivroRepository;
import com.projects.praticandoAPI.repository.UsuarioRepository;

public class LivroForm {
	
	private String nomeLivro;
	private double valorMoeda;
	private boolean relidadeAumentada;
	private boolean gamificacao;
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public double getValorMoeda() {
		return valorMoeda;
	}
	public void setValorMoeda(double valorMoeda) {
		this.valorMoeda = valorMoeda;
	}
	public boolean isRelidadeAumentada() {
		return relidadeAumentada;
	}
	public void setRelidadeAumentada(boolean relidadeAumentada) {
		this.relidadeAumentada = relidadeAumentada;
	}
	public boolean isGamificacao() {
		return gamificacao;
	}
	public void setGamificacao(boolean gamificacao) {
		this.gamificacao = gamificacao;
	}
	
	public Livro converter(LivroRepository usuarioRepository) {
		
		return new Livro(nomeLivro, valorMoeda, relidadeAumentada, gamificacao);
	}
	
	
}
