package com.rwr.repository;

import com.rwr.repository.base.IBaseDao;
import com.rwr.entity.skills.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public interface ISkillsRepository extends IBaseDao<SkillType> {
    SkillType getSkillByName(String name);
}
