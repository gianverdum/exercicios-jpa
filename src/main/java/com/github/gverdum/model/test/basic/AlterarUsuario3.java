package com.github.gverdum.model.test.basic;

import com.github.gverdum.model.basic.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlterarUsuario3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 7L);
        em.detach(usuario);

        usuario.setNome("Leonardo Alterado");

        em.getTransaction().begin();
//        em.merge(usuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
