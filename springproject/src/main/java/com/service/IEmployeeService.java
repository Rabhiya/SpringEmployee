package com.service;

import com.model.Employee;

public interface IEmployeeService {
	
	long addEmployee(Employee employee);
	boolean removeEmployee(long employeeID);
	boolean updateEmployeeName(String name, long id);

}
