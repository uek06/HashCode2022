package com.thales.models;

public enum Filename {
    EXAMPLE_1("a_an_example"),
    EXAMPLE_2("b_better_start_small"),
    EXAMPLE_3("c_collaboration"),
    EXAMPLE_4("d_dense_schedule"),
    EXAMPLE_5("e_exceptional_skills"),
    EXAMPLE_6("f_find_great_mentors");

    public final String name;

    Filename(String name) {
        this.name = name;
    }
}
