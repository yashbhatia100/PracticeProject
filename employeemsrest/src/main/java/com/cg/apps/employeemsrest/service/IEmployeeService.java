package com.cg.apps.employeemsrest.service;

import java.util.*;
import com.cg.apps.employeemsrest.entities.Employee;

public interface IEmployeeService {
	Employee addEmployee(String name, String department);

	Employee findById(int id);

	void removeById(int id);
	
	Employee updateName(int id,String name);

	List<Employee> findAll();

}
