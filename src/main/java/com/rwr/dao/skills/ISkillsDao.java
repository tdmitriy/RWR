package com.rwr.dao.skills;

import com.rwr.dao.base.IBaseDao;
import com.rwr.entity.skills.SkillType;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public interface ISkillsDao extends IBaseDao<SkillType> {
    SkillType getByName(String skillName);
}
