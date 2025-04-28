package com.github.gverdum.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> entityClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (Exception e) {
            // logar -> log4j
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> entityClass) {
        this.entityClass = entityClass;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> incluirAtomico(E entity) {
        return this.abrirTransacao().incluir(entity).fecharTransacao();
    }

    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public List<E> obterTodos(int qty, int offset) {
        if(entityClass == null) {
            throw new UnsupportedOperationException("Classe nula");
        }

        String jpql = "select e from " + entityClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, entityClass);
        query.setMaxResults(qty);
        query.setFirstResult(offset);
        return query.getResultList();
    }

    public void fechar() {
        em.close();
    }
}
