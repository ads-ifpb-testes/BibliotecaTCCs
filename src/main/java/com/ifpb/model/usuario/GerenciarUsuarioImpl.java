package com.ifpb.model.usuario;

import java.util.HashMap;

import com.ifpb.model.Usuario;

public class GerenciarUsuarioImpl implements GerenciarUsuario{
	private static HashMap<String, Usuario> usuarios = new HashMap<>();
	@Override
	public boolean cadastrarUsuario(String nome, String sexo, String email, String senha, String curso) {
		if(usuarios.put(email, new Usuario(nome, sexo, email, senha, curso))==null)
			return true;
		return false;
	}
	@Override
	public boolean excluirUsuario(String email) {
		if(usuarios.remove(email)!=null)
			return true;
		return false;
	}
}