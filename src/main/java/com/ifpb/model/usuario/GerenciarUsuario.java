package com.ifpb.model.usuario;

public interface GerenciarUsuario {
	boolean cadastrarUsuario(String nome, String sexo, String email, String senha, String curso);
	boolean excluirUsuario(String email);
	
}
