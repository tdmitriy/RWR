package com.rwr.service;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;

import java.util.Collection;

/**
 * Created by Dmitriy on 02.11.2015.
 */
public interface IRwrManagementService {
    Collection<SkillType> getAllTypesOfSkills();

    Collection<ImsType> getAllTypesOfIms();

    Collection<Seeker> getAll();

    Seeker getById(Integer id);

    void saveOrUpdate(Seeker entity);

    void delete(Seeker entity);

    void deleteById(Integer id);
}
