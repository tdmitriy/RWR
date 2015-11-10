package com.rwr.entity.seeker;

import com.rwr.entity.BaseEntity;
import com.rwr.entity.contacts.SeekerContacts;
import com.rwr.entity.skills.SeekerSkill;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SEEKER")
public class Seeker extends BaseEntity {

    @Column(name = "first_name")
    @NotNull(message = "First name is required.")
    @Size(min = 2, max = 30, message = "First name must be between {min} - {max} values.")
    @Pattern(regexp = "[A-Za-zА-Яа-я]*", message = "First name must contains only letters.")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name is required.")
    @Size(min = 2, max = 30, message = "Last name must be between {min} - {max} values.")
    @Pattern(regexp = "[A-Za-zА-Яа-я]*", message = "Last name must contains only letters.")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_addition")
    @NotNull(message = "Date of addition is required.")
    private Date dateOfAddition;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_interview")
    private Date dateOfInterview;

    @Embedded
    private SeekerContacts contacts;

    @OrderBy("skillRating DESC")
    @OneToMany(mappedBy = "skillsOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SeekerSkill> seekerSkills;

    public Seeker() {
    }

    public Seeker(Integer id, String firstName, String lastName, Date dateOfAddition, Date dateOfInterview,
                  SeekerContacts contacts, Set<SeekerSkill> seekerSkills) {
        super.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfAddition = dateOfAddition;
        this.dateOfInterview = dateOfInterview;
        this.contacts = contacts;
        this.seekerSkills = seekerSkills;
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

    public Set<SeekerSkill> getSeekerSkills() {
        return seekerSkills;
    }

    public void setSeekerSkills(Set<SeekerSkill> seekerSkills) {
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
