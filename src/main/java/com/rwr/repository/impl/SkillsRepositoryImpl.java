package com.rwr.repository.impl;

import com.rwr.entity.skills.SkillType;
import com.rwr.repository.ISkillsRepository;
import com.rwr.repository.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Dmitriy on 04.11.2015.
 */
@Repository
public class SkillsRepositoryImpl extends BaseDaoImpl<SkillType> implements ISkillsRepository {
    @SuppressWarnings("JpaQlInspection")
    @Override
    public SkillType getSkillByName(String name) {
        Query query = getEntityManager().createQuery("SELECT s FROM SkillType s WHERE s.skillName=:name", SkillType.class);
        query.setParameter("name", name);
        return (SkillType) query.getSingleResult();
    }
}
