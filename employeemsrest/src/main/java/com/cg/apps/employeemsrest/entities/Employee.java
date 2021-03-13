package com.cg.apps.employeemsrest.entities;


public class Employee {
private	int id;
	private String name;
	private String department;

	public Employee() {
		this("not given", "not given");
	}

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		String text = "id  " + id + " name " + "department ";
		return text;

	}
}
