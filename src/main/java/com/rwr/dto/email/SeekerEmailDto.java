package com.rwr.dto.email;

import com.rwr.dto.seeker.SeekerDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerEmailDto {
    private String email;
    private SeekerDto emailOwner;

    public SeekerEmailDto() {
    }

    public SeekerEmailDto(String email, SeekerDto emailOwner) {
        this.email = email;
        this.emailOwner = emailOwner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SeekerDto getEmailOwner() {
        return emailOwner;
    }

    public void setEmailOwner(SeekerDto emailOwner) {
        this.emailOwner = emailOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SeekerEmailDto)) return false;

        SeekerEmailDto that = (SeekerEmailDto) o;

        return new EqualsBuilder()
                .append(email, that.email)
                .append(emailOwner, that.emailOwner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(email)
                .append(emailOwner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SeekerEmailDto{" +
                "email='" + email + '\'' +
                ", emailOwner=" + emailOwner +
                '}';
    }
}
