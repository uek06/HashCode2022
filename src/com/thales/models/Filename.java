package com.thales.models;

public enum Filename {
    EXAMPLE_1("a_example"),
    EXAMPLE_2("b_should_be_easy"),
    EXAMPLE_3("c_no_hurry"),
    EXAMPLE_4("d_metropolis"),
    EXAMPLE_5("e_high_bonus");

    public final String name;

    Filename(String name) {
        this.name = name;
    }
}
