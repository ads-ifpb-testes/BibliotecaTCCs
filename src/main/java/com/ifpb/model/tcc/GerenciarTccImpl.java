package com.ifpb.model.tcc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Tcc;



public class GerenciarTccImpl implements GerenciarTcc {
	private List<Tcc> tccs = new ArrayList<>(); 
	
	public boolean cadastrarTcc(LocalDate dataTcc, String titulo, String tema, String autor, String pathTcc) throws ArquivoInexistenteException {
		return tccs.add(new Tcc(dataTcc, titulo, tema, autor, pathTcc));
	}



	public boolean excluirTcc(String titulo, String autor) {
		for(Tcc t:tccs) {
			if(t.getTitulo().equals(titulo) && t.getAutor().equals(autor)) {
				return tccs.remove(t);
			}
		}
		return false;
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
