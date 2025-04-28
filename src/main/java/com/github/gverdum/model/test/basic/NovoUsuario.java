package com.github.gverdum.model.test.basic;

import com.github.gverdum.model.basic.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NovoUsuario {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario = new Usuario("Djalma", "djalma@lanche.com.br");

        em.getTransaction().begin();
        em.persist(novoUsuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
