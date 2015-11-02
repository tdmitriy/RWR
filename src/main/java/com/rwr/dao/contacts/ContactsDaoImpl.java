package com.rwr.dao.contacts;

import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
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

    @Override
    public void saveOrUpdateIms(Integer seekerId, SeekerIms seekerIms) {
        if (seekerIms.getId() == null) {
            String sql = "INSERT INTO SEEKER_IMS (ims_type_id, ims_login, seeker_id) VALUES (?, ?, ?)";
            Query insertQuery = entityManager.createNativeQuery(sql);
            insertQuery.setParameter(1, seekerIms.getImsType().getId());
            insertQuery.setParameter(2, seekerIms.getImsLogin());
            insertQuery.setParameter(3, seekerIms.getImsOwner().getId());
            insertQuery.executeUpdate();
        } else {
            String sql = "UPDATE SEEKER_IMS SET ims_type_id=?, ims_login=? WHERE id=? AND seeker_id=?";
            Query insertQuery = entityManager.createNativeQuery(sql);
            insertQuery.setParameter(1, seekerIms.getImsType().getId());
            insertQuery.setParameter(2, seekerIms.getImsLogin());
            insertQuery.setParameter(3, seekerIms.getId());
            insertQuery.setParameter(4, seekerIms.getImsOwner().getId());
            insertQuery.executeUpdate();
        }
    }

    @Override
    public void deleteIms(Integer seekerId, Integer imsId) {
        Query deleteQuery = entityManager.createNativeQuery("DELETE FROM SEEKER_IMS WHERE id=? AND seeker_id=?");
        deleteQuery.setParameter(1, imsId);
        deleteQuery.setParameter(2, seekerId);
        deleteQuery.executeUpdate();
    }
}
