package br.edu.ifce.academico.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String sigla;
	
	private String nome;

	@ManyToMany
	@JoinTable(name = "matriz_curricular_disciplina",
		joinColumns = @JoinColumn(name = "disciplina_id"),
		inverseJoinColumns = @JoinColumn(name = "matriz_curricular_id"))
	private List<MatrizCurricular> matrizCurricular;
	
	private Boolean status;
	
	public Disciplina() {
		this.status = true;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
