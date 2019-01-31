package com.ifpb.BibliotecaTccs;

import com.ifpb.exceptions.ArquivoInexistenteException;
import com.ifpb.model.Tcc;
import com.ifpb.model.tcc.GerenciarTcc;
import com.ifpb.model.tcc.GerenciarTccImpl;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GerenciarTccTest {

    //CT - 013
    @Test
    public void testeBuscarPorTitulo(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();
        try {
            tccDao.cadastrarTcc(LocalDate.parse("22/03/2018", form), "Inteligencia artificial", "A Era tecnologica",
                    "Maria", "D:\\Luan/teste.pdf");
            ArrayList<Tcc> list = new ArrayList<>();
            Assert.assertNotNull(tccDao.buscarPorTitulo("Inteligencia artificial"));
        } catch (ArquivoInexistenteException e) {
            e.printStackTrace();
        }
    }
}
