package com.ifpb.model.dao;

public interface GerenciarUsuarioDao {
	boolean cadastrarUsuario(String nome, String sexo, String email, String senha, String curso);
	boolean excluirUsuario(String email);
	boolean login(String email, String senha);
}
