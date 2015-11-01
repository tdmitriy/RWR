package com.rwr.entity.ims;

import com.rwr.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by haswell on 30.10.15.
 */

@Entity
@Table(name = "IMS_TYPE")
public class ImsType extends BaseEntity {

    @Column(name = "type")
    private String imsType;

    public ImsType() {
    }

    public ImsType(String imsType) {
        this.imsType = imsType;
    }

    public String getImsType() {
        return imsType;
    }

    public void setImsType(String imsType) {
        this.imsType = imsType;
    }
}
