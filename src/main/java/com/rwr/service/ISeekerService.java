package com.rwr.service;

import com.rwr.entity.seeker.Seeker;

import java.util.Collection;
import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */
public interface ISeekerService {
    Collection<Seeker> getAll();
    Seeker getById(Integer id);
    void save(Seeker seeker);
}
