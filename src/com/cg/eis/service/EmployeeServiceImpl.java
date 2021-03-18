package com.cg.eis.service;

import java.util.List;
import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDaoImpl;
import com.cg.eis.dao.IEmployeeDao;


public class EmployeeServiceImpl implements IEmployeeService {
	
	private static IEmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		if(null==employeeDao) {
			employeeDao=new EmployeeDaoImpl();
		}
	}
	
	/** The addEmployee(Employee employee) method perform the addition of employee details to Hashmap
	 *  and returns true if employee is added is successfully.*/
	@Override
	public boolean addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		Employee savedEmploy = employeeDao.viewEmployee(employee.getId());

		if (savedEmploy != null)
			return true;
		else
			return false;

	}
	
	/** The viewEmployee(int employeeId) method returns particular employee details based on employee ID parameter.*/
	@Override
	public Employee viewEmployee(int employeeId) {
		return employeeDao.viewEmployee(employeeId);
		}

	/** The viewAllEmployees() method returns list of employee details. */
	@Override
	public List<Employee> viewAllEmployees() {
		return employeeDao.viewAllEmployees();
	}

	/** The deleteEmployee(int employeeId) method perform the deletion of particular employee details from Hashmap
	 *  and returns true if employee is deleted is successfully.*/
	@Override
	public boolean deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
		Employee savedEmploy = employeeDao.viewEmployee(employeeId);
        if (savedEmploy == null)
			return true;
		else
			return false;

	}
}
