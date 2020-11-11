package com.projetointegrador.Ecommerce.repository;

//Repositório criado para comunicação com o MySQL

//Nessa interface iremos salvar, deletar ou atualizar informações solicitadas com banco de dados


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.Ecommerce.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//Método importado de buscar por Nome, usuario e senha e usuario  
	//consultar ou buscar os  atributos onde irá buscar todos os Nome, usuario e senha e usuario   independente se a letra é maiuscula ou minuscula

	public List <Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
	public Optional<Usuario> findByUsuario(String usuario);
	
		
}

