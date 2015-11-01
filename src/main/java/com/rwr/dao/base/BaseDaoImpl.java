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
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.clazz = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public E getById(final Integer id) {
        return entityManager.find(this.clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<E> getAll() {
        return entityManager.createQuery("from " + this.clazz.getName()).getResultList();
    }

    @Override
    public void save(final E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final E entity) {
        entityManager.merge(entity);
    }

    //works only on entities which are managed in the current transaction/context
    @Override
    public void delete(final E entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void deleteById(final Integer id) {
        E entity = this.getById(id);
        this.delete(entity);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}