package com.ifpb.BibliotecaTccs;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Usuario;
import com.ifpb.model.tcc.GerenciarTcc;
import com.ifpb.model.tcc.GerenciarTccImpl;
import com.ifpb.model.usuario.GerenciarUsuario;
import com.ifpb.model.usuario.GerenciarUsuarioImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        GerenciarUsuario usuarioDao = new GerenciarUsuarioImpl();
        usuarioDao.cadastrarUsuario("Maria", "Feminino", "maria@email.com", "maria123", "ADS");

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();
        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
            		"Maria", "/home/ian/Documentos/ADS/Metodologia/modelo_tcc.pdf");
        } catch (ArquivoInexistenteException e) {
            e.printStackTrace();
        }
    }
}
