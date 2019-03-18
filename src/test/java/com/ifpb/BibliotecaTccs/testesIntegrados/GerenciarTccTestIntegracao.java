package com.ifpb.BibliotecaTccs.testesIntegrados;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Tcc;
import com.ifpb.model.tcc.GerenciarTcc;
import com.ifpb.model.tcc.GerenciarTccImpl;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GerenciarTccTestIntegracao {

    //Teste de integração
    @Test
    public void testeExcluirTcc() {
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();

        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
                    "Maria", "/home/diones/Downloads/modelo_TCC.pdf");
            Assert.assertTrue(tccDao.excluirTcc("Inteligencia artificial", "Maria"));

            System.out.println("Exclussão realizada!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testeBuscarPorTitulo(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();
        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
                    "Maria", "D:\\Luan/teste.pdf");
            Assert.assertNotNull(tccDao.buscarPorTitulo("Inteligencia artificial"));
        } catch (ArquivoInexistenteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testeBuscarPorTituloNaoCadastrado(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();
        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
                    "Maria", "D:\\Luan/teste.pdf");
            ArrayList<Tcc> list = new ArrayList<>();
            Assert.assertEquals(list, tccDao.buscarPorTitulo("Java"));
        } catch (ArquivoInexistenteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testeBuscarPorTituloBranco(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();
        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
                    "Maria", "D:\\Luan/teste.pdf");
            ArrayList<Tcc> list = new ArrayList<>();
            Assert.assertEquals(list, tccDao.buscarPorTitulo(" "));
        } catch (ArquivoInexistenteException e) {
            e.printStackTrace();
        }
    }

}
