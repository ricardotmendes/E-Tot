package com.projetointegrador.Ecommerce.controller;



	import java.util.List;

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

	import com.projetointegrador.Ecommerce.model.Categoria;
	import com.projetointegrador.Ecommerce.repository.CategoriaRepository;

	


	//Anotação da classe como Controller
	@RestController
	//Anotação para mapear a URL
	@RequestMapping("/categoria")
	//Anotação para receber todos tipos de parâmetros 
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class CategoriaController {
		
		//Anotação para inclusão das dependências
		@Autowired
		private CategoriaRepository repository;
		
		//Método para buscar todas informações 
		@GetMapping
		public ResponseEntity<List<Categoria>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		//Método para buscar pelo ID
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> GetById(@PathVariable long id){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		
		//Método para buscar pelo Nome
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Categoria>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
		

		
		
		//Método para incluir dados
		@PostMapping
		public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(repository.save(categoria));
		}

		//Método para atualizar dados já existente 
		@PutMapping
		public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){
			return ResponseEntity.ok(repository.save(categoria));				
		}
		
		//Método para deletar dados 
		@DeleteMapping("/{id}")
		public void deleteId(@PathVariable long id) {
			repository.deleteById(id);
		}
	
	
	
	
	
}
