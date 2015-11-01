package com.rwr.dao.seeker;


import com.rwr.dao.base.IBaseDao;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;

import java.util.Set;

/**
 * Created by Dmitriy on 29.10.2015.
 */
public interface ISeekerDao extends IBaseDao<Seeker> {
    SeekerContacts getSeekerContacts(Integer seekerId);

    SeekerContacts getSeekerContacts(Seeker owner);

    void addContacts(Integer seekerId, SeekerContacts contacts);

    void addContacts(Seeker owner, SeekerContacts contacts);

    void addPhone(Integer seekerId, SeekerPhone phone);

    void addEmail(Integer seekerId, SeekerEmail email);
}
