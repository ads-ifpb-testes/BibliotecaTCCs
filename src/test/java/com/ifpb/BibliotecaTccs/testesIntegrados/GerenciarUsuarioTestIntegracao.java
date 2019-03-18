package com.ifpb.BibliotecaTccs.testesIntegrados;

import com.ifpb.model.usuario.GerenciarUsuario;
import com.ifpb.model.usuario.GerenciarUsuarioImpl;
import org.junit.Assert;
import org.junit.Test;

public class GerenciarUsuarioTestIntegracao {

    @Test
    public  void testeExcluirUsuario(){
        GerenciarUsuario dao = new GerenciarUsuarioImpl();
        dao.cadastrarUsuario("Jose", "M", "jose@email.com", "12345678", "ads");
        Assert.assertTrue(dao.excluirUsuario("jose@email.com"));
    }
}
