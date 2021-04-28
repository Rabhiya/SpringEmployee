package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.*;
import com.model.*;

	public class DAO {
		private static ConnectionUtility conUtil = new ConnectionUtility();
		private static Connection con = conUtil.getConnect();
		
		public long addEmployee(Employee employeeDetails) {
			try {
				PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?,?)");
				stmt.setLong(1, employeeDetails.getId());
				stmt.setString(2, employeeDetails.getName());
				stmt.setInt(3, employeeDetails.getAge());
				stmt.setString(4, employeeDetails.getAddress());

				int res = stmt.executeUpdate();

				if (res != 0) {
					return employeeDetails.getId();
				}
			} catch (SQLException e) {
				System.out.println("Can not insert details error code " + e);

			}
			return 0;
		}

		public Employee getEmployeeById(long id) {
			Employee emp = null;

			try {
				PreparedStatement stmt = con.prepareStatement("select * from emp where id=?");
				stmt.setLong(1, id);
				ResultSet res = stmt.executeQuery();
				while (res.next()) {
					emp = Employee.createEmployee(res.getLong(1), res.getNString(2), res.getInt(3),
							res.getString(4));
				}
				return emp;
			} catch (SQLException e) {
				System.out.println("Error In Searching...");
			}
			return null;
		}

		public boolean deleteEmployee(long id) {
			try {
				PreparedStatement stmt = con.prepareStatement("delete from emp where id=?");
				stmt.setLong(1, id);
				int res = stmt.executeUpdate();
				if (res != 0) {
					return true;
				}
			} catch (SQLException e) {
				System.out.println("Error In Deletion...");
			}
			return false;
		}

		public long createId(){
			long id = 0;
			try {

				PreparedStatement stmt = con.prepareStatement("select er.id(select id,Row_Number() over(order by id) 'rownum' from emp) er where er.rownum<=1 order by id desc");
				ResultSet res = stmt.executeQuery();
				while (res.next()) {
					id = res.getLong(1);
				}
				if (id <= 0) {
					return 10125;
				} else {
					return id;
				}
			} catch (SQLException e) {
				System.out.println("Error Occurred During Id Creation");
				e.printStackTrace();
			}
			return 0;
		}
		
		/*public long id()
		{
		List<Employee> empList = new ArrayList<Employee>();
		if(empList.size()>0)
		{
			return(empList.get(empList.size()-1).getId())+1;
		}
		else
		{
			return 10125;
		}
		}*/

		public boolean updateEmployeeName(String name, long id) {
			try {
				PreparedStatement stmt = con.prepareStatement("update emp set name=? where id=?");
				stmt.setString(1, name);
				stmt.setLong(2, id);
				int res = stmt.executeUpdate();
				if (res != 0) {
					return true;
				}
			} catch (SQLException e) {
				System.out.println("Error During Employee Name Update...");
			}
			return false;
		}

		public boolean updateEmployeeAge(int age, long id) {
			try {
				PreparedStatement stmt = con.prepareStatement("update emp set age=? where id=?");
				stmt.setInt(1, age);
				stmt.setLong(2, id);
				int res = stmt.executeUpdate();
				if (res != 0) {
					return true;
				}
			} catch (SQLException e) {
				System.out.println("Error During Employee Age Update...");
			}
			return false;
		}

		public boolean updateEmployeeAddress(String address, long id) {
			try {
				PreparedStatement stmt = con.prepareStatement("update emp set address=? where id=?");
				stmt.setString(1, address);
				stmt.setLong(2, id);
				int res = stmt.executeUpdate();
				if (res != 0) {
					return true;
				}
			} catch (SQLException e) {
				System.out.println("Error During Update Address...");
			}
			return false;
		}

		public void displayEmployee() {
			List<Employee> employeeList = new ArrayList<Employee>();
			try {
				PreparedStatement stmt = con.prepareStatement("select * from Employee");
				ResultSet res = stmt.executeQuery();
				while (res.next()) {
					Employee employee = Employee.createEmployee(res.getLong(1), res.getString(2), res.getInt(3),
							res.getString(4));
					employeeList.add(employee);
				}
				for (int i = 0; i < employeeList.size(); i++) {
					System.out.println("Employee Id: " + employeeList.get(i).getId() + ", Employee Name: "
							+ employeeList.get(i).getName() + ", Employee age: "
							+ employeeList.get(i).getAge() + ", Employee Address: "
							+ employeeList.get(i).getAddress());
				}
			} catch (Exception e) {
				System.out.println("Error In Showing Details");
			}

		}

	}


