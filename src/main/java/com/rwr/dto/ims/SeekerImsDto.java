package com.rwr.dto.ims;

import com.rwr.dto.seeker.SeekerDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerImsDto {
    private Integer id;
    private String imsLogin;
    private ImsTypeDto imsType;
    private SeekerDto imsOwner;

    public SeekerImsDto() {
    }

    public SeekerImsDto(String imsLogin, ImsTypeDto imsType, SeekerDto imsOwner) {
        this.imsLogin = imsLogin;
        this.imsType = imsType;
        this.imsOwner = imsOwner;
    }

    public SeekerImsDto(Integer id, String imsLogin, ImsTypeDto imsType, SeekerDto imsOwner) {
        this.id = id;
        this.imsLogin = imsLogin;
        this.imsType = imsType;
        this.imsOwner = imsOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SeekerImsDto)) return false;

        SeekerImsDto that = (SeekerImsDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(imsLogin, that.imsLogin)
                .append(imsType, that.imsType)
                .append(imsOwner, that.imsOwner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(imsLogin)
                .append(imsType)
                .append(imsOwner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SeekerImsDto{" +
                "id=" + id +
                ", imsLogin='" + imsLogin + '\'' +
                ", imsType=" + imsType +
                ", imsOwner=" + imsOwner +
                '}';
    }
}
