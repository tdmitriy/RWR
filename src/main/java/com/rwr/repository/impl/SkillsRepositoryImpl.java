package com.rwr.repository.impl;

import com.rwr.entity.skills.SkillType;
import com.rwr.repository.ISkillsRepository;
import com.rwr.repository.base.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class SkillsRepositoryImpl extends BaseRepositoryImpl<SkillType> implements ISkillsRepository {
    @SuppressWarnings("JpaQlInspection")
    @Override
    public SkillType getSkillByName(String name) {
        Query query = getEntityManager().createQuery("SELECT s FROM SkillType s WHERE s.skillName=:name", SkillType.class);
        query.setParameter("name", name);
        return (SkillType) query.getSingleResult();
    }
}
