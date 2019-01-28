package com.ifpb.BibliotecaTccs;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Usuario;
import com.ifpb.model.dao.GerenciarTccDao;
import com.ifpb.model.dao.GerenciarUsuarioDao;
import com.ifpb.model.daoImpl.GerenciarTccDaoImpl;
import com.ifpb.model.daoImpl.GerenciarUsuarioDaoImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        GerenciarUsuarioDao usuarioDao = new GerenciarUsuarioDaoImpl();
        usuarioDao.cadastrarUsuario("Maria", "Feminino", "maria@email.com", "maria123", "ADS");

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTccDao tccDao = new GerenciarTccDaoImpl();
        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
            		"Maria", "/home/ian/Documentos/ADS/Metodologia/modelo_tcc.pdf");
        } catch (ArquivoInexistenteException e) {
            e.printStackTrace();
        }
    }
}
