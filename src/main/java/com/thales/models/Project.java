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

    public Project(String name, int duration, int score, int bestBefore, List<Skill> roles) {
        this.name = name;
        this.duration = duration;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = roles;
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

    public void setRoles(List<Skill> roles) {
        this.roles = roles;
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
