package com.capgemini.hotelbooking.bean;

import java.io.Serializable;

/**
 * 
 * This is a bean class which contains Customer Details having Private Variables
 * 
 * We Used Getter And Setter Methods TO Get And Set The Variables
 */

public class Customer implements Serializable {
	private static final long serialVersionUID = -1822380282624768291L;

	public Customer() {

	}

	private String userName;

	private String name;

	private long phoneNumber;

	private String emailId;

	private String password;

	/**
	 * This Method Is Used To Get UserName
	 * 
	 * @return userName
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * This Method Is Used To Get UserName
	 * 
	 * @param userName
	 */

	public void setUserName(String UserName) {
		userName = UserName;
	}

	/**
	 * This Method Is Used To Get Name
	 * 
	 * @return getname
	 */

	public String getName() {
		return name;
	}

	/**
	 * This Method Is Used To Set Name
	 * 
	 * @param Name
	 */

	public void setName(String Name) {
		name = Name;
	}

	/**
	 * This Method Is Used To Get PhoneNumber
	 * 
	 * @return phonenumber
	 */

	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This Method Is Used To Set Phonenumber
	 * 
	 * @param phoneNumber
	 */

	public void setPhoneNumber(long PhoneNumber) {
		phoneNumber = PhoneNumber;
	}

	/**
	 * This Method Is Used To Get EmailId
	 * 
	 * @return emailId
	 */

	public String getEmailId() {
		return emailId;
	}

	/**
	 * This Method Is Used To Set EmailId
	 * 
	 * @param emailId
	 */

	public void setEmailId(String emailid) {
		emailId = emailid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Customer other = (Customer) obj;
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
		if (phoneNumber != other.phoneNumber)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " Name=" + name + "\n PhoneNumber=" + phoneNumber + "\n MailId=" + emailId + "\n";
	}

}
