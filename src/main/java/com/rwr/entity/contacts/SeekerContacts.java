package com.rwr.entity.contacts;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @OneToMany(mappedBy = "imsOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SeekerIms> seekerIms = new HashSet<>(0);

    public SeekerContacts() {
    }

    public SeekerContacts(Set<SeekerPhone> seekerPhones,
                          Set<SeekerEmail> seekerEmails, Set<SeekerIms> seekerIms) {
        this.seekerPhones = seekerPhones;
        this.seekerEmails = seekerEmails;
        this.seekerIms = seekerIms;
    }

    public Set<SeekerPhone> getSeekerPhones() {
        return seekerPhones;
    }

    public void setSeekerPhones(Set<SeekerPhone> seekerPhones) {
        this.seekerPhones = seekerPhones;
    }

    public Set<SeekerEmail> getSeekerEmails() {
        return seekerEmails;
    }

    public void setSeekerEmails(Set<SeekerEmail> seekerEmails) {
        this.seekerEmails = seekerEmails;
    }

    public Set<SeekerIms> getSeekerIms() {
        return seekerIms;
    }

    public void setSeekerImses(Set<SeekerIms> seekerIms) {
        this.seekerIms = seekerIms;

    }

    @Override
    public String toString() {
        return "SeekerContacts{" +
                "seekerPhonesSize=" + seekerPhones.size() +
                ", seekerEmailsSize=" + seekerEmails.size() +
                ", seekerImsSize=" + seekerIms.size() +
                '}';
    }
}
