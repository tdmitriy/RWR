package com.rwr.dao.base;

import com.rwr.entity.BaseEntity;

import java.util.Collection;

/**
 * Created by haswell on 30.10.15.
 */

public interface IBaseDao<E extends BaseEntity> {
    E getById(Integer id);

    Collection<E> getAll();

    void save(E entity);

    void update(E entity);

    void delete(E entity);

    void deleteById(Integer id);
}