package com.rwr.entity.phone;

import com.rwr.entity.BaseEntity;

/**
 * Created by haswell on 30.10.15.
 */
public class SeekerPhone extends BaseEntity {
    private String phoneNumber;

    public SeekerPhone() {
    }

    public SeekerPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
