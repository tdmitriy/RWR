package com.rwr.dto.phone;

import com.rwr.dto.seeker.SeekerDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerPhoneDto {
    private Integer id;
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

    public SeekerPhoneDto(Integer id, String phoneNumber, SeekerDto phoneOwner) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.phoneOwner = phoneOwner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                .append(id, that.id)
                .append(phoneNumber, that.phoneNumber)
                .append(phoneOwner, that.phoneOwner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(phoneNumber)
                .append(phoneOwner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SeekerPhoneDto{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneOwner=" + phoneOwner +
                '}';
    }
}
