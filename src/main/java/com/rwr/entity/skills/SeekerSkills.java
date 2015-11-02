package com.rwr.entity.skills;

import com.rwr.entity.BaseEntity;
import com.rwr.entity.seeker.Seeker;

import javax.persistence.*;

/**
 * Created by haswell on 30.10.15.
 */

@Entity
@Table(name = "SEEKER_SKILLS")
public class SeekerSkills extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_type_id")
    private SkillType skillType;

    @Column(name = "skill_rating")
    private Integer skillRating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seeker_id")
    private Seeker skillsOwner;

    public SeekerSkills() {
    }

    public SeekerSkills(SkillType skillType, Integer skillRating) {
        this.skillType = skillType;
        this.skillRating = skillRating;
    }

    public SeekerSkills(SkillType skillType, Integer skillRating, Seeker skillsOwner) {
        this.skillType = skillType;
        this.skillRating = skillRating;
        this.skillsOwner = skillsOwner;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public Integer getSkillRating() {
        return skillRating;
    }

    public void setSkillRating(Integer skillRating) {
        this.skillRating = skillRating;
    }

    public Seeker getSkillsOwner() {
        return skillsOwner;
    }

    public void setSkillsOwner(Seeker skillsOwner) {
        this.skillsOwner = skillsOwner;
    }
}
