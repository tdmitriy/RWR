package com.rwr.service;

import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;

import java.util.Collection;
import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */
public interface ISeekerService {
    Collection<Seeker> getAll();

    Seeker getById(Integer id);

    void saveOrUpdate(Seeker seeker);

    void delete(Seeker seeker);

    void deleteById(Integer id);

    SeekerContacts getSeekerContacts(Integer seekerId);

    void addContacts(Integer seekerId, SeekerContacts contacts);

    void addContacts(Seeker owner, SeekerContacts contacts);

    void addPhone(Integer seekerId, SeekerPhone phone);

    void addEmail(Integer seekerId, SeekerEmail email);
}
