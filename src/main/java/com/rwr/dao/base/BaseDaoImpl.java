package com.rwr.dao.base;

import com.rwr.entity.BaseEntity;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by haswell on 30.10.15.
 */

public abstract class BaseDaoImpl<E extends BaseEntity> implements IBaseDao<E> {

    private final Class<E> clazz;

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.clazz = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public E getById(final Long id) {
        return em.find(this.clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<E> getAll() {
        return em.createQuery("from " + this.clazz.getName()).getResultList();
    }

    @Override
    public void save(final E entity) {
        em.persist(entity);
    }

    @Override
    public void update(final E entity) {
        em.merge(entity);
    }

    //works only on entities which are managed in the current transaction/context
    @Override
    public void delete(final E entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public void deleteById(final Long id) {
        E entity = this.getById(id);
        this.delete(entity);
    }
}