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


@Entity// essa classe será uma entidade do jpa hibernate
@Table(name = "tb_Produto")// essa anotação informa que essa entidade será uma tabela no banco de dados 
public class Produto {
	
	//Aqui colocamos os atributos utilizados na nosso ecommerce onde terá o nosso produto
	
	//O ID será nossa chave primaria de identificação
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//O nome do nosso produto que seria o material de estudo ou a aula
	@NotNull
	@Size(min = 2, max = 255)
	private String nome;
	
	//A duração do produto que seria a duração da aula
	@NotNull
	private float duracao;
	
	//O nome do Professor da aula
	@NotNull
	@Size(min = 2, max = 255)
	private String professor;
	
	//descrição do produto informações adicionais 
	@NotNull
	@Size(min = 2, max = 255)
	private String descricao;

	// E a categoaria que seria a materia 
	//essa categoria possui metodo de relacionamento com a tabela categoria  para que seja uma categoria com varios produtos
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
