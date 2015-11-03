package com.rwr.service;

import com.rwr.repository.IImsRepository;
import com.rwr.repository.ISeekerRepository;
import com.rwr.repository.ISkillsRepository;
import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.exception.RwrDaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;

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
    public Collection<SkillType> getAllTypesOfSkills() {
        try {
            return skillsRepository.findAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Collection<ImsType> getAllTypesOfIms() {
        try {
            return imsRepository.findAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Collection<Seeker> getAll() {
        try {
            return seekerRepository.findAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Page<Seeker> getAllPages(Pageable pageable) {
        try {
            return seekerRepository.findAllPages(pageable);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Long getSeekerCount() {
        try {
            return seekerRepository.getSeekerCount();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public Seeker getById(Integer id) {
        try {
            return seekerRepository.findOne(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void saveOrUpdate(Seeker entity) {
        try {
            seekerRepository.save(entity);
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
    public void deleteById(Integer id) {
        try {
            seekerRepository.delete(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }
}
