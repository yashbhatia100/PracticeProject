package com.cg.apps.employeemsrest.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import com.cg.apps.employeemsrest.entities.Employee;
@Component
public class EmployeeStore {
	public EmployeeStore() {

	}

	public static Map<Integer, Employee> empStore = new HashMap<>();
	public Map<Integer,Employee> getempStore(){
		return empStore;
	}
	

}
