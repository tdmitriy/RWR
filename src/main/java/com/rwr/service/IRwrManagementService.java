package com.rwr.service;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;

import java.util.List;
import java.util.Set;

public interface IRwrManagementService {
    Set<SkillType> getSkillTypes();

    Set<ImsType> getImsTypes();

    List<Seeker> getSeekers();

    IPageWrapper<Seeker> getSeekerPageable(Pageable pageable);

    Seeker getSeekerById(Integer id);

    void saveOrUpdateSeeker(Seeker entity);

    void delete(Seeker entity);

    void delete(Integer id);

    Long getSeekerRowCount();
}
