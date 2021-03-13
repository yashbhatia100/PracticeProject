package com.cg.apps.employeemsrest.dao;

import java.util.*;
import com.cg.apps.employeemsrest.entities.Employee;

public interface IEmployeeDao {
	void addEmployee(Employee employee);

	Employee findById(int id);

	void removeById(int id);
	
	Employee Update(Employee employee);
	

	List<Employee> findAll();

}
