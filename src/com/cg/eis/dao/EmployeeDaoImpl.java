package com.cg.eis.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.eis.bean.Employee;

public  class EmployeeDaoImpl implements IEmployeeDao {

private static Map<Integer,Employee> employees;
	
	public EmployeeDaoImpl() {
		if(null==employees) {
			employees=new HashMap<>();
		}
	}
	
	/** The addEmployee(Employee employee) method perform the addition of employee details to Hashmap.*/
	@Override
	public void addEmployee(Employee employee) {
		
		employees.put(employee.getId(), employee);
	}

	/** The viewEmployee(int employeeId) method returns particular employee details based on employee ID parameter.*/
	@Override
	public Employee viewEmployee(int employeeId) {
		return employees.get(employeeId);
		}

	/** The viewAllEmployees() method returns list of employee details. */
	@Override
	public List<Employee> viewAllEmployees() {
		ArrayList<Employee> list = new ArrayList<>();
        Collection<Employee> employeeList = employees.values();
        for (Employee c : employeeList) {
			list.add(c);
		}
        return list;
	}
	
	/** The deleteEmployee(int employeeId) method perform the deletion of particular employee details from Hashmap 
	 *  based on employee ID parameter.*/
	@Override
	public void deleteEmployee(int employeeId) {
		employees.remove(employeeId);
		}
	}
