package br.com.edilson.justiniano.design.patterns.composite.component;

import br.com.edilson.justiniano.design.patterns.composite.api.EmployeeLevel;

public class Employee extends EmployeeLevel {

	private String jobTitle;
	private double initialSalary;
	private double finalSalary;
	private String jobRole;

	public Employee(String jobTitle) {
		this.jobTitle = jobTitle;
		this.initialSalary = 0d;
		this.finalSalary = 0d;
		this.jobRole = null;
	}

	@Override
	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public void setInitialSalary(double salary) {
		this.initialSalary = salary;
	}

	@Override
	public void setFinalSalary(double salary) {
		this.finalSalary = salary;
	}

	@Override
	public void setJobRole(String role) {
		this.jobRole = role;
	}

	@Override
	public void generateEmployeeLevel() {
		System.out.println(jobTitle + ", initial salary: " + initialSalary + ", final salary: " + finalSalary
				+ ", role: " + jobRole);
	}

}
