package br.com.edilson.justiniano.design.patterns.composite.runner;

import br.com.edilson.justiniano.design.patterns.composite.api.EmployeeLevel;
import br.com.edilson.justiniano.design.patterns.composite.component.Employee;
import br.com.edilson.justiniano.design.patterns.composite.component.ParentEmployee;

public class Runner {

	public static void main(String[] args) {
		// CEO of the company
		EmployeeLevel boss = new ParentEmployee("CEO");
		boss.setInitialSalary(10000d);
		boss.setFinalSalary(30000d);
		boss.setJobRole("Boss");

		// Line Manager Children of CEO node
		EmployeeLevel lineManager = new ParentEmployee("Line Manager");
		lineManager.setInitialSalary(6000d);
		lineManager.setFinalSalary(14000d);
		lineManager.setJobRole("Manager");

		boss.addChildEmployeeLevel(lineManager);

		// Developer the first Leaf in the structure
		EmployeeLevel developer = new Employee("Developer");
		developer.setInitialSalary(4000d);
		developer.setFinalSalary(10000d);
		developer.setJobRole("Programmer");

		// Intern ship the second Leaf in the structure
		EmployeeLevel internship = new Employee("Intern ship");
		internship.setInitialSalary(1000d);
		internship.setFinalSalary(2500d);
		internship.setJobRole("Programmer assistant");

		lineManager.addChildEmployeeLevel(developer);
		lineManager.addChildEmployeeLevel(internship);

		boss.generateEmployeeLevel();
	}

}
