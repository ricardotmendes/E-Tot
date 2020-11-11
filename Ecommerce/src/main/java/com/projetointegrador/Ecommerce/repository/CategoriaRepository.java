package com.projetointegrador.Ecommerce.repository;


//Repositório criado para comunicação com o MySQL

//Nessa interface iremos salvar, deletar ou atualizar informações solicitadas com banco de dados

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.Ecommerce.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	//Método importado de buscar por "titulo"  
	//consultar ou buscar os  atributos onde irá buscar todos os titulos independente se a letra é maiuscula ou minuscula

	public List <Categoria> findAllByTituloContainingIgnoreCase (String titulo);
	

		
}
