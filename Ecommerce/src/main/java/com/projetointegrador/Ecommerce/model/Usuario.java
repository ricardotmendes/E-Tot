package com.projetointegrador.Ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity// essa classe será uma entidade do jpa hibernate
@Table(name = "tb_Usuario")// essa anotação informa que essa entidade será uma tabela no banco de dados 
public class Usuario {
	
	//Aqui colocamos os atributos utilizados na nosso ecommerce onde terá o nosso usuario
	
	//O ID será nossa chave primaria de identificação
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	//nome do aluno ou professor
	@NotNull
	@Size(min = 2, max = 255)
	private String nome;
	
	//email do aluno ou professor
	@NotNull
	@Size(min = 2, max = 255)
	private String email;
	
	//o usuario escolhido pelo aluno ou professor
	@NotNull
	@Size(min = 5, max = 100)
	private String usuario;
	
	//senha escolhida pelo aluno ou professor
	@NotNull
	@Size(min = 2, max = 255)
	private String senha;

	
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}