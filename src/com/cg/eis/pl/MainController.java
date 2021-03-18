/* Lab 7: Layered Architecture 
   Use Case Study: Employee Medical Insurance Scheme: */

/** This package contain code for getting input from user, produce expected output to the user 
 *  and invoke services offered by the system. */

package com.cg.eis.pl;

import java.util.List;
import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceImpl;
import com.cg.exception.InsuranceSchemeNotAssigned;
import com.cg.util.InputUtil;


public class MainController {
	
    private static EmployeeServiceImpl employeeService;
	
	public MainController() {
		if(null==employeeService) {
			employeeService=new EmployeeServiceImpl();
		}
	}
	
	void operation() {
		Scanner sc=InputUtil.getScanner();                 
		boolean flag=true;
		while(flag) {
		System.out.println("Enter your choice:"
				+"\n 1. Add an employee details."
				+"\n 2. Find the eligible insurance scheme specific to an employee based on salary."
				+"\n 3. Delete an employee details."
				+"\n 4. View details of all employees."
				+"\n 5. Exit");
		
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		
		case 1:
			System.out.println("Enter ID and Name of employee");
			int id=Integer.parseInt(sc.nextLine());  
			String name=sc.nextLine();
			
			Employee e=new Employee();
			e.setId(id);
			e.setName(name);
			
			if(employeeService.addEmployee(e)) {
				System.out.println("Employee is added successfully");
			}
			else {
				System.out.println("Try again. Not able to add employee.");
			}
			break;
		
		case 2:
			System.out.println("Enter salary to assign insurance scheme:");
			float sal=Float.parseFloat(sc.nextLine());
			System.out.println("Enter employee ID to assign insurance scheme:");
			int employeeId=Integer.parseInt(sc.nextLine());
		
			if(sal>5000 && sal<20000) {
				Employee emp=employeeService.viewEmployee(employeeId);
				emp.setId(employeeId);
				emp.setSalary(sal);
				emp.setInsuranceScheme("Scheme C");
				emp.setDesignation("System associate");
				System.out.println(emp);
				break;
			}
			
			else if(sal>=20000 && sal<40000) {
				Employee emp=employeeService.viewEmployee(employeeId);
				emp.setId(employeeId);
				emp.setSalary(sal);
				emp.setInsuranceScheme("Scheme B");
				emp.setDesignation("Programmer");
				System.out.println(emp);
				break;
				}
			
			else if(sal>=40000) {
				Employee emp=employeeService.viewEmployee(employeeId);
				emp.setId(employeeId);
				emp.setSalary(sal);
				emp.setInsuranceScheme("Scheme A");
				emp.setDesignation("Manager");
				System.out.println(emp);
				break;
			}
			
			else if(sal<5000) {
				Employee emp=employeeService.viewEmployee(employeeId);
				emp.setId(employeeId);
				emp.setSalary(sal);
				emp.setInsuranceScheme("Salary too less for any insurance scheme");
				emp.setDesignation("Clerk");
				System.out.println(emp);
				break;
			}
			break;
				
		case 3:
			System.out.println("Enter ID of employee");
			id=Integer.parseInt(sc.nextLine());
			if(employeeService.deleteEmployee(id)) {
				System.out.println("Employee is deleted successfully");
			}
			else {
				System.out.println("Try again. Not able to delete employee.");
			}
			break;
		
		case 4:
			try {
			     List<Employee> allEmployees= employeeService.viewAllEmployees();
				for (Employee emp1:allEmployees) {
				if(emp1.getInsuranceScheme().isEmpty()) {
					throw new InsuranceSchemeNotAssigned("First find the eligible insurance scheme specific to an employee based on salary.");  }
				else {
				System.out.println(emp1); }
			}  
				}
			catch(InsuranceSchemeNotAssigned exception) {
				exception.getMessage();
				} 
			break;
			
		case 5:
			System.out.println("-----------EXIT------------");
			System.out.println("Exiting From The System \nThankyou.");
			flag=false;
			break;
		
		default:
			System.out.println("Try again. Invalid choice entered.");
			break;
		}
	}
}
			
	public static void main(String[] args)  {
    MainController mc=new MainController();
    mc.operation(); 
    }

}
