package com.github.gverdum.test.heranca;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.heranca.Aluno;
import com.github.gverdum.model.heranca.AlunoBolsista;

public class NovoAluno {

    public static void main(String[] args) {

        DAO< Aluno> alunoDAO = new DAO<>(Aluno.class);

        Aluno aluno1 = new Aluno(123L, "João");
        AlunoBolsista aluno2 = new AlunoBolsista(345L, "Maria", 1000);

        alunoDAO.incluirAtomico(aluno1);
        alunoDAO.incluirAtomico(aluno2);
        alunoDAO.fechar();
    }
}
