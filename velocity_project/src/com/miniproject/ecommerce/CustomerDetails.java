package com.miniproject.ecommerce;
public class CustomerDetails {

	private String firstName;
	private String userName;
	private String password;
	private String address;
	private long phoneNo;
	
	public String getfirstName(String firstName)
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	  
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public long getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) 
	{
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", userName=" + userName + ", password="
				+ password + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}	
}

