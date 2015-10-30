package com.rwr.entity.ims;

import com.rwr.entity.BaseEntity;

/**
 * Created by haswell on 30.10.15.
 */
public class SeekerIms extends BaseEntity {
    private String imsLogin;
    private ImsType imsType;

    public SeekerIms() {
    }

    public SeekerIms(String imsLogin, ImsType imsType) {
        this.imsLogin = imsLogin;
        this.imsType = imsType;
    }

    public String getImsLogin() {
        return imsLogin;
    }

    public void setImsLogin(String imsLogin) {
        this.imsLogin = imsLogin;
    }

    public ImsType getImsType() {
        return imsType;
    }

    public void setImsType(ImsType imsType) {
        this.imsType = imsType;
    }
}
