package com.rwr.dao.skills;

import com.rwr.dao.base.IBaseDao;
import com.rwr.entity.skills.SkillsType;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public interface ISkillsDao extends IBaseDao<SkillsType> {
    SkillsType getByName(String skillName);
}