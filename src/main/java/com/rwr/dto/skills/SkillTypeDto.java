package com.rwr.dto.skills;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SkillTypeDto {
    private Integer id;
    private String skillName;

    public SkillTypeDto() {
    }

    public SkillTypeDto(Integer id) {
        this.id = id;
    }

    public SkillTypeDto(Integer id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SkillTypeDto)) return false;

        SkillTypeDto that = (SkillTypeDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(skillName, that.skillName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(skillName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SkillTypeDto{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
