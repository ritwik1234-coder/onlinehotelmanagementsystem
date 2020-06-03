package com.capgemini.hotelbooking.bean;

import java.io.Serializable;

/**
 * 
 * This is a bean class which contains Employee Details having Private Variables
 * 
 * We Used Getter And Setter Methods TO Get And Set The Variables
 *
 */
public class Employee implements Serializable {
	private static final long serialVersionUID = 2924351745624908284L;

	public Employee() {

	}

	private String userName;

	private String name;

	private Long phoneNumber;

	private String emailId;

	private String password;

	private int salary;

	/**
	 * This Method Is Used To Get UserName
	 * 
	 * @return userName
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * This Method Is Used To Set UserName
	 * 
	 * @param userName
	 */

	public void setUserName(String username) {
		this.userName = username;
	}

	/**
	 * This Method Is Used To Get Name
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * This Method Is Used To Set Name
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This Method Is Used To Get PhoneNumber
	 * 
	 * @return phonenumber
	 */

	public Long getPhonenumber() {
		return phoneNumber;
	}

	/**
	 * This Method Is Used To Set PhoneNumber
	 * 
	 * @param phonenumber
	 */

	public void setPhonenumber(Long phonenumber) {
		this.phoneNumber = phonenumber;
	}

	/**
	 * This Method Is Used To Get EmailId
	 * 
	 * @return emailId
	 */

	public String getEmailid() {
		return emailId;
	}

	/**
	 * This Method Is Used To Set EmailId
	 * 
	 * @param emailId
	 */

	public void setEmailid(String emailid) {
		this.emailId = emailid;
	}

	/**
	 * This Method Is Used To Get Password
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * This Method Is Used To Set Password
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This Method Is Used To Get Salary
	 * 
	 * @return salary
	 */

	public int getSalary() {
		return salary;
	}

	/**
	 * This Method Is Used To Set Salary
	 * 
	 * @param salary
	 */

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + salary;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (salary != other.salary)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "username=" + userName + "\n name=" + name + "\n phonenumber=" + phoneNumber + "\n mailid="
				+ emailId + "\n password=" + password + "\n salary=" + salary + "\n";
	}

}
