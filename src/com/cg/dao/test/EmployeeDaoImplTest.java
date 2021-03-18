/** This package contains code to perform unit testing. */

package com.cg.dao.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDaoImpl;

class EmployeeDaoImplTest {

private static EmployeeDaoImpl empDao = new EmployeeDaoImpl();
private static Employee emp = new Employee();
	
    @BeforeAll
	static void setUpBeforeClass() throws Exception {
    	System.out.println("before all");
    }

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("after all");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("after each");
	}

	/* testAddEmployee() method test the addition of employee details to Hashmap*/
	@Test
	void testAddEmployee() {
		System.out.println("test case add employee");  
		emp.setId(1234);
		emp.setSalary(5000.50f);
		emp.setName("Prabhat Bhatia");
		empDao.addEmployee(emp);
		Employee saved = empDao.viewEmployee(emp.getId());
		assertEquals(emp,saved);
	}
	
	/* testDeleteEmployee() method test the deletion of particular employee details from Hashmap*/
	@Test
	void testDeleteEmployee() {
		System.out.println("test case delete employee");
		emp.setId(1005);
		emp.setSalary(55000);
		emp.setName("Arjun Verma");
		empDao.addEmployee(emp);
		empDao.deleteEmployee(emp.getId());
		Employee saved = empDao.viewEmployee(emp.getId());
		assertEquals(emp,saved);
	}
}
	

	


