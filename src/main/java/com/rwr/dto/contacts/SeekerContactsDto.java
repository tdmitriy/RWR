package com.rwr.dto.contacts;

import com.rwr.dto.email.SeekerEmailDto;
import com.rwr.dto.ims.SeekerImsDto;
import com.rwr.dto.phone.SeekerPhoneDto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerContactsDto {
    private Set<SeekerPhoneDto> seekerPhones = new HashSet<>(0);
    private Set<SeekerEmailDto> seekerEmails = new HashSet<>(0);
    private Set<SeekerImsDto> seekerIms = new HashSet<>(0);

    public SeekerContactsDto() {
    }

    public SeekerContactsDto(Set<SeekerPhoneDto> seekerPhones, Set<SeekerEmailDto> seekerEmails,
                             Set<SeekerImsDto> seekerIms) {
        this.seekerPhones = seekerPhones;
        this.seekerEmails = seekerEmails;
        this.seekerIms = seekerIms;
    }

    public Set<SeekerPhoneDto> getSeekerPhones() {
        return seekerPhones;
    }

    public void setSeekerPhones(Set<SeekerPhoneDto> seekerPhones) {
        this.seekerPhones = seekerPhones;
    }

    public Set<SeekerEmailDto> getSeekerEmails() {
        return seekerEmails;
    }

    public void setSeekerEmails(Set<SeekerEmailDto> seekerEmails) {
        this.seekerEmails = seekerEmails;
    }

    public Set<SeekerImsDto> getSeekerIms() {
        return seekerIms;
    }

    public void setSeekerIms(Set<SeekerImsDto> seekerIms) {
        this.seekerIms = seekerIms;
    }
}
