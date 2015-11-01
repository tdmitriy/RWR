package com.rwr.dao.seeker;

import com.rwr.dao.base.BaseDaoImpl;
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
    public SeekerContacts getSeekerContacts(Integer seekerId) {
        return null;
    }

    @Override
    public SeekerContacts getSeekerContacts(Seeker owner) {
        return null;
    }

    @Override
    public void addContacts(Integer seekerId, SeekerContacts contacts) {

    }

    @Override
    public void addContacts(Seeker owner, SeekerContacts contacts) {

    }

    @Override
    public void addPhone(Integer seekerId, SeekerPhone phone) {

    }

    @Override
    public void addEmail(Integer seekerId, SeekerEmail email) {

    }
}
