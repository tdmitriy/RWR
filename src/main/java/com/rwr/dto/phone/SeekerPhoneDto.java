package com.rwr.dto.phone;

import com.rwr.dto.seeker.SeekerDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerPhoneDto {
    private String phoneNumber;
    private SeekerDto phoneOwner;

    public SeekerPhoneDto() {
    }

    public SeekerPhoneDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SeekerPhoneDto(String phoneNumber, SeekerDto phoneOwner) {
        this.phoneNumber = phoneNumber;
        this.phoneOwner = phoneOwner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SeekerDto getPhoneOwner() {
        return phoneOwner;
    }

    public void setPhoneOwner(SeekerDto phoneOwner) {
        this.phoneOwner = phoneOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SeekerPhoneDto)) return false;

        SeekerPhoneDto that = (SeekerPhoneDto) o;

        return new EqualsBuilder()
                .append(phoneNumber, that.phoneNumber)
                .append(phoneOwner, that.phoneOwner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(phoneNumber)
                .append(phoneOwner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SeekerPhoneDto{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", phoneOwner=" + phoneOwner +
                '}';
    }
}
