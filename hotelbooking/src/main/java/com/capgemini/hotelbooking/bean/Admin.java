package com.capgemini.hotelbooking.bean;

import java.io.Serializable;

/**
 * This is a bean class which contains Admin Details having Private Variable
 * 
 * We Used Getter And Setter Methods TO Get And Set The Variables
 *
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = 5973566112074489817L;

	public Admin() {

	}

	private String userName;

	private String password;

	/**
	 * This Method Is Used Get Admin User Name
	 * 
	 * 
	 * @return username
	 */
	public String getUsername() {
		return userName;
	}

	/**
	 * 
	 * This Method Is Used To Set Admin UserName
	 * 
	 * @param username
	 */

	public void setUsername(String username) {
		this.userName = username;
	}

	/**
	 * 
	 * This Methos Is Used To Get Admin Password
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * This Method Is Used To set Admin Password
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Admin other = (Admin) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
}