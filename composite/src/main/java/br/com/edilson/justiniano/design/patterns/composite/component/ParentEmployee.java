package br.com.edilson.justiniano.design.patterns.composite.component;

import java.util.ArrayList;
import java.util.List;

import br.com.edilson.justiniano.design.patterns.composite.api.EmployeeLevel;

public class ParentEmployee extends EmployeeLevel {

	private String jobTitle;
	private double initialSalary;
	private double finalSalary;
	private List<EmployeeLevel> childrenEmployeeLevel;
	private String jobRole;

	public ParentEmployee(String jobTitle) {
		this.jobTitle = jobTitle;
		this.initialSalary = 0d;
		this.finalSalary = 0d;
		this.childrenEmployeeLevel = new ArrayList<>();
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
	public void addChildEmployeeLevel(EmployeeLevel employeeLevel) {
		childrenEmployeeLevel.add(employeeLevel);
	}

	@Override
	public void removeChildEmplyeeLevel(EmployeeLevel employeeLevel) {
		childrenEmployeeLevel.remove(employeeLevel);
	}

	@Override
	public List<EmployeeLevel> getChildren() {
		return childrenEmployeeLevel;
	}

	@Override
	public void generateEmployeeLevel() {
		System.out.println(getJobTitle());
		System.out.println(jobRole);
		System.out.println(initialSalary);
		System.out.println(finalSalary);
		childrenEmployeeLevel.stream().forEach(employeeLevel -> employeeLevel.generateEmployeeLevel());
	}

}
