package com.cg.apps.employeemsrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.employeemsrest.ui.EmployeeUi;

@SpringBootApplication
public class EmployeemsrestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EmployeemsrestApplication.class, args);
		EmployeeUi employeeUi=context.getBean(EmployeeUi.class);
	       employeeUi.start();
	}

}
