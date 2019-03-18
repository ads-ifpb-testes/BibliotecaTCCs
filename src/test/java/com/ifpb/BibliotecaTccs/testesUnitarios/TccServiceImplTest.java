package com.ifpb.BibliotecaTccs.testesUnitarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ifpb.model.Tcc;
import com.ifpb.model.tcc.GerenciarTccImpl;
import com.ifpb.model.tcc.TccServiceImpl;

public class TccServiceImplTest {
	@Mock
	GerenciarTccImpl gerenciarTccMock;
	
	
	TccServiceImpl tccServiceImpl;


	public void GeraPalavras(){
		// Determia as letras que poderão estar presente nas chaves
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for( int i = 0; i < 9; i++ ) {
			index = random.nextInt( letras.length() );
			armazenaChaves += letras.substring( index, index + 1 );
		}
		System.out.println( armazenaChaves );
	}

	
	public TccServiceImplTest() {
		MockitoAnnotations.initMocks(this);
		tccServiceImpl = new TccServiceImpl();
	}
	
	public ArrayList<Tcc> criarListaTcc(){
		ArrayList<Tcc> tccs = new ArrayList<>();
		
		Tcc t1 = new Tcc();
		t1.setAutor("Maria");
		t1.setTitulo("Mas o que diabos é cobol?!");
		Tcc t2 = new Tcc();
		t2.setAutor("Zé");
		t2.setTitulo("Inteligência superficial");
		tccs.add(t1);
		tccs.add(t2);
		
		return tccs;
	}
	
	@Test
	public void comentarTccCorretamente() {
		Mockito.when(gerenciarTccMock.lerTcc()).thenReturn(criarListaTcc());
		Assert.assertNotNull(tccServiceImpl.comentarTcc("Lixo", "Inteligência superficial", "Zé", gerenciarTccMock));
	}

	/**
	 * Caso de teste nº 012
	 *
	 * Esse caso de teste tem a finalidade de efetuar um comentário sobre um tcc com mais de 256 caracteres.
	 */

	@Test
	public void comentarTccComMaisDe256Caracteres() {


		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for( int i = 0; i < 257; i++ ) {
			index = random.nextInt( letras.length() );
			armazenaChaves += letras.substring( index, index + 1 );
		}


		Mockito.when(gerenciarTccMock.lerTcc()).thenReturn(criarListaTcc());
		Assert.assertNull(tccServiceImpl.comentarTcc(armazenaChaves,"Inteligência superficial", "Zé", gerenciarTccMock));

	}
}
