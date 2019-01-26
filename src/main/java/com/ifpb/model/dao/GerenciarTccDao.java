package com.ifpb.model.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Tcc;

public interface GerenciarTccDao {
	boolean cadastrarTcc(LocalDate dataTcc, String titulo, String tema, String autor, String pathTcc, String[] palavrasChaves)throws ArquivoInexistenteException;
	boolean excluirTcc(String titulo, String autor);
	boolean comentarTcc(String comentario, String titulo, String autor);
	ArrayList<Tcc> buscarPorTitulo(String titulo);
}
