package com.rwr.service;

import com.rwr.dao.ims.IImsDao;
import com.rwr.dao.seeker.ISeekerDao;
import com.rwr.dao.skills.ISkillsDao;
import com.rwr.entity.ims.ImsType;
import com.rwr.entity.seeker.Seeker;
import com.rwr.entity.skills.SkillType;
import com.rwr.exception.RwrDaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Dmitriy on 02.11.2015.
 */

@Service
public class RwrManagementServiceImpl implements IRwrManagementService {

    @Autowired
    private IImsDao imsDao;

    @Autowired
    private ISkillsDao skillsDao;

    @Autowired
    private ISeekerDao seekerDao;


    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Collection<SkillType> getAllTypesOfSkills() {

        try {
            return skillsDao.getAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Collection<ImsType> getAllTypesOfIms() {
        try {
            return imsDao.getAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RwrDaoException.class)
    public Collection<Seeker> getAll() {
        try {
            return seekerDao.getAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public Seeker getById(Integer id) {
        try {
            return seekerDao.getById(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void saveOrUpdate(Seeker entity) {
        try {
            seekerDao.saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void delete(Seeker entity) {
        try {
            seekerDao.delete(entity);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    @Transactional(rollbackFor = RwrDaoException.class)
    public void deleteById(Integer id) {
        try {
            seekerDao.deleteById(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }
}
