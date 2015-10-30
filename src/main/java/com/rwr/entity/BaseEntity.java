package com.rwr.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Dmitriy on 29.10.2015.
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return new EqualsBuilder()
                .append(this.id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.id)
                .toHashCode();
    }
}
