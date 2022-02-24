package com.thales.models;

import java.util.List;

public class Contributor {
    private String name;
    private List<Skill> skills;

    public Contributor(String name, List<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
