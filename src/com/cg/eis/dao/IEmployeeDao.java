/** This package contain code for domain objects in Employee Insurance System. 
 *  The dao class will have one EmployeeDao Interface and its corresponding implementation class. */


package com.cg.eis.dao;

import java.util.List;
import com.cg.eis.bean.Employee;

public interface IEmployeeDao {

	void addEmployee(Employee employee);
	
	Employee viewEmployee(int employId);
	
	void deleteEmployee(int employId);
	
	List<Employee> viewAllEmployees();
}
