package com.projetointegrador.Ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;

//Nossa tabela de "Categoria" serve para classificar os cursos por nome e tipo deles, podendo assim 
//gerar vários tipos e categorizá-los de formas diversas
//Ex: 
//Nome: Curso de Java
//Tipo: Programação
//Presencial: Se o curso é presencial ou EAD



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




	@Entity// essa classe será uma entidade do jpa hibernate
	@Table(name = "tb_Categoria")// essa anotação informa que essa entidade será uma tabela no banco de dados 
	public class Categoria {
		
		//Aqui colocamos os atributos utilizados na nosso ecommerce onde será a categoria
		
		//O ID será nossa chave primaria de identificação
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		//titulo será a materia do produto
		@NotNull
		@Size(min = 2, max = 255)
		private String titulo;
		
	
		//esse produto possui metodo de relacionamento com a tabela produto para que seja varios produtos e uma categoria
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List<Produto> produto;
		
		
		
		
	
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
	
	
		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public List<Produto> getProduto() {
			return produto;
		}
	
		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
	
	
	
		
		
	}