package com.rwr.service;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 * Created by Dmitriy on 02.11.2015.
 */
public interface IRwrManagementService {
    Collection<SkillType> getAllTypesOfSkills();

    Collection<ImsType> getAllTypesOfIms();

    Collection<Seeker> getAll();

    Page<Seeker> getAllPages(Pageable pageable);

    Long getSeekerCount();

    Seeker getById(Integer id);

    void saveOrUpdate(Seeker entity);

    void delete(Seeker entity);

    void deleteById(Integer id);
}
