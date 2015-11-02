package com.rwr.dao.skills;

import com.rwr.dao.base.BaseDaoImpl;
import com.rwr.entity.skills.SkillType;

import javax.persistence.Query;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SkillsDaoImpl extends BaseDaoImpl<SkillType> implements ISkillsDao {
    @SuppressWarnings("JpaQlInspection")
    @Override
    public SkillType getByName(String skillName) {
        Query selectQuery = getEntityManager()
                .createQuery("SELECT t FROM SkillsType t WHERE t.skillType=:skillName", SkillType.class);
        selectQuery.setParameter("skillName", skillName);
        return (SkillType) selectQuery.getSingleResult();
    }
}
