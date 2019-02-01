package com.ifpb.BibliotecaTccs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
