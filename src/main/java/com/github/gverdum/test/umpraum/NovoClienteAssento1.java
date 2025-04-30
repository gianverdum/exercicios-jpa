package com.github.gverdum.test.umpraum;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.umpraum.Assento;
import com.github.gverdum.model.umpraum.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {

        Assento assento = new Assento("16A");
        Cliente cliente = new Cliente("Carlos", assento);

        DAO<Object> dao = new DAO<>();

        dao.abrirTransacao()
                .incluir(assento)
                .incluir(cliente)
                .fecharTransacao()
                .fechar();
    }
}
