package com.rwr.entity.seeker;

import com.rwr.entity.BaseEntity;
import com.rwr.entity.contacts.Contacts;
import org.springframework.core.style.ToStringCreator;

import java.util.Date;
import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */

public class Seeker extends BaseEntity {

    private String firstName;
    private String lastName;
    private Date dateOfAddition;
    private Date dateOfInterview;
    private List<Contacts> contacts;

    public Seeker() {
    }

    public Seeker(String firstName, String lastName, Date dateOfAddition, Date dateOfInterview, List<Contacts> contacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfAddition = dateOfAddition;
        this.dateOfInterview = dateOfInterview;
        this.contacts = contacts;
    }

    public Seeker(Integer id, String firstName, String lastName, Date dateOfAddition, Date dateOfInterview, List<Contacts> contacts) {
        super.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfAddition = dateOfAddition;
        this.dateOfInterview = dateOfInterview;
        this.contacts = contacts;
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

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this.getClass().getName())
                .append("id", getId())
                .append("firstName", getFirstName())
                .append("lastName", getLastName())
                .append("dateOfAddition", getDateOfAddition())
                .append("dateOfInterview", getDateOfInterview())
                .toString();
    }
}
