package com.ifpb.model.usuario;

import java.util.HashMap;

import com.ifpb.model.Usuario;

public interface UsuarioService {
	boolean login(String email, String senha, HashMap<String, Usuario> usuarios);
}
