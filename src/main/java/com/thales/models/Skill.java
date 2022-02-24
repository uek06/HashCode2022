package com.thales.models;

public class Skill {
    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public Skill(String[] values) {
        this.name = values[0];
        this.level = Integer.parseInt(values[1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        return this.name + " " + this.level + "\n";
    }
}
