package br.com.jkavdev.groups.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public abstract class RootRepository {

    @PersistenceContext
    EntityManager manager;

    protected CriteriaBuilder cb() {
        return manager.getCriteriaBuilder();
    }

    protected EntityManager manager() {
        return manager;
    }
}
