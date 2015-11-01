package com.rwr.entity.contacts;

import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;
import com.rwr.entity.seeker.Seeker;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by haswell on 30.10.15.
 */

@Embeddable
public class SeekerContacts {

    @OneToMany(mappedBy = "phoneOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SeekerPhone> seekerPhones = new HashSet<>(0);

    @OneToMany(mappedBy = "emailOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SeekerEmail> seekerEmails = new HashSet<>(0);
    //private Set<SeekerIms> imss = new HashSet<>(0);

    @Transient
    private Seeker contactsOwner;

    public SeekerContacts() {
    }

    public SeekerContacts(Set<SeekerPhone> seekerPhones, Set<SeekerEmail> seekerEmails, Seeker contactsOwner) {
        this.seekerPhones = seekerPhones;
        this.seekerEmails = seekerEmails;
        this.contactsOwner = contactsOwner;
    }

    public Set<SeekerPhone> getSeekerPhones() {
        return seekerPhones;
    }

    public void setSeekerPhones(Set<SeekerPhone> seekerPhones) {
        this.seekerPhones = seekerPhones;
        setContactOwnerToPhones();
    }

    public Set<SeekerEmail> getSeekerEmails() {
        return seekerEmails;
    }

    public void setSeekerEmails(Set<SeekerEmail> seekerEmails) {
        this.seekerEmails = seekerEmails;
        setContactsOwnerToEmails();
    }

    /*public Set<SeekerIms> getImss() {
        return imss;
    }

    public void setImss(Set<SeekerIms> imss) {
        this.imss = imss;
    }*/

    public Seeker getContactsOwner() {
        return contactsOwner;
    }

    public void setContactsOwner(Seeker contactsOwner) {
        this.contactsOwner = contactsOwner;
        setContactOwnerToPhones();
        setContactsOwnerToEmails();
    }

    private void setContactOwnerToPhones() {
        if (this.contactsOwner != null) {
            for (SeekerPhone phone : seekerPhones) {
                phone.setPhoneOwner(contactsOwner);
            }
        }
    }

    private void setContactsOwnerToEmails() {
        if (this.contactsOwner != null) {
            for (SeekerEmail email : seekerEmails) {
                email.setEmailOwner(contactsOwner);
            }
        }
    }

    public void addNewPhone(SeekerPhone phone) {
        if (this.contactsOwner != null) {
            seekerPhones.add(phone);
            phone.setPhoneOwner(contactsOwner);
        }
    }

    public void addNewEmail(SeekerEmail email) {
        if (this.contactsOwner != null) {
            seekerEmails.add(email);
            email.setEmailOwner(contactsOwner);
        }
    }
}
