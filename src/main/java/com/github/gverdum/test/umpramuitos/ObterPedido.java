package com.github.gverdum.test.umpramuitos;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.umpramuitos.ItemPedido;
import com.github.gverdum.model.umpramuitos.Pedido;

public class ObterPedido {

    public static void main(String[] args) {

        DAO<Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterPorID(1L);

        for(ItemPedido item : pedido.getItens()) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome());
        }

        dao.fechar();
    }
}
