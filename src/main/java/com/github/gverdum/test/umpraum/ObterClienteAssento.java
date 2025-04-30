package com.github.gverdum.test.umpraum;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.umpraum.Assento;
import com.github.gverdum.model.umpraum.Cliente;

public class ObterClienteAssento {

    public static void main(String[] args) {

        DAO< Cliente> daoCliente = new DAO<>(Cliente.class);
        Cliente cliente = daoCliente.obterPorID(1L);
        System.out.println(cliente.getAssento().getNome());
        daoCliente.fechar();

        DAO<Assento> daoAssento = new DAO<>(Assento.class);
        Assento assento = daoAssento.obterPorID(5L);
        System.out.println(assento.getCliente().getNome());
        daoAssento.fechar();
    }
}
