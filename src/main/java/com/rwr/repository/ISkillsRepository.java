package com.rwr.repository;

import com.rwr.entity.skills.SkillType;
import com.rwr.repository.base.IBaseRepository;

public interface ISkillsRepository extends IBaseRepository<SkillType> {
    SkillType getSkillByName(String name);
}
