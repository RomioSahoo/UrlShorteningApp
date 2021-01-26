package com.projectprop.model;

public class Project {

	private String projectName;
	private String duration;
	private int budget;
	private String skills;
	private String status;
	//Generating Getters and Setters...
	
	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

}
