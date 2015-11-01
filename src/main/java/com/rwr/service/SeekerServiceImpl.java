package com.rwr.service;

import com.rwr.dao.seeker.ISeekerDao;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;
import com.rwr.exception.RwrDaoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Dmitriy on 29.10.2015.
 */
@Service
@Transactional(rollbackFor = RwrDaoException.class)
public class SeekerServiceImpl implements ISeekerService {
    //TODO change business entity to DTO entity

    private ISeekerDao seekerDao;

    public void setSeekerDao(ISeekerDao seekerDao) {
        this.seekerDao = seekerDao;
    }

    @Override
    public Collection<Seeker> getAll() {
        try {
            return seekerDao.getAll();
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public Seeker getById(Integer id) {
        try {
            return seekerDao.getById(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public void saveOrUpdate(Seeker seeker) {
        try {
            seekerDao.saveOrUpdate(seeker);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public void delete(Seeker seeker) {
        try {
            seekerDao.delete(seeker);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            seekerDao.deleteById(id);
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public SeekerContacts getSeekerContacts(Integer seekerId) {
        try {
            //TODO
            return null;
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public void addContacts(Integer seekerId, SeekerContacts contacts) {
        try {
            //TODO
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }

    }

    @Override
    public void addContacts(Seeker owner, SeekerContacts contacts) {
        try {
            //TODO
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public void addPhone(Integer seekerId, SeekerPhone phone) {
        try {
            //TODO
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }

    @Override
    public void addEmail(Integer seekerId, SeekerEmail email) {
        try {
            //TODO
        } catch (Exception ex) {
            throw new RwrDaoException(ex);
        }
    }
}
