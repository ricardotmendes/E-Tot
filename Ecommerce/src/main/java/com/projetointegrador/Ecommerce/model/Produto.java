package com.projetointegrador.Ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_Produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
		
	@NotNull
	@Size(min = 2, max = 255)
	private String nome;
	

	@NotNull
	private float duracao;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String professor;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String descricao;


	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getDuracao() {
		return duracao;
	}
	
	public void setDuracao(float duracao) {
	this.duracao = duracao;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
}
