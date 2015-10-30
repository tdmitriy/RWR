package com.rwr.service;

import com.rwr.dao.seeker.ISeekerDao;
import com.rwr.entity.seeker.Seeker;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */
@Service
public class SeekerServiceImpl implements ISeekerService {

    private ISeekerDao seekerDao;

    public void setSeekerDao(ISeekerDao seekerDao) {
        this.seekerDao = seekerDao;
    }

    @Override
    public List<Seeker> getAll() {
        return seekerDao.getAll();
    }

    @Override
    public Seeker getById(Integer id) {
        return seekerDao.getById(id);
    }
}
