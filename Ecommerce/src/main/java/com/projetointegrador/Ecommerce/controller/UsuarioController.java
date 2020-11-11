package com.projetointegrador.Ecommerce.controller;

import java.util.List;
import java.util.Optional;

import com.projetointegrador.Ecommerce.model.UsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.Ecommerce.model.Usuario;
import com.projetointegrador.Ecommerce.repository.UsuarioRepository;
import com.projetointegrador.Ecommerce.service.UsuarioService;




//Anotação da classe como Controller
@RestController
//Anotação para mapear a URL
//Toda vez que tiver acesso ao /usuario será chamado essa classe
@RequestMapping("/usuario")
//Anotação para receber todos tipos de parâmetros 
//Vai aceitar o front end de qualquer origem
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Anotação para inclusão das dependências
	//Onde inserimos o repositorio nessa classe
	@Autowired
	private UsuarioRepository repository;
	
	//Método para buscar todas informações 
	//Buscar por todos os usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Método para buscar pelo ID
	//Faz a busca do usuario pelo Id ou caso não encontre deixa a mensagem notfound(não encontrado)
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	//Incluir um novo login no banco de dados
	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	//ira cadastrar um novo usuario
	@PostMapping("/cadastro")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		try {
				return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	//Método para buscar pelo Nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome){
	return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	//Método para atualizar dados já existente 
	//atualizar informação de usuario
	@PutMapping
	public ResponseEntity<Usuario> putUsuario (@RequestBody Usuario usuario){
		return ResponseEntity.ok(repository.save(usuario));				
	}
	
	//Método para deletar dados 
	//deletar dados de usuario
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}





}