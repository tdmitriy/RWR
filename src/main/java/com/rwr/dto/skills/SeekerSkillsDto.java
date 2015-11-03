package com.rwr.dto.skills;

import com.rwr.dto.seeker.SeekerDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Dmitriy on 01.11.2015.
 */
public class SeekerSkillsDto {
    private Integer id;
    private SkillTypeDto skillType;
    private Integer skillRating;
    private SeekerDto skillOwner;

    public SeekerSkillsDto() {
    }

    public SeekerSkillsDto(SkillTypeDto skillType, Integer skillRating) {
        this.id = id;
        this.skillType = skillType;
        this.skillRating = skillRating;
    }

    public SeekerSkillsDto(Integer id, SkillTypeDto skillType, Integer skillRating, SeekerDto skillOwner) {
        this.skillType = skillType;
        this.skillRating = skillRating;
        this.skillOwner = skillOwner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SkillTypeDto getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillTypeDto skillType) {
        this.skillType = skillType;
    }

    public Integer getSkillRating() {
        return skillRating;
    }

    public void setSkillRating(Integer skillRating) {
        this.skillRating = skillRating;
    }

    public SeekerDto getSkillOwner() {
        return skillOwner;
    }

    public void setSkillOwner(SeekerDto skillOwner) {
        this.skillOwner = skillOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SeekerSkillsDto)) return false;

        SeekerSkillsDto that = (SeekerSkillsDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(skillType, that.skillType)
                .append(skillRating, that.skillRating)
                .append(skillOwner, that.skillOwner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(skillType)
                .append(skillRating)
                .append(skillOwner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SeekerSkillsDto{" +
                "id=" + id +
                ", skillType=" + skillType +
                ", skillRating=" + skillRating +
                ", skillOwner=" + skillOwner +
                '}';
    }
}
