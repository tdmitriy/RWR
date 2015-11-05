package com.rwr.repository.base;

import com.rwr.entity.BaseEntity;

import java.util.Collection;

/**
 * Created by haswell on 30.10.15.
 */

public interface IBaseRepository<E extends BaseEntity> {
    E getById(Integer id);

    Collection<E> getAll();

    void saveOrUpdate(E entity);

    void delete(E entity);

    void delete(Integer id);
}