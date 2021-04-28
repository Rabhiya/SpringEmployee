package com.service;

import com.dao.*;
import com.model.*;

public class EmployeeService implements IEmployeeService {
	
	private DAO dao;
	private long idGenarator;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public long id(){
		 this.idGenarator = dao.createId();
		 return ++idGenarator;
	}

	public long addEmployee(Employee employee) {
		employee.setId(id());
		return dao.addEmployee(employee);
	}

	public Employee searchEmployeeByID(long employeeId) {

		Employee foundEmployee = dao.getEmployeeById(employeeId);
		return foundEmployee;
	}


	public DAO getDao() {
		return dao;
	}

	public boolean removeEmployee(long employeeID) {
		boolean deletionStatus = dao.deleteEmployee(employeeID);
		if (deletionStatus) {
			return true;
		} else {
			return false;

		}

	}

	public boolean updateEmployeeName(String name, long id) {
		boolean status = dao.updateEmployeeName(name, id);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateEmployeeAge(int age, long id) {
		boolean status = dao.updateEmployeeAge(age, id);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateEmployeeAddress(String address, long id) {

		boolean status = dao.updateEmployeeAddress(address, id);
		if (status) {
			return true;
		} else {
			return false;
		}

	}

	public boolean findEmployee(long id) {
		Employee foundEmployee = dao.getEmployeeById(id);
		if (foundEmployee == null) {
			return false;
		} else {
			return true;
		}
	}

	public void getAllEmployees() {
		dao.displayEmployee();
	}

}


