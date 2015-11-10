package com.rwr.repository.base;

import com.rwr.entity.BaseEntity;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by haswell on 30.10.15.
 */

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements IBaseRepository<E> {

    private final Class<E> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public BaseRepositoryImpl() {
        this.clazz = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseRepositoryImpl.class);
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
    public void saveOrUpdate(final E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(final E entity) {
        entityManager.remove(entity);
    }

    @Override
    public void delete(final Integer id) {
        E entity = entityManager.find(this.clazz, id);
        if (entity != null)
            this.delete(entity);
        else throw new NullPointerException("Deletion entity is null");
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}