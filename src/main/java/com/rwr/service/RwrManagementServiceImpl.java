package com.rwr.service;

import com.rwr.dto.ims.ImsTypeDto;
import com.rwr.dto.seeker.SeekerDto;
import com.rwr.dto.skills.SkillTypeDto;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            return new HashSet<>(skillsRepository.findAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Set<ImsType> getAllTypesOfIms() {
        try {
            return new HashSet<>(imsRepository.findAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public List<Seeker> getAll() {
        try {
            return seekerRepository.findAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Page<Seeker> getAllSeekerPageable(Pageable pageable) {
        try {
            return seekerRepository.getSeekerPageable(pageable);
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
