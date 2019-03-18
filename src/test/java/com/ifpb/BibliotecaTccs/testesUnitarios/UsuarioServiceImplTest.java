package com.ifpb.BibliotecaTccs.testesUnitarios;

import java.sql.SQLOutput;
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

	/**
	 *Caso de teste nº002
	 *
	 * Esse caso de texte tem a finalidade de efetuar o teste de login
	 * de maneira correta, porém, com um usuário não cadastrado.
	 */

	@Test
	public void testeFazerLoginComUsuarioNãoCastrado() {
		try {
			Mockito.when(gerenciarUsuarioMock.readUsuarios()).thenReturn(criarHashMapDeUsuarios());
			Assert.assertFalse(usuarioServiceImpl.login("antonio@gmail.com", "645312", gerenciarUsuarioMock));

		}catch (Exception e){
			e.printStackTrace();
		}


	}

	/**
	 * Caso de teste nº003
	 *
	 * Esse caso de teste tem a finalidade de efetuar o teste de login com um usuário cadastrado,
	 * porém, com a senha inválida.
	 *
	 */

	@Test
	public void testeFazerLoginComUsuarioCastradoSenhaInvalida() {
		try {
			Mockito.when(gerenciarUsuarioMock.readUsuarios()).thenReturn(criarHashMapDeUsuarios());
			Assert.assertFalse(usuarioServiceImpl.login("Jose@gmail.com", "085764", gerenciarUsuarioMock));

		}catch (Exception e){
			e.printStackTrace();
		}


	}



}
