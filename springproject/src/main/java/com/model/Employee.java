package com.model;


public class Employee {
		private long employeeId = 11025;
		private String employeeName;
		private int employeeAge;
		private String employeeAddress;

		public Employee(long employeeId, String employeeName, int employeeAge, String employeeAddress) {
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.employeeAge = employeeAge;
			this.employeeAddress = employeeAddress;
		}
		
		public static Employee createEmployee(long employeeID, String name, int empAge, String address) {

			return new Employee(employeeID, name, empAge, address);

		}


		public long getId() {
			return employeeId;
		}
		
		public void setId(long employeeId) {
			this.employeeId = employeeId;
		}

		public String getName() {
			return employeeName;
		}
		
		public void setName(String employeeName) {
			 this.employeeName=employeeName;
		}

		public int getAge() {
			return employeeAge;
		}
		public void setAge(int employeeAge)
		{
			this.employeeAge = employeeAge;
		}

		

		public String getAddress() {
			return employeeAddress;
		}
		public void setAddress(String employeeAddress)
		{
			this.employeeAddress = employeeAddress;
		}


	}

