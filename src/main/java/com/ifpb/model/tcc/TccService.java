package com.ifpb.model.tcc;

import java.util.ArrayList;

import com.ifpb.model.Tcc;

public interface TccService {
	ArrayList<Tcc> comentarTcc(String comentario, String titulo, String autor, ArrayList<Tcc> tccs);
}
