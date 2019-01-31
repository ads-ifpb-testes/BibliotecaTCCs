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

    /**
     * Caso de teste nº008
     *
     * Este caso de teste tem por finalidade excluir um TCC com base nos parâmetros de cadastro.
     *
     * @param titulo corresponde ao título do TCC cadastrado.
     * @param autor corresponde ao autor do TCC cadastrado.
     *
     */
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

    /**
     * Casso de teste nº009
     *
     * Este caso de teste tem por finalidade efetuar o cadastro corretamente de um tCC com.
     *
     * @param DataTcc corresponde a data que sumissão do TCC.
     * @param Titulo corresponde ao título do TCC a ser cadastrado.
     * @param Tema corresponde ao tema do Tcc a ser cadastrado.
     * @param Autor corresponde ao nome do autor que deseja cadastrar seu TCC.
     * @param PathTcc corresponde ao caminho onde o arquivo se encontra na máquina.
     *
     */
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

    //CT - 013
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

    //CT - 014
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

    //CT - 015
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
