package com.ifpb.BibliotecaTccs;

import com.ifpb.model.usuario.GerenciarUsuario;
import com.ifpb.model.usuario.GerenciarUsuarioImpl;
import org.junit.Assert;
import org.junit.Test;

public class GerenciarUsuarioTest {

    //CT - 004
    @Test
    public void testeCadastrarUsuarioCorreto(){
        GerenciarUsuario dao = new GerenciarUsuarioImpl();
        Assert.assertTrue(dao.cadastrarUsuario("Maria", "F", "maria@email.com", "12345678", "ads"));
    }
    //CT - 005
    @Test
    public void testeCadastrarUsuarioSenha(){
        GerenciarUsuario dao = new GerenciarUsuarioImpl();
        Assert.assertFalse(dao.cadastrarUsuario("Jose", "M", "jose@email.com", "1234567", "ads"));
    }
    //CT - 006
    @Test
    public  void testeExcluirUsuario(){
        GerenciarUsuario dao = new GerenciarUsuarioImpl();
        dao.cadastrarUsuario("Jose", "M", "jose@email.com", "12345678", "ads");
        Assert.assertTrue(dao.excluirUsuario("jose@email.com"));
    }
}
