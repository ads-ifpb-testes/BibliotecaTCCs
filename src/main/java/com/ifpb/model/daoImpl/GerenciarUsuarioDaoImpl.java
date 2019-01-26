package com.ifpb.model.daoImpl;

import java.util.HashMap;

import com.ifpb.model.Usuario;
import com.ifpb.model.dao.GerenciarUsuarioDao;

public class GerenciarUsuarioDaoImpl implements GerenciarUsuarioDao{
	private static HashMap<String, Usuario> usuarios = new HashMap<>();
	@Override
	public boolean cadastrarUsuario(String nome, String sexo, String email, String senha, String curso) {
		if(usuarios.put(email, new Usuario(nome, sexo, email, senha, curso))!=null)
			return true;
		return false;
	}
	@Override
	public boolean excluirUsuario(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean login(String email, String senha) {
		// TODO Auto-generated method stub
		return false;
	}
}