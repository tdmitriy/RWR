package com.rwr.entity.phone;

import com.rwr.entity.BaseEntity;
import com.rwr.entity.seeker.Seeker;

import javax.persistence.*;

/**
 * Created by haswell on 30.10.15.
 */

@Entity
@Table(name = "SEEKER_PHONE")
public class SeekerPhone extends BaseEntity {

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seeker_id")
    private Seeker phoneOwner;

    public SeekerPhone() {
    }

    public SeekerPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SeekerPhone(String phoneNumber, Seeker phoneOwner) {
        this.phoneNumber = phoneNumber;
        this.phoneOwner = phoneOwner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Seeker getPhoneOwner() {
        return phoneOwner;
    }

    public void setPhoneOwner(Seeker phoneOwner) {
        this.phoneOwner = phoneOwner;
    }

    @Override
    public String toString() {
        return "SeekerPhone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", phoneOwner=" + phoneOwner +
                '}';
    }
}
