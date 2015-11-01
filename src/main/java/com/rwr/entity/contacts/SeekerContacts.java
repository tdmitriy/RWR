package com.rwr.entity.contacts;

import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by haswell on 30.10.15.
 */

@Embeddable
public class SeekerContacts {

    @Transient
    private static final Logger log = LoggerFactory.getLogger(SeekerContacts.class);

    @OneToMany(mappedBy = "phoneOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SeekerPhone> seekerPhones = new HashSet<>(0);

    @OneToMany(mappedBy = "emailOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SeekerEmail> seekerEmails = new HashSet<>(0);

    //TODO add ims
    //private Set<SeekerIms> imss = new HashSet<>(0);

    @Transient
    private Seeker contactsOwner;

    public SeekerContacts() {
    }

    public SeekerContacts(Seeker contactsOwner) {
        this.contactsOwner = contactsOwner;
    }

    public SeekerContacts(Set<SeekerPhone> seekerPhones, Set<SeekerEmail> seekerEmails, Seeker contactsOwner) {
        this.seekerPhones = seekerPhones;
        this.seekerEmails = seekerEmails;
        this.contactsOwner = contactsOwner;
    }

    public Set<SeekerPhone> getSeekerPhones() {
        return seekerPhones;
    }

    public void setSeekerPhones(Set<SeekerPhone> seekerPhones, Seeker contactsOwner) {
        this.contactsOwner = contactsOwner;
        this.seekerPhones = seekerPhones;
        setContactOwnerToPhones();
    }

    public Set<SeekerEmail> getSeekerEmails() {
        return seekerEmails;
    }

    public void setSeekerEmails(Set<SeekerEmail> seekerEmails, Seeker contactsOwner) {
        this.contactsOwner = contactsOwner;
        this.seekerEmails = seekerEmails;
        setContactsOwnerToEmails();
    }

    public Seeker getContactsOwner() {
        return contactsOwner;
    }

    public void setContactsOwner(Seeker contactsOwner) {
        this.contactsOwner = contactsOwner;
        setContactOwnerToPhones();
        setContactsOwnerToEmails();
        //TODO add ims
    }

    private void setContactOwnerToPhones() {
        for (SeekerPhone phone : seekerPhones) {
            phone.setPhoneOwner(contactsOwner);
        }
    }

    private void setContactsOwnerToEmails() {
        for (SeekerEmail email : seekerEmails) {
            email.setEmailOwner(contactsOwner);
        }
    }
}
