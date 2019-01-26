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



	public boolean excluirTcc(String titulo, String autor) {
		for(Tcc t:tccs) {
			if(t.getTitulo().equals(titulo) && t.getAutor().equals(autor)) {
				return tccs.remove(t);
			}
		}
		return false;
	}

	public boolean comentarTcc(String comentario, String titulo, String autor) {
		int i = buscarPorTituloEAutor(titulo, autor);
		
		if(comentario.length()<1 || titulo.length()<1 || autor.length()<1) {
			return false;
		}	
		if(i!=-1) {
			tccs.get(i).setComentario(comentario);
			return true;
		}
		return false;
	}

	
	public int buscarPorTituloEAutor(String titulo, String autor) {
		for(int i=0;i<tccs.size();i++) {
			if(tccs.get(i).getAutor().equals(autor) && tccs.get(i).getTitulo().equals(titulo)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public ArrayList<Tcc> buscarPorTitulo(String titulo) {
		ArrayList<Tcc> l = new ArrayList<>();
		for(Tcc t : tccs) {
			if(t.getTitulo().equals(titulo)) {
				l.add(t);
			}
		}
		return l;
	}
}
