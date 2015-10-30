package com.rwr.entity.contacts;

import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;

import java.util.Set;

/**
 * Created by haswell on 30.10.15.
 */
public class Contacts {

    private Set<SeekerPhone> seekerPhones;
    private Set<SeekerEmail> seekerEmails;
    private Set<SeekerIms> imss;

    public Contacts() {
    }

    public Contacts(Set<SeekerPhone> seekerPhones, Set<SeekerEmail> seekerEmails, Set<SeekerIms> imss) {
        this.seekerPhones = seekerPhones;
        this.seekerEmails = seekerEmails;
        this.imss = imss;
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

    public Set<SeekerIms> getImss() {
        return imss;
    }

    public void setImss(Set<SeekerIms> imss) {
        this.imss = imss;
    }
}
