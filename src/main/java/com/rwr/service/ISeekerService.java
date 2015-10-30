package com.rwr.service;

import com.rwr.entity.seeker.Seeker;

import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */
public interface ISeekerService {
    List<Seeker> getAll();
    Seeker getById(Integer id);
}
