package com.rwr.dao.seeker;

import com.rwr.dao.base.BaseDaoImpl;
import com.rwr.dao.contacts.ContactsDaoImpl;
import com.rwr.dao.contacts.IContactsDao;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Dmitriy on 31.10.2015.
 */

@Repository
public class SeekerDaoImpl extends BaseDaoImpl<Seeker> implements ISeekerDao {
    //TODO add methods to change first, last name, date ...

    private IContactsDao contactsDao;

    public void setContactsDao(IContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }

    @Override
    public void saveOrUpdatePhone(Integer seekerId, SeekerPhone phone) {
        contactsDao.saveOrUpdatePhone(seekerId, phone);
    }

    @Override
    public void deletePhone(Integer seekerId, Integer phoneId) {
        contactsDao.deletePhone(seekerId, phoneId);
    }

    @Override
    public void saveOrUpdateEmail(Integer seekerId, SeekerEmail email) {
        contactsDao.saveOrUpdateEmail(seekerId, email);
    }

    @Override
    public void deleteEmail(Integer seekerId, Integer emailId) {
        contactsDao.deleteEmail(seekerId, emailId);
    }

    @Override
    public void saveOrUpdateIms(Integer seekerId, SeekerIms seekerIms) {
        contactsDao.saveOrUpdateIms(seekerId, seekerIms);
    }

    @Override
    public void deleteIms(Integer seekerId, Integer imsId) {
        contactsDao.deleteIms(seekerId, imsId);
    }
}
