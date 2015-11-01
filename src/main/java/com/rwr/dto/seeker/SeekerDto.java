package com.rwr.dto.seeker;

import com.rwr.dto.contacts.SeekerContactsDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfAddition;
    private Date dateOfInterview;
    private SeekerContactsDto seekerContacts;

    public SeekerDto() {
    }

    public SeekerDto(Integer id, String firstName, String lastName, Date dateOfAddition, Date dateOfInterview,
                     SeekerContactsDto seekerContacts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfAddition = dateOfAddition;
        this.dateOfInterview = dateOfInterview;
        this.seekerContacts = seekerContacts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfAddition() {
        return dateOfAddition;
    }

    public void setDateOfAddition(Date dateOfAddition) {
        this.dateOfAddition = dateOfAddition;
    }

    public Date getDateOfInterview() {
        return dateOfInterview;
    }

    public void setDateOfInterview(Date dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public SeekerContactsDto getSeekerContacts() {
        return seekerContacts;
    }

    public void setSeekerContacts(SeekerContactsDto seekerContacts) {
        this.seekerContacts = seekerContacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SeekerDto)) return false;

        SeekerDto seekerDto = (SeekerDto) o;

        return new EqualsBuilder()
                .append(id, seekerDto.id)
                .append(firstName, seekerDto.firstName)
                .append(lastName, seekerDto.lastName)
                .append(dateOfAddition, seekerDto.dateOfAddition)
                .append(dateOfInterview, seekerDto.dateOfInterview)
                .append(seekerContacts, seekerDto.seekerContacts)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(dateOfAddition)
                .append(dateOfInterview)
                .append(seekerContacts)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SeekerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfAddition=" + dateOfAddition +
                ", dateOfInterview=" + dateOfInterview +
                ", seekerContacts=" + seekerContacts +
                '}';
    }
}
