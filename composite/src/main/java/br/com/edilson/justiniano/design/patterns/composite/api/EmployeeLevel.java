package br.com.edilson.justiniano.design.patterns.composite.api;

import java.util.List;

public abstract class EmployeeLevel {

	public abstract String getJobTitle();

	public abstract void setInitialSalary(double salary);

	public abstract void setFinalSalary(double salary);

	public void setJobRole(String role) {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public void addChildEmployeeLevel(EmployeeLevel employeeLevel) {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public void removeChildEmplyeeLevel(EmployeeLevel employeeLevel) {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public List<EmployeeLevel> getChildren() {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public abstract void generateEmployeeLevel();
}
