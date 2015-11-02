package com.rwr.dao.skills;

import com.rwr.dao.base.BaseDaoImpl;
import com.rwr.entity.ims.ImsType;
import com.rwr.entity.skills.SkillsType;

import javax.persistence.Query;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SkillsDaoImpl extends BaseDaoImpl<SkillsType> implements ISkillsDao {
    @SuppressWarnings("JpaQlInspection")
    @Override
    public SkillsType getByName(String skillName) {
        Query selectQuery = getEntityManager().createQuery("SELECT t FROM SkillsType t WHERE t.skillType=:skillName", SkillsType.class);
        selectQuery.setParameter("skillName", skillName);
        return (SkillsType) selectQuery.getSingleResult();
    }
}
