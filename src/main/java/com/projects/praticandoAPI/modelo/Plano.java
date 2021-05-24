package com.projects.praticandoAPI.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Plano implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoPlano tipoPlano = TipoPlano.FREE;
	
	@OneToMany(mappedBy="plano")
	private List<Usuario> usuarios;
	
	@ManyToMany(mappedBy="planos", cascade = CascadeType.ALL)
    @JsonBackReference
	private List<Livro> livros;
	
	public Plano() {
		super();
	}

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
		Plano other = (Plano) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}


	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		for (Livro livro : livros) {
			if(this.tipoPlano == TipoPlano.PREMIUM) {
				if(livro.isRelidadeAumentada() && !livro.isGamificacao()) {
					this.livros.add(livro);
				}
				
			}
			else if(this.tipoPlano == TipoPlano.VIP) {
				if(livro.isRelidadeAumentada() && livro.isGamificacao()) {
					this.livros.add(livro);
				}
				
			}
			else {
				if(!livro.isRelidadeAumentada() && !livro.isGamificacao()) {
					this.livros.add(livro);
				}
				
			}
			
		}
	}

	
}
