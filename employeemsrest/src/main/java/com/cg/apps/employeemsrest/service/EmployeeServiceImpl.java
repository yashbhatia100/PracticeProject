package com.cg.apps.employeemsrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.employeemsrest.dao.*;
import com.cg.apps.employeemsrest.entities.*;
import com.cg.apps.employeemsrest.exceptions.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;

	@Override
	public Employee addEmployee(String name, String department) {
		validateName(name);
		validateDepartment(department);
		Employee employee = new Employee(name, department);
		dao.addEmployee(employee);
		return employee;

	}

	@Override
	public Employee updateName(int id, String name) {
		validateName(name);
		Employee employee = findById(id);
		employee.setName(name);
		employee = dao.Update(employee);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		validateId(id);
		Employee employee = dao.findById(id);
		return employee;

	}

	@Override
	public void removeById(int id) {
		validateId(id);
		dao.removeById(id);
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = dao.findAll();
		return employees;
	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidEmployeeIdException("id should not be negative");
		}
	}

	void validateName(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty() || name.length() > 10) {
			throw new InvalidEmployeeNameExcpetion("name can't be null or empty");
		}
	}

	void validateDepartment(String department) {
		if (department == null || department.isEmpty() || department.trim().isEmpty() || department.length() > 5) {
			throw new InvalidDepartmentException("Department can't be null or empty");
		}
	}

}
