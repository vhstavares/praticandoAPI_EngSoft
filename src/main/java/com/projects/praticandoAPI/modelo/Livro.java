package com.projects.praticandoAPI.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeLivro;
	private double valorMoeda;
	private boolean relidadeAumentada;
	private boolean gamificacao;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Livro_Plano",
	             joinColumns={@JoinColumn(name="LIVRO_ID")},
	             inverseJoinColumns={@JoinColumn(name="PLANO_ID")})
	@JsonBackReference
	private List<Plano> planos;
	
	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	public Livro(String nome, double valor, boolean realidade, boolean gamificacao) {
		// TODO Auto-generated constructor stub
		super();
		this.nomeLivro = nome;
		this.valorMoeda = valor;
		this.relidadeAumentada = realidade;
		this.gamificacao = gamificacao;
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	/*public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}*/

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
