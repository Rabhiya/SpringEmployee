package com.controller;

import java.util.Scanner;
//import connection.*;

import com.model.Employee;
import com.service.EmployeeService;




   public class EmployeeController {
		private EmployeeService service;
		private Scanner scanner = new Scanner(System.in);
		
		
		public void setService(EmployeeService service) {
			this.service = service;
		}
		
		public void handleRequest() {
			boolean exit = false;
			displayMenu();
			while (!exit) {
				System.out.print("\nType here: (Press 6 to display menu)" + "\nType: ");
				String choice = scanner.nextLine();
				try {
					int intChoice = Integer.parseInt(choice);
					switch (intChoice) {
					case 0:
						System.out.println("Application closed");
						exit = true;
						break;
					case 1:
						addEmployee();
						break;
					case 2:
						showEmployee();
						break;
					case 3:
						updateEmployee();
						break;

					case 4:
						deleteEmployee();
						break;

					case 5:
						searchEmployee();
						break;

					case 6:
						displayMenu();
						break;
					}

				} catch (Exception e1) {
					System.out.println(
							"Plear enter 'Number' input.\nTo start from begining Press '1'\n" + "To terminate enter '0'");
					System.out.print("\nType: ");
					String newChoice = scanner.nextLine();
					try {
						int newIntChoice = Integer.parseInt(newChoice);
						switch (newIntChoice) {
						case 0:
							exit = true;
							break;
						case 1:
							exit = false;
							break;
						}

					} catch (Exception e2) {
						exit = true;
					}
				}
			}

		}


		public void addEmployee() {
			try {
				System.out.print("Enter the employee name: ");
				String name = scanner.nextLine();
				scanner.nextLine();
				System.out.print("Enter employee age: ");
				String age = scanner.nextLine();
				int intAge = Integer.parseInt(age);
				System.out.print("Enter employee address: ");
				String address = scanner.nextLine();
				System.out.println("Data added successfully");
				Employee newEmployee = Employee.createEmployee(0, name, intAge, address);
				System.out.println("\n Your Employee id: "+newEmployee.getId());
				
			} catch (Exception e) {
				System.out.println("Error in addition process");
				e.printStackTrace();
			}

		}

		public void deleteEmployee() {
			try {
				System.out.print("Please enter the id: ");
				String id = scanner.nextLine();
				if (service.findEmployee(Integer.parseInt(id))) {
					Employee recordEmployee = service.searchEmployeeByID(Integer.parseInt(id));

					if (recordEmployee.getId() <= 0) {
						System.out.println("Record does not exists for ID: " + Integer.parseInt(id));
					} else {
						boolean status = service.removeEmployee(Integer.parseInt(id));
						if (!status) {
							System.out.println("Deletion Error");
						} else {
							System.out.println("Deleted data Successfully");
						}
					}
				} else {
					System.out.println("Employee Details Not Found In The Database For ID " + Integer.parseInt(id));
				}

			} catch (Exception e) {
				System.out.println("Error found in deletion" + e);
			}

		}

		public void searchEmployee() {
			try {
				System.out.print("Please enter the id: ");
				String id = scanner.nextLine();
				int integerID = Integer.parseInt(id);
				Employee recordEmployee = service.searchEmployeeByID(integerID);

				if (recordEmployee == null) {
					System.out.println("Record does not exists for ID: " + integerID);
				} else {
					System.out.println("Employee Id: " + recordEmployee.getId() + ", Employee Name: "
							+ recordEmployee.getName() + ", Employee age: " + recordEmployee.getAge()
							+ ", Employee Address: " + recordEmployee.getAddress());

				}
			} catch (Exception e) {
				System.out.println("Error in Search");

			}

		}

		public void showEmployee() {
			service.getAllEmployees();

		}

		public void displayMenu() {
			System.out.println("Type\n" + "Enter 0 to exit\n" + "Enter 1 to add employee details\n"
					+ "Enter 2 to show employee details\n" + "Enter 3 to update details\n"
					+ "Enter 4 to remove employee details\n" + "Enter 5 to search employee details by id\n"
					+ "Enter 6 to show options");
		}

		private void updateName() {
			long employeeID = 0;
			System.out.print("Please Enter the Employee Id to Update : ");
			String id = scanner.nextLine();
			try {
				employeeID = Long.parseLong(id);
			} catch (Exception e) {
				System.out.println("Please Enter Number Input");
			}
			if (service.findEmployee(employeeID)) {
				System.out.print("Please Enter updated name : ");
				String name = scanner.nextLine();
				boolean status = service.updateEmployeeName(name, employeeID);
				if (status) {
					System.out.println("Employee name updated for " + employeeID);
				} else {
					System.out.println("Cannot Update Employee Name");
				}

			} else {
				System.out.println("No Data Exist For ID " + employeeID);
			}

		}

		private void updateAge() {
			long employeeID = 0;
			int intAge = 0;
			System.out.print("\nEnter updated age :- ");
			String age = scanner.nextLine();
			try {
				intAge = Integer.parseInt(age);
			} catch (Exception e) {
				System.out.println("Please Enter Valid Age");
			}
			System.out.print("Please Enter the Employee Id to Update : ");
			String id = scanner.nextLine();
			try {
				employeeID = Long.parseLong(id);
			} catch (Exception e) {
				System.out.println("Please Enter Number Input");
			}
			if (service.findEmployee(employeeID)) {
				boolean status = service.updateEmployeeAge(intAge, employeeID);
				if (status) {
					System.out.println("Employee name updated for " + employeeID);
				} else {
					System.out.println("Cannot Update Age");
				}
			} else {
				System.out.println("No Data Exist For ID " + employeeID);
			}

		}

		private void updateAddress() {
			long employeeID = 0;
			System.out.print("\nEnter updated address :- ");
			String address = scanner.nextLine();
			System.out.print("Please Enter the Employee Id to Update : ");
			String id = scanner.nextLine();
			try {
				employeeID = Long.parseLong(id);
			} catch (Exception e) {
				System.out.println("Please Enter Number Input");
			}
			if (service.findEmployee(employeeID)) {
				boolean status = service.updateEmployeeAddress(address, employeeID);
				if (status) {
					System.out.println("Employee name updated for " + employeeID);
				} else {
					System.out.println("Error...Can Not Update Address ");
				}
			} else {
				System.out.println("No Data Exist For ID " + employeeID);
			}

		}

		public void updateEmployee() {
			boolean flag = true;
			while (flag) {
				System.out.println("Select The Field You Want To Update\n");
				System.out.println("Press 1 To Update Name\n" + "Press 2 To Update Age\n" + "Press 3 To Update Address\n"
						+ "Press 0 To Go Back In Main Menu\n");
				System.out.print("\nPress: ");
				String Choice = scanner.nextLine();
				System.out.println("You entered the choice " + Choice);
				int intChoice;
				try {
					intChoice = Integer.parseInt(Choice);

					switch (intChoice) {
					case 1:
						updateName();
						break;
					case 2:
						updateAge();
						break;
					case 3:
						updateAddress();
					case 0:
						flag = false;
						break;
					default:
						break;
					}
				} catch (Exception ex) {
					System.out.println("Print correct input." + "\nTo go Back Enter 1"
							+ "\n Enter 0 To Go Back To Main Menu");
					System.out.println("\nPress: ");
					Choice = scanner.nextLine();
					int newIntChoice;
					try {
						newIntChoice = Integer.parseInt(Choice);
						switch (newIntChoice) {
						case 1:
							flag = true;
							break;
						case 0:
							flag = false;
							break;
						default:
							flag = false;
							break;
						}
					} catch (Exception exp) {
						flag = false;
					}

				}
			}
		}
	}


