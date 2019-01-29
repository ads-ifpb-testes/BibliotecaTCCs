package com.ifpb.model.tcc;

import java.util.ArrayList;

import com.ifpb.model.Tcc;

public class TccServiceImpl implements TccService{
	public ArrayList<Tcc> comentarTcc(String comentario, String titulo, String autor, ArrayList<Tcc> tccs) {
		if(comentario.length()<1 || titulo.length()<1 || autor.length()<1) {
			return null;
		}	
		for(int i=0;i<tccs.size();i++) {
			if(tccs.get(i).getAutor().equals(autor) && tccs.get(i).getTitulo().equals(titulo)) {
				tccs.get(i).setComentario(comentario);
				return tccs;
			}
		}
		return null;				
	}
}
