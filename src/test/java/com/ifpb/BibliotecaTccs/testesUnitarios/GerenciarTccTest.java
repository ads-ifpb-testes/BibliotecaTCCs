package com.ifpb.BibliotecaTccs.testesUnitarios;

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

    @Test
    public void testeCadastroTcc(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GerenciarTcc tccDao = new GerenciarTccImpl();

        try {
            Assert.assertTrue(tccDao.cadastrarTcc(LocalDate.parse("31/01/2019", form), "Inteligencia artificial", "A Era tecnologica",
                    "Maria", "/home/diones/Downloads/modelo_TCC.pdf"));
            System.out.println("Upload completo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //CT - 015


}
