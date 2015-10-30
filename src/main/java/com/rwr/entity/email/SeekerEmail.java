package com.rwr.entity.email;

import com.rwr.entity.BaseEntity;

/**
 * Created by haswell on 30.10.15.
 */
public class SeekerEmail extends BaseEntity {
    private String email;

    public SeekerEmail() {
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
}
