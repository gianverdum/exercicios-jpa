package com.github.gverdum.test.consulta;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.muitospramuitos.Ator;
import com.github.gverdum.model.muitospramuitos.Filme;

import java.util.List;

public class ObterFilmes {

    public static void main(String[] args) {

        DAO< Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consultar("filmesNotaMaiorQue", "nota", 8.5);

        System.out.println(filmes.size());
        for(Filme filme : filmes) {
            System.out.println(filme.getNome() + "=>" + filme.getNota());

            for(Ator ator : filme.getAtores()) {
                System.out.println("  " + ator.getNome());
            }
        }
    }
}
