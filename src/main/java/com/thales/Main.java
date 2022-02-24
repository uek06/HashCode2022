package com.thales;

import com.thales.models.DefaultAlgorithm;
import com.thales.models.Filename;

import java.io.PrintWriter;

public class Main {
    private static final String[] fileNames = {Filename.EXAMPLE_1.name, Filename.EXAMPLE_2.name, Filename.EXAMPLE_3.name, Filename.EXAMPLE_4.name, Filename.EXAMPLE_5.name, Filename.EXAMPLE_6.name};
    private static int test;

    public static void main(String[] args) {
        for (String fileName : fileNames) {
            new DefaultAlgorithm().process(fileName);
        }
    }

    private static void saveOutput(String filename) {
        StringBuilder sb = new StringBuilder();

        sb.append(test);
        sb.append("\n");

        try {
            PrintWriter out = new PrintWriter(filename + ".out");
            out.write(sb.toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
