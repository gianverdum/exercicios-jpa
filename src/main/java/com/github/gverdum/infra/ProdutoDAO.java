package com.github.gverdum.infra;

import com.github.gverdum.model.basic.Produto;

public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class);
    }
}
