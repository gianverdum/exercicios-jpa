package com.github.gverdum.test.basic;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.basic.Produto;

public class NovoProduto {

    public static void main(String[] args) {

        DAO<Produto> dao = new DAO<>(Produto.class);

        Produto produto = new Produto("Monitor 23", 789.98);

        dao.incluirAtomico(produto).fechar();
    }
}
