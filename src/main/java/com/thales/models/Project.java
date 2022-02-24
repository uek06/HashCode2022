package com.thales.models;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private int duration;
    private int score;
    private int bestBefore;
    private List<Skill> roles;
    private List<Contributor> contributorList = new ArrayList<>();
    private boolean isStarted = false;

    public Project(String name, int duration, int score, int bestBefore, List<Skill> roles) {
        this.name = name;
        this.duration = duration;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = roles;
    }

    public Project() {
        roles = new ArrayList<>();
    }

    public void doProject() {
        for (int i = 0; i < this.contributorList.size(); i++) {
            Skill skill = this.roles.get(i);
            if (skill.getLevel() == this.contributorList.get(i).getSkills().get(skill.getName())) {
                this.contributorList.get(i).upSkill(skill.getName());
            }
            this.contributorList.get(i).setBusy(true);
        }
        start();
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void start() {
        this.isStarted = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }

    public List<Skill> getRoles() {
        return roles;
    }

//    public void setRoles(List<Skill> roles) {
//        this.roles = roles;
//    }

    public void setRoles(List<String> roles) {
        // roles are a list of string of value something like "html 7"
        roles.forEach(r -> {
            this.roles.add(new Skill(r.split(" ")));
        });
    }

    public String toString() {
        return this.name + " " + this.duration + " " + this.score + " " + this.bestBefore + " " + this.roles.size() + "\n";
    }

    public Double getPriority() {
        return (double) (score / bestBefore);
    }


    public List<Contributor> getContributorList() {
        return contributorList;
    }

    public void setContributorList(List<Contributor> contributorList) {
        this.contributorList = contributorList;
    }

    public void addContributor(Contributor contributor) {
        this.contributorList.add(contributor);
    }

}
