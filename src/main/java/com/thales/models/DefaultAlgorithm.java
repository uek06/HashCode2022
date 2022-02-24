package com.thales.models;

import com.thales.interfaces.AbstractAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultAlgorithm extends AbstractAlgorithm {
	List<Contributor> contributorList = new ArrayList<>();
	List<Project> projectList = new ArrayList<>();

	@Override
	public void process(String filename) {
		// TODO Auto-generated method stub
		this.fh.open(filename);
		String[] firstLine = this.fh.readLine().split(" ");
		int numberOfCollaborators = Integer.parseInt(firstLine[0]);
		int numberOfProjects = Integer.parseInt(firstLine[1]);
		// Looping through C sections of collaborators
		for(int i = 0; i < numberOfCollaborators; i++) {
			// first line is name + number of skills
			Contributor c = new Contributor();
			String[] initLine = this.fh.readLine().split(" ");
			c.setName(initLine[0]);
			int nbSkills = Integer.parseInt(initLine[1]);
			// set n lines of skills as skill of contributor c
			List<String> skills = this.fh.readLines(nbSkills);
			c.setSkills(skills);
			// Add him to list of contributors
			this.contributorList.add(c);
		}
		// Looping through M projects
		for(int j = 0; j < numberOfProjects; j++) {
			// first line is name of project + number of roles
			Project p = new Project();

			String[] initLine = this.fh.readLine().split(" ");
			p.setName(initLine[0]);

			int duration = Integer.parseInt(initLine[1]);
			int score = Integer.parseInt(initLine[2]);
			int bestBefore = Integer.parseInt(initLine[3]);
			p.setDuration(duration);
			p.setScore(score);
			p.setBestBefore(bestBefore);
			int nbRoles = Integer.parseInt(initLine[4]);
			// set n lines of roles as roles of project p
			List<String> roles = this.fh.readLines(nbRoles);
			p.setRoles(roles);
			// Add him to list of projects
			this.projectList.add(p);
		}
		this.runSimulation();
		this.fh.write(this.getName() + '-' + filename, this.outputContent());
	}

	private List<String> outputContent() {
		List<String> res = new ArrayList<>();
		List<Project> doneProjects = this.projectList.stream().filter(p -> p.getContributorList().size() == p.getRoles().size()).collect(Collectors.toList());
		res.add(String.valueOf(doneProjects.size()));
		doneProjects.forEach(p -> {
			res.add(p.getName());
			res.add(p.getContributorList().stream().map(c -> c.getName()).collect(Collectors.joining(" ")));
		});
		return res;
	}

	private void runSimulation() {
		this.projectList.sort(Comparator.comparing(Project::getPriority, Comparator.reverseOrder()));
		PlanningManager planningManager = new PlanningManager(this.contributorList);
		for(Project project : this.projectList) {
			for(Skill skill : project.getRoles()) {
				Contributor contributor = planningManager.findBestContributor(skill.getName(), skill.getLevel());
				if (contributor != null) {
					project.addContributor(contributor);
				}
			}
			planningManager.freeAll();
		}
	}


	private List<String> restitute(String firstLine) {
		List<String> sb = new ArrayList<>();
		sb.add(firstLine);
		this.contributorList.forEach(c -> {
			sb.add(c.toString());
		});
		this.projectList.forEach(p -> {
			sb.add(p.toString());
		});
		return sb;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
