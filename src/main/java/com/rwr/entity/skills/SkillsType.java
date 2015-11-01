package com.rwr.entity.skills;

import com.rwr.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by haswell on 30.10.15.
 */

@Entity
@Table(name = "SKILLS_TYPE")
public class SkillsType extends BaseEntity {

    @Column(name = "type")
    private String skillType;

    public SkillsType() {
    }

    public SkillsType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
}
