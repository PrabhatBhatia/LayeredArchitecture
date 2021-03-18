/** This package contain code for services offered in Employee Insurance System. 
 *  The service class will have one EmployeeService Interface and its corresponding implementation class. */

package com.cg.eis.service;

import java.util.List;
import com.cg.eis.bean.Employee;


public interface IEmployeeService {

	boolean addEmployee(Employee employee);
	
	Employee viewEmployee(int employId);
	
	boolean deleteEmployee(int employId);
	
	List <Employee> viewAllEmployees();

	
}
