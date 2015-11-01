package com.rwr.service;

import com.rwr.dao.seeker.ISeekerDao;
import com.rwr.entity.seeker.Seeker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */
@Service
@Transactional
public class SeekerServiceImpl implements ISeekerService {

    private ISeekerDao seekerDao;

    public void setSeekerDao(ISeekerDao seekerDao) {
        this.seekerDao = seekerDao;
    }

    @Override
    public Collection<Seeker> getAll() {
        return seekerDao.getAll();
    }

    @Override
    public Seeker getById(Integer id) {
        return seekerDao.getById(id);
    }

    @Override
    public void save(Seeker seeker) {
        seekerDao.save(seeker);
    }


}
