package com.cg.apps.employeemsrest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import com.cg.apps.employeemsrest.dto.EmployeeDetails;
import com.cg.apps.employeemsrest.entities.Employee;


@Component
public class EmployeeUtil {
	public EmployeeDetails toDetails(Employee employee) {
		EmployeeDetails details = new EmployeeDetails(employee.getId(), employee.getName(), employee.getDepartment());
		return details;
	}
	
	 public List<EmployeeDetails> toDetailsList(Collection<Employee> employees){
	        List<EmployeeDetails>desired=new ArrayList<>();
			for (Employee employee : employees){
	        	EmployeeDetails details=toDetails(employee);
	            desired.add(details);
	        }
	        return desired;

	    }

}
