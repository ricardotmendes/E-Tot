package com.projetointegrador.Ecommerce.repository;

//Repositório criado para comunicação com o MySQL

//Nessa interface iremos salvar, deletar ou atualizar informações solicitadas com banco de dados


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.Ecommerce.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	//Método importado de buscar pelo atributo nome  
	//consultar ou buscar os  atributos onde irá buscar todos os nomes independente se a letra é maiuscula ou minuscula


	public List <Produto> findAllByNomeContainingIgnoreCase (String nome);
	
	
		
}
