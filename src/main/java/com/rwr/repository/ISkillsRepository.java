package com.rwr.repository;

import com.rwr.entity.skills.SkillType;
import com.rwr.repository.base.IBaseRepository;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public interface ISkillsRepository extends IBaseRepository<SkillType> {
    SkillType getSkillByName(String name);
}
