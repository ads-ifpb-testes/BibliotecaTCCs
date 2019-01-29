package com.ifpb.model.tcc;

import java.time.LocalDate;
import java.util.ArrayList;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Tcc;

public interface GerenciarTcc {
	boolean cadastrarTcc(LocalDate dataTcc, String titulo, String tema, String autor, String pathTcc)throws ArquivoInexistenteException;
	boolean excluirTcc(String titulo, String autor);
	ArrayList<Tcc> buscarPorTitulo(String titulo);
}
