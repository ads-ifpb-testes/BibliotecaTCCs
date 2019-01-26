package com.ifpb.model.daoImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Tcc;
import com.ifpb.model.dao.GerenciarTccDao;



public class GerenciarTccDaoImpl implements GerenciarTccDao {
	private static List<Tcc> tccs = new ArrayList<>(); 
	
	public boolean cadastrarTcc(LocalDate dataTcc, String titulo, String tema, String autor, String pathTcc, String[] palavrasChaves) throws ArquivoInexistenteException {
		return tccs.add(new Tcc(dataTcc, titulo, tema, autor, pathTcc, palavrasChaves));
	}

	@Override
	public boolean excluirTcc(String titulo, String autor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean comentarTcc(String comentario, String titulo, String autor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Tcc> buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}
}
