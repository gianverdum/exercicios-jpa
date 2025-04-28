package com.github.gverdum.test.basic;

import com.github.gverdum.infra.ProdutoDAO;
import com.github.gverdum.model.basic.Produto;

import java.util.List;

public class ObterProdutos {

    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos();

        for( Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome());
        }

        double precoTotal = produtos
                .stream()
                .map(p -> p.getPreco())
                .reduce(0.0, (t,p) -> t + p)
                .doubleValue();
        System.out.println("O valor total é R$ " + precoTotal);
    }
}
