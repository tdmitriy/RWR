package com.rwr.dao.contacts;

import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;

/**
 * Created by haswell on 30.10.15.
 */
public interface IContactsDao {
    void saveOrUpdatePhone(Integer seekerId, SeekerPhone phone);

    void deletePhone(Integer seekerId, Integer phoneId);

    void saveOrUpdateEmail(Integer seekerId, SeekerEmail email);

    void deleteEmail(Integer seekerId, Integer emailId);

    void saveOrUpdateIms(Integer seekerId, SeekerIms seekerIms);

    void deleteIms(Integer seekerId, Integer imsId);

}
