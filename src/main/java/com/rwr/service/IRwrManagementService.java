package com.rwr.service;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * Created by Dmitriy on 02.11.2015.
 */
public interface IRwrManagementService {
    Set<SkillType> getAllTypesOfSkills();

    Set<ImsType> getAllTypesOfIms();

    List<Seeker> getAll();

    Page<Seeker> getAllSeekerPageable(Pageable pageable);

    Seeker getById(Integer id);

    void saveOrUpdate(Seeker entity);

    void delete(Seeker entity);

    void deleteById(Integer id);
}
