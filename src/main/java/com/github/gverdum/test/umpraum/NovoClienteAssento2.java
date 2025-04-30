package com.github.gverdum.test.umpraum;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.umpraum.Assento;
import com.github.gverdum.model.umpraum.Cliente;

public class NovoClienteAssento2 {

    public static void main(String[] args) {

        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Rodrigo", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);
        dao.incluirAtomico(cliente).fechar();
    }
}
