package com.rwr.dao.contacts;

import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.phone.SeekerPhone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class ContactsDaoImpl implements IContactsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveOrUpdatePhone(Integer seekerId, SeekerPhone phone) {
        if (phone.getId() == null) {
            String sql = "INSERT INTO SEEKER_PHONE (phone_number, seeker_id) VALUES (?, ?)";
            Query insertQuery = entityManager.createNativeQuery(sql);
            insertQuery.setParameter(1, phone.getPhoneNumber());
            insertQuery.setParameter(2, seekerId);
            insertQuery.executeUpdate();
        } else {
            String sql = "UPDATE SEEKER_PHONE SET phone_number=? WHERE id=? AND seeker_id=?";
            Query updateQuery = entityManager.createNativeQuery(sql);
            updateQuery.setParameter(1, phone.getPhoneNumber());
            updateQuery.setParameter(2, phone.getId());
            updateQuery.setParameter(3, seekerId);
            updateQuery.executeUpdate();
        }
    }

    @Override
    public void deletePhone(Integer seekerId, Integer phoneId) {
        Query deleteQuery = entityManager.createNativeQuery("DELETE FROM SEEKER_PHONE WHERE id=? AND seeker_id=?");
        deleteQuery.setParameter(1, phoneId);
        deleteQuery.setParameter(2, seekerId);
        deleteQuery.executeUpdate();
    }

    @Override
    public void saveOrUpdateEmail(Integer seekerId, SeekerEmail email) {
        if (email.getId() == null) {
            String sql = "INSERT INTO SEEKER_EMAIL (email, seeker_id) VALUES (?, ?)";
            Query insertQuery = entityManager.createNativeQuery(sql);
            insertQuery.setParameter(1, email.getEmail());
            insertQuery.setParameter(2, seekerId);
            insertQuery.executeUpdate();
        } else {
            String sql = "UPDATE SEEKER_EMAIL SET email=? WHERE id=? AND seeker_id=?";
            Query updateQuery = entityManager.createNativeQuery(sql);
            updateQuery.setParameter(1, email.getEmail());
            updateQuery.setParameter(2, email.getId());
            updateQuery.setParameter(3, seekerId);
            updateQuery.executeUpdate();
        }
    }

    @Override
    public void deleteEmail(Integer seekerId, Integer emailId) {
        Query deleteQuery = entityManager.createNativeQuery("DELETE FROM SEEKER_EMAIL WHERE id=? AND seeker_id=?");
        deleteQuery.setParameter(1, emailId);
        deleteQuery.setParameter(2, seekerId);
        deleteQuery.executeUpdate();
    }

    //TODO add ims
}
