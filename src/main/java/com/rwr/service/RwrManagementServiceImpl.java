package com.rwr.service;

import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.exception.RwrDaoException;
import com.rwr.exception.RwrResourceNotFoundException;
import com.rwr.repository.IImsRepository;
import com.rwr.repository.ISeekerRepository;
import com.rwr.repository.ISkillsRepository;
import com.rwr.utils.IPageWrapper;
import com.rwr.utils.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RwrManagementServiceImpl implements IRwrManagementService {
    @Autowired
    private IImsRepository imsRepository;

    @Autowired
    private ISkillsRepository skillsRepository;

    @Autowired
    private ISeekerRepository seekerRepository;

    @Override
    public Set<SkillType> getSkillTypes() {
        try {
            return new HashSet<>(skillsRepository.getAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public Set<ImsType> getImsTypes() {
        try {
            return new HashSet<>(imsRepository.getAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public List<Seeker> getSeekers() {
        try {
            return new ArrayList<>(seekerRepository.getAll());
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public IPageWrapper<Seeker> getSeekerPageable(Pageable pageable) {
        try {
            return seekerRepository.getSeekerPageable(pageable);
        } catch (Exception ex) {
            if (ex instanceof RwrResourceNotFoundException) {
                throw (RwrResourceNotFoundException) ex;
            } else {
                throw new RwrDaoException(ex);
            }
        }
    }

    @Override
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
    public Long getSeekerRowCount() {
        try {
            return seekerRepository.getSeekerRowCount();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }
}
