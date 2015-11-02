package com.rwr.entity.skills;

import com.rwr.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by haswell on 30.10.15.
 */

@Entity
@Table(name = "SKILL_TYPE")
public class SkillType extends BaseEntity {

    @Column(name = "type")
    private String skillType;

    public SkillType() {
    }

    public SkillType(Integer id) {
        super.setId(id);
    }

    public SkillType(String skillType) {
        this.skillType = skillType;
    }

    public SkillType(Integer id, String skillType) {
        super.setId(id);
        this.skillType = skillType;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
}
