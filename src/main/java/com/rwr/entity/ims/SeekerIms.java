package com.rwr.entity.ims;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rwr.entity.BaseEntity;
import com.rwr.entity.seeker.Seeker;

import javax.persistence.*;

@Entity
@Table(name = "SEEKER_IMS")
public class SeekerIms extends BaseEntity {

    @Column(name = "ims_login")
    private String imsLogin;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ims_type_id")
    private ImsType imsType;

    @ManyToOne
    @JoinColumn(name = "seeker_id", referencedColumnName = "id")
    @JsonBackReference
    private Seeker imsOwner;

    public SeekerIms() {
    }

    public SeekerIms(String imsLogin, ImsType imsType, Seeker imsOwner) {
        this.imsLogin = imsLogin;
        this.imsType = imsType;
        this.imsOwner = imsOwner;
    }

    public SeekerIms(Integer id, String imsLogin, ImsType imsType, Seeker imsOwner) {
        super.setId(id);
        this.imsLogin = imsLogin;
        this.imsType = imsType;
        this.imsOwner = imsOwner;
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

    public Seeker getImsOwner() {
        return imsOwner;
    }

    public void setImsOwner(Seeker imsOwner) {
        this.imsOwner = imsOwner;
    }
}
