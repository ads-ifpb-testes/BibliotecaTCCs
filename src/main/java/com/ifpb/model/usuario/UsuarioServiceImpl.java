package com.ifpb.model.usuario;

import java.util.HashMap;

import com.ifpb.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService{
	@Override
	public boolean login(String email, String senha, HashMap<String, Usuario> usuarios) {
		if(usuarios.containsKey(email)) {
			if (usuarios.get(email).getSenha().equals(senha))
				return true;
		}
		return false;
	}
}
