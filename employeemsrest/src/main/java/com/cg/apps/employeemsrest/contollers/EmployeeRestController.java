package com.cg.apps.employeemsrest.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.employeemsrest.util.EmployeeUtil;
import com.cg.apps.employeemsrest.dto.ChangeNameRequest;
import com.cg.apps.employeemsrest.dto.EmployeeDetails;
import com.cg.apps.employeemsrest.entities.Employee;
import com.cg.apps.employeemsrest.service.IEmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	@Autowired
	private EmployeeUtil util;
	

	@GetMapping("/byid/{id}")
	public EmployeeDetails fetchEmployee(@PathVariable("id") int employeeId) {
		Employee employee = service.findById(employeeId);
		EmployeeDetails details= util.toDetails(employee);
		return details;
	}

	@GetMapping
	public List<EmployeeDetails> allStudents() {
		List<Employee> list = service.findAll();
		List<EmployeeDetails>desired=util.toDetailsList(list);
		return desired;

	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee requestData) {
		Employee created = service.addEmployee(requestData.getName(), requestData.getDepartment());
		return "created student with id=" + created.getId();
	}
	  @PutMapping("/changename")
	    public EmployeeDetails changeName(@RequestBody ChangeNameRequest requestData) {
	        Employee employee = service.updateName(requestData.getId(), requestData.getName());
	       EmployeeDetails desired=util.toDetails(employee);
	        return desired;
	    }


}
