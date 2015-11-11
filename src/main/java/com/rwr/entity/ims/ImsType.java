package com.rwr.entity.ims;

import com.rwr.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "IMS_TYPE")
public class ImsType extends BaseEntity {
    @Column(name = "type")
    private String typeName;

    public ImsType() {
    }

    public ImsType(Integer id) {
        super.setId(id);
    }

    public ImsType(String typeName) {
        this.typeName = typeName;
    }

    public ImsType(Integer id, String typeName) {
        super.setId(id);
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
