package com.rwr.entity.seeker;

import com.rwr.entity.BaseEntity;
import com.rwr.entity.contacts.Contacts;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by Dmitriy on 29.10.2015.
 */

@Entity
@Table(name = "SEEKER")
public class Seeker extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_addition", nullable = false)
    private Date dateOfAddition;

    @Column(name = "date_of_interview", nullable = false)
    private Date dateOfInterview;


    //TODO
    private Contacts contacts;

    public Seeker() {
    }

    public Seeker(String firstName, String lastName, Date dateOfAddition, Date dateOfInterview, Contacts contacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfAddition = dateOfAddition;
        this.dateOfInterview = dateOfInterview;
        this.contacts = contacts;
    }

    public Seeker(Integer id, String firstName, String lastName, Date dateOfAddition, Date dateOfInterview, Contacts contacts) {
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

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
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
