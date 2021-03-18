/** This package contains “Employee” class with different attributes such as 
 *  id, name, salary, designation and insuranceScheme. */

package com.cg.eis.bean;

public class Employee {
	
	private int id;
	private String name;
	private float salary;
	private String designation;
	private String insuranceScheme;


public Employee() {
	}

public Employee(int id, String name, float salary, String designation, String insuranceScheme) {
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.designation = designation;
	this.insuranceScheme = insuranceScheme;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public float getSalary() {
	return salary;
}

public void setSalary(float salary) {
	this.salary = salary;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getInsuranceScheme() {
	return insuranceScheme;
}

public void setInsuranceScheme(String insuranceScheme) {
	this.insuranceScheme = insuranceScheme;
}

@Override
public String toString() {
	return "Employee Details [ID= " + getId() + ", Name= " + getName() + ", Salary= " + getSalary()
			+ ", Designation= " + getDesignation() + ", Insurance Scheme= " + getInsuranceScheme() + "]";
}
}
