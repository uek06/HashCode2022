package com.thales.models;

import com.thales.interfaces.AbstractAlgorithm;

import java.util.ArrayList;
import java.util.List;

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
		for(int i = 0; i < numberOfCollaborators; i++) {
			Contributor c = new Contributor();
			String[] initLine = this.fh.readLine().split(" ");
			c.setName(initLine[0]);
			int nbSkills = Integer.parseInt(initLine[1]);
			List<String> skills = this.fh.readLines(nbSkills);
			c.setSkills(skills);
		}
		this.fh.write(this.getName() + '-' + filename, null);
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
