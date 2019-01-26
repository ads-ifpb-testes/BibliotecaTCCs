package com.ifpb.exceptions;

public class ArquivoInexistenteException extends Exception{
	public ArquivoInexistenteException() {
		super("Arquivo não existe neste caminho!");
	}
}
