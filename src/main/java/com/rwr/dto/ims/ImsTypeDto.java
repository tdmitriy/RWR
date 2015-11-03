package com.rwr.dto.ims;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class ImsTypeDto {
    private Integer id;
    private String typeName;

    public ImsTypeDto() {
    }

    public ImsTypeDto(Integer id) {
        this.id = id;
    }

    public ImsTypeDto(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ImsTypeDto)) return false;

        ImsTypeDto that = (ImsTypeDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(typeName, that.typeName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(typeName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ImsTypeDto{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
