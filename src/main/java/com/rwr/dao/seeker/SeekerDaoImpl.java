package com.rwr.dao.seeker;

import com.rwr.dao.base.BaseDaoImpl;
import com.rwr.dao.contacts.ContactsDaoImpl;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Dmitriy on 31.10.2015.
 */

@Repository
public class SeekerDaoImpl extends BaseDaoImpl<Seeker> implements ISeekerDao {

    @Override
    public void saveOrUpdatePhone(Integer seekerId, SeekerPhone phone) {

    }

    @Override
    public void deletePhone(Integer seekerId, Integer phoneId) {

    }

    @Override
    public void saveOrUpdateEmail(Integer seekerId, SeekerEmail email) {

    }

    @Override
    public void deleteEmail(Integer seekerId, Integer emailId) {

    }
}
