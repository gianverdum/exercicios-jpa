package com.github.gverdum.test.umpramuitos;

import com.github.gverdum.infra.DAO;
import com.github.gverdum.model.basic.Produto;
import com.github.gverdum.model.umpramuitos.ItemPedido;
import com.github.gverdum.model.umpramuitos.Pedido;
import com.github.gverdum.model.umpraum.Cliente;

public class NovoPedido {

    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>();

        Pedido pedido = new Pedido();
        Produto produto = new Produto("Geladeira", 2789.99);
        ItemPedido item = new ItemPedido(pedido, produto, 10);

        dao.abrirTransacao()
                .incluir(produto)
                .incluir(pedido)
                .incluir(item)
                .fecharTransacao()
                .fechar();
    }
}
