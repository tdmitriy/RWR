package com.rwr.entity.contacts;

import com.rwr.entity.email.SeekerEmail;
import com.rwr.entity.ims.SeekerIms;
import com.rwr.entity.phone.SeekerPhone;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
}
