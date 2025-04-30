package com.github.gverdum.test.consulta;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.consulta.NotaFilme;
import com.github.gverdum.model.muitospramuitos.Filme;

public class ObterMediaFilmes {

    public static void main(String[] args) {

        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme nota = dao.consultarUm("mediaGeral");

        System.out.println(nota.getMedia());

        dao.fechar();
    }
}
