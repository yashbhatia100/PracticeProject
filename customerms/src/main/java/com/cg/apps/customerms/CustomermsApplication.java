package com.cg.apps.customerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//import com.cg.apps.customerms.items.ui.ItemUi;
import com.cg.apps.customerms.ui.CustomerUi;


@SpringBootApplication
public class CustomermsApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(CustomermsApplication.class, args);
	CustomerUi customerUi=context.getBean(CustomerUi.class);
	customerUi.start();
	
		
	}

}
