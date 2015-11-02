package com.rwr.entity.seeker;

import com.rwr.entity.BaseEntity;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.skills.SeekerSkills;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_addition", nullable = false)
    private Date dateOfAddition;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_interview", nullable = false)
    private Date dateOfInterview;

    @Embedded
    private SeekerContacts contacts;

    @OneToMany(mappedBy = "skillsOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SeekerSkills> seekerSkills;

    public Seeker() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfAddition() {
        return dateOfAddition;
    }

    public void setDateOfAddition(final Date dateOfAddition) {
        this.dateOfAddition = dateOfAddition;
    }

    public Date getDateOfInterview() {
        return dateOfInterview;
    }

    public void setDateOfInterview(final Date dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public Set<SeekerSkills> getSeekerSkills() {
        return seekerSkills;
    }

    public void setSeekerSkills(Set<SeekerSkills> seekerSkills) {
        this.seekerSkills = seekerSkills;
    }

    public SeekerContacts getContacts() {
        return contacts;
    }

    public void setContacts(SeekerContacts contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Seeker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfAddition=" + dateOfAddition +
                ", dateOfInterview=" + dateOfInterview +
                '}';
    }
}
