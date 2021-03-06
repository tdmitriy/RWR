package com.rwr.entity.skills;

import com.rwr.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL_TYPE")
public class SkillType extends BaseEntity {
    @Column(name = "type")
    private String skillName;

    public SkillType() {
    }

    public SkillType(String skillName) {
        this.skillName = skillName;
    }

    public SkillType(Integer id) {
        super.setId(id);
    }

    public SkillType(Integer id, String skillName) {
        super.setId(id);
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

}
