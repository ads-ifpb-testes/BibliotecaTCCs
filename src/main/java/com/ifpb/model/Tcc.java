package com.ifpb.model;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import com.ifpb.exceptions.ArquivoInexistenteException;

public class Tcc {
	
	private Integer id;
	private static Integer contador;
	private LocalDate dataTcc;
	private String titulo;
	private String tema;
	private String autor;
	private File arquivo;
	private String[] palavrasChaves;
	private List<String> comentarios;
	
	public Tcc(LocalDate dataTcc, String titulo, String tema, String autor, String pathTcc, String[] palavrasChaves) throws ArquivoInexistenteException {
		this.arquivo = new File(pathTcc);
		if(!arquivo.exists()) {
			throw new ArquivoInexistenteException();
		}
		this.id = ++contador;
		this.dataTcc = dataTcc;
		this.titulo = titulo;
		this.tema = tema;
		this.autor = autor;
		this.palavrasChaves = palavrasChaves;
	}
	
	public Integer getId() {
		return id;
	}
	
	public LocalDate getDataTcc() {
		return dataTcc;
	}

	public void setDataTcc(LocalDate dataTcc) {
		this.dataTcc = dataTcc;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public File getArquivo() {
		return arquivo;
	}
	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}
	public String[] getPalavrasChaves() {
		return palavrasChaves;
	}
	public void setPalavrasChaves(String[] palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}
	public List<String> getComentarios() {
		return comentarios;
	}
	public void setComentario(String comentario) {
		comentarios.add(comentario);
	}
}
