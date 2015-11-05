package com.rwr.service;

import com.rwr.repository.IImsRepository;
import com.rwr.repository.ISeekerRepository;
import com.rwr.repository.ISkillsRepository;
import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.exception.RwrDaoException;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Dmitriy on 02.11.2015.
 */

@Service
public class RwrManagementServiceImpl implements IRwrManagementService {
    @Autowired
    private IImsRepository imsRepository;

    @Autowired
    private ISkillsRepository skillsRepository;

    @Autowired
    private ISeekerRepository seekerRepository;

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Set<SkillType> getAllTypesOfSkills() {
        try {
            return new HashSet<>(skillsRepository.getAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Set<ImsType> getAllTypesOfIms() {
        try {
            return new HashSet<>(imsRepository.getAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public List<Seeker> getAllSeekers() {
        try {
            return new ArrayList<>(seekerRepository.getAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }


    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public IPageWrapper<Seeker> getAllSeekerPageable(Pageable pageable) {
        try {
            return seekerRepository.getSeekerPageable(pageable);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public Seeker getSeekerById(Integer id) {
        try {
            return seekerRepository.getById(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void saveOrUpdateSeeker(Seeker entity) {
        try {
            seekerRepository.saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void delete(Seeker entity) {
        try {
            seekerRepository.delete(entity);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void delete(Integer id) {
        try {
            seekerRepository.delete(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public Integer getSeekerRowCount() {
        try {
            return seekerRepository.getSeekerRowCount();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }
}
