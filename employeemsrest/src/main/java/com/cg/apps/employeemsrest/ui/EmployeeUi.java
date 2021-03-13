package com.cg.apps.employeemsrest.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.employeemsrest.entities.Employee;
import com.cg.apps.employeemsrest.exceptions.*;
import com.cg.apps.employeemsrest.service.*;

@Component
public class EmployeeUi {
	@Autowired
	private IEmployeeService service;

	public static void main(String args[]) {

		EmployeeUi app = new EmployeeUi();
		app.start();

	}

	public void start() {
		try {
			Employee yash = service.addEmployee("Yash ", "IT");
			display(yash);
			Employee yash1 = service.addEmployee("Yash1", "HR");
			display(yash1);
			Employee yash2 = service.addEmployee("Yash2", "IT");
			Employee yash3 = service.addEmployee("Yash3", "HR");
			display(yash2);

			System.out.println("******Printing by id****");
			Employee fetchedEmployee = service.findById(yash1.getId());
			display(fetchedEmployee);
			service.removeById(2);

			System.out.println("**displaying all students***");
			List<Employee> list = service.findAll();
			findAll(list);

		} catch (InvalidEmployeeIdException e) {
			System.out.println("Sorry Invalid Id Entered");
		} catch (InvalidDepartmentException e) {
			System.out.println("Sorry Department is not correct");
		} catch (InvalidEmployeeNameExcpetion e) {
			System.out.println("Sorry Employee name is not correct");
		} catch (Exception e) {
			System.out.println("Sorry Please Try Again");
		}
	}

	public void findAll(Collection<Employee> employees) {
		for (Employee employee : employees) {
			display(employee);
		}
	}

	public void display(Employee employee) {
		System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getDepartment());
	}

}