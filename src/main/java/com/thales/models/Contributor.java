package com.thales.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contributor {
    private String name;
    private Map<String, Integer> skills;
    private boolean isBusy;

    public Contributor(String name, Map<String, Integer> skills) {
        this.name = name;
        this.skills = skills;
    }

    public Contributor() { }

    public void addSkill(String skillValue) {
        String[] skill = skillValue.split(" ");
        this.skills.put(skill[0], Integer.parseInt(skill[1]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = new HashMap<>();
        skills.forEach(s -> {
            String[] skill = s.split(" ");
            this.skills.put(skill[0], Integer.parseInt(skill[1]));
        });
    }


    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
