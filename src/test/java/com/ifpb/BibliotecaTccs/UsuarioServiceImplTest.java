package com.ifpb.BibliotecaTccs;

import java.util.HashMap;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.Assert;

import com.ifpb.model.Usuario;
import com.ifpb.model.usuario.GerenciarUsuarioImpl;
import com.ifpb.model.usuario.UsuarioServiceImpl;

public class UsuarioServiceImplTest {
	@Mock
	private GerenciarUsuarioImpl gerenciarUsuarioMock;
	
	private UsuarioServiceImpl usuarioServiceImpl;
	
	public UsuarioServiceImplTest() {
		MockitoAnnotations.initMocks(this);
		usuarioServiceImpl = new UsuarioServiceImpl();
	}
	
	public HashMap<String, Usuario> criarHashMapDeUsuarios(){
		HashMap<String, Usuario> usuarios = new HashMap<>();
		usuarios.put("ze@gmail.com", new Usuario("Zé", "M", "ze@gmail.com", "123654", "ADS"));
		usuarios.put("Jose@gmail.com", new Usuario("Jose", "M", "jose@gmail.com", "123654", "ADS"));
		return usuarios;
	}
	
	@Test
	public void RealizarLoginCorretamente() {
		Mockito.when(gerenciarUsuarioMock.readUsuarios()).thenReturn(criarHashMapDeUsuarios());
		Assert.assertTrue(usuarioServiceImpl.login("Jose@gmail.com", "123654", gerenciarUsuarioMock));
	}
}
