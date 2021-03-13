package com.cg.apps.employeemsrest.dao;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.employeemsrest.entities.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private EmployeeStore employeeStore;
	private Map<Integer, Employee> empStore;

	@PostConstruct
	public void afterInit() {
		empStore = employeeStore.getempStore();
	}

	public int generateId() {
		int generatedId = empStore.size() + 1;
		return generatedId;
	}

	@Override
	public void addEmployee(Employee employee) {
		Map<Integer, Employee> empStore = EmployeeStore.empStore;
		int id = generateId();
		employee.setId(id);
		empStore.put(id, employee);

	}

	@Override
	public Employee findById(int id) {
		Map<Integer, Employee> empStore = EmployeeStore.empStore;
		Employee employee = empStore.get(id);
		return employee;

	}

	@Override
	public void removeById(int id) {
		Map<Integer, Employee> empStore = EmployeeStore.empStore;
		Employee employee = empStore.remove(id);

	}
	
	@Override
	public Employee Update(Employee employee) {

		empStore.put(employee.getId(), employee);
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		Map<Integer, Employee> empStore = EmployeeStore.empStore;
		Collection<Employee> employees = empStore.values();
		List<Employee> list = new ArrayList<>(employees);
		return list;

	}

}
