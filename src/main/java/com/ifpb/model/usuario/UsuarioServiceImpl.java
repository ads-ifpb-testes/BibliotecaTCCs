package com.ifpb.model.usuario;

import java.util.HashMap;

import com.ifpb.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService{
	@Override
	public boolean login(String email, String senha, GerenciarUsuarioImpl dao) {
		
		if(dao.readUsuarios().containsKey(email)) {
			if (dao.readUsuarios().get(email).getSenha().equals(senha))
				return true;
		}
		return false;
	}
}
