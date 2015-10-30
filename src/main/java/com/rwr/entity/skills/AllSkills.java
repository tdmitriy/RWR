package com.rwr.entity.skills;

import java.util.Set;

/**
 * Created by haswell on 30.10.15.
 */
public class AllSkills {
    private Set<String> allSkills;

    public AllSkills() {
    }

    public AllSkills(Set<String> allSkills) {
        this.allSkills = allSkills;
    }

    public Set<String> getAllSkills() {
        return allSkills;
    }

    public void setAllSkills(Set<String> allSkills) {
        this.allSkills = allSkills;
    }
}
