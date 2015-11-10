package com.rwr.entity.contacts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Embeddable
public class SeekerContacts {
    @OneToMany(mappedBy = "phoneOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SeekerPhone> seekerPhones = new HashSet<>(0);

    @OneToMany(mappedBy = "emailOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SeekerEmail> seekerEmails = new HashSet<>(0);

    @OneToMany(mappedBy = "imsOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SeekerIms> seekerIms = new HashSet<>(0);

    @Transient
    @JsonIgnore
    private Seeker contactsOwner;

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

    public void setSeekerIms(Set<SeekerIms> seekerIms) {
        this.seekerIms = seekerIms;
    }

    public Seeker getContactsOwner() {
        return contactsOwner;
    }

    public void setContactsOwner(Seeker contactsOwner) {
        this.contactsOwner = contactsOwner;
        setOwner();
    }

    private void setOwner() {
        for (SeekerPhone phone : seekerPhones) {
            phone.setPhoneOwner(contactsOwner);
        }

        for (SeekerEmail email : seekerEmails) {
            email.setEmailOwner(contactsOwner);
        }

        for (SeekerIms ims : seekerIms) {
            ims.setImsOwner(contactsOwner);
        }
    }
}
