package com.thales.models;

import java.util.List;

public class PlanningManager {

    public PlanningManager(List<Contributor> contributorList) {
        this.contributorList = contributorList;
    }

    private List<Contributor> contributorList;

    public Contributor findBestContributor(String role, int level) {
        for(Contributor c : contributorList) {
            if (!c.isBusy() && c.getSkills().containsKey(role) && c.getSkills().get(role) >= level) {
                c.setBusy(true);
                return c;
            }
        }
        return null;
    }

    public void freeAll() {
        for(Contributor c : contributorList) {
            c.setBusy(false);
        }
    }
}
