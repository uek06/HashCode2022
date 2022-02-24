package com.thales;

import com.thales.models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final String[] fileNames = {Filename.EXAMPLE_1.name, Filename.EXAMPLE_2.name, Filename.EXAMPLE_3.name, Filename.EXAMPLE_4.name, Filename.EXAMPLE_5.name, Filename.EXAMPLE_6.name};
    private static int test;

    public static void main(String[] args) {
        for (String fileName : fileNames) {
            process(fileName);
        }
    }

    private static void process(String filename) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("resources/" + filename + ".in"));
            String line = bf.readLine();
            String[] constants = line.split(" ");
            test = Integer.parseInt(constants[0]);

            bf.close();
            // Run simulation
            runSimulation();

            saveOutput(filename);
        } catch (Exception e) {
            e.printStackTrace();
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

    private static void runSimulation() {
        Project p = new Project("yolo", 2, 2, 2, null);
        Project p2 = new Project("yolo", 2, 1, 2, null);
        List<Project> projects = new ArrayList<>();
        projects.add(p);
        projects.add(p2);
        projects.sort(Comparator.comparing(Project::getPriority, Comparator.reverseOrder()));
        PlanningManager planningManager = new PlanningManager(null);
        for(Project p : projects) {
            for(Skill skill : p.getRoles()) {
                Contributor contributor = planningManager.findBestContributor(skill.getName(), skill.getLevel());
                p.addContributor(contributor);
                
            }
        }
        List<Project> projects2 = new ArrayList<>();


    }

}
