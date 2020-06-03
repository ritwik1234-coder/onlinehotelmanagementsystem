package com.capgemini.hotelbooking.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelbooking.bean.Employee;
import com.capgemini.hotelbooking.factory.Factory;
/**
 * This class contains the registration detail of employee 
 * 
 * @author Ritwik
 *
 */
public class EmployeeRepository {
	public List<Employee> getEmployeeInformationList() {
	List<Employee> employeelist = new ArrayList<Employee>();


		Employee employeeinfo = Factory.getEmployeeInstance();
		employeeinfo.setUserName("amit");
		employeeinfo.setName("Amit Yadav");
		employeeinfo.setPhonenumber(9039285096l);
		employeeinfo.setEmailid("amit@gmail.com");
		employeeinfo.setPassword("Amit@567");
		employeeinfo.setSalary(15000);

		employeelist.add(employeeinfo);

		return employeelist;

	}

}

