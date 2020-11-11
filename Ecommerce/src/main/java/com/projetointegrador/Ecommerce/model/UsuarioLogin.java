package com.projetointegrador.Ecommerce.model;

public class UsuarioLogin {

	//Os atributos de nosso usuarioLogin
	
	//Esse será o usuario a cadastrar
	private String usuario;
	
	//A senha escolhida
	private String senha;
	
	private String token;



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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
