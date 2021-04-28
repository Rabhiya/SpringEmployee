package com.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.controller.EmployeeController;

public class EmployeeMain {
				
				private static final String CONFIG_LOCATION = "bean.xml";
				public static void main(String[] args) {
						ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
						EmployeeController controller = context.getBean("controller", EmployeeController.class);
						controller.handleRequest();
						context.close();
				
			}

		}

