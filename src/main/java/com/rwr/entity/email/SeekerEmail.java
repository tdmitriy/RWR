package com.rwr.entity.email;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rwr.entity.BaseEntity;
import com.rwr.entity.seeker.Seeker;

import javax.persistence.*;

/**
 * Created by haswell on 30.10.15.
 */

@Entity
@Table(name = "SEEKER_EMAIL")
public class SeekerEmail extends BaseEntity {

    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seeker_id")
    @JsonBackReference
    private Seeker emailOwner;

    public SeekerEmail() {
    }

    public SeekerEmail(String email, Seeker emailOwner) {
        this.email = email;
        this.emailOwner = emailOwner;
    }

    public SeekerEmail(Integer id, String email, Seeker emailOwner) {
        super.setId(id);
        this.email = email;
        this.emailOwner = emailOwner;
    }

    public SeekerEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Seeker getEmailOwner() {
        return emailOwner;
    }

    public void setEmailOwner(Seeker emailOwner) {
        this.emailOwner = emailOwner;
    }
}
