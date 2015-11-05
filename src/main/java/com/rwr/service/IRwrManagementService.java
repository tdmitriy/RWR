package com.rwr.service;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.PageWrapperImpl;
import com.rwr.utils.Pageable;
import java.util.List;
import java.util.Set;

/**
 * Created by Dmitriy on 02.11.2015.
 */
public interface IRwrManagementService {
    Set<SkillType> getAllTypesOfSkills();

    Set<ImsType> getAllTypesOfIms();

    List<Seeker> getAllSeekers();

    IPageWrapper<Seeker> getAllSeekerPageable(Pageable pageable);

    Seeker getSeekerById(Integer id);

    void saveOrUpdateSeeker(Seeker entity);

    void delete(Seeker entity);

    void delete(Integer id);

    Integer getSeekerRowCount();
}
