package com.thales.models;

import java.util.List;

public class PlanningManager {

    public PlanningManager(List<Contributor> contributorList) {
        this.contributorList = contributorList;
    }

    private List<Contributor> contributorList;

    public Contributor findBestContributor(String role, int level, Project project) {
        boolean mentor = project.getContributorList().stream().anyMatch(c -> c.getSkills().get(role) != null && c.getSkills().get(role) > level);
        Contributor contrib = null;
        for(Contributor c : contributorList) {
            if (!c.isBusy() && c.getSkills().containsKey(role) && c.getSkills().get(role) >= (mentor ? level-1 : level)) {
                //c.setBusy(true);
                contrib = contrib == null || contrib.getSkills().get(role) > c.getSkills().get(role) ? c : contrib;
            }
        }
        return contrib;
    }

    public void freeAll() {
        for(Contributor c : contributorList) {
            c.setBusy(false);
        }
    }
}
