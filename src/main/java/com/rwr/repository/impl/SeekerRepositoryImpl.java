package com.rwr.repository.impl;

import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SeekerSkill;
import com.rwr.entity.skills.SkillType;
import com.rwr.repository.ISeekerRepository;
import com.rwr.repository.ISkillsRepository;
import com.rwr.repository.base.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitriy on 04.11.2015.
 */
@Repository
public class SeekerRepositoryImpl extends BaseDaoImpl<Seeker> implements ISeekerRepository {

    @Autowired
    private ISkillsRepository skillsRepository;

    @Override
    public Collection<Seeker> getSeekerPageable(Integer pageNumber, Integer maxPageSize) {
        return null;
    }

    @Override
    public void saveOrUpdate(Seeker entity) {
        for (SeekerSkill skill : entity.getSeekerSkills()) {
            skill.setSkillsOwner(entity);
        }
        super.saveOrUpdate(entity);
    }
}
