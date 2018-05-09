package com.hibernate.fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_new")
public class FetchStuDetail {
	
	@Id
	private int id;
	
	@Column(name="firstname")
	private String Fname;
	
	@Column(name="lastname")
	private String Lname;
	
	@Column(name="email")
	private String Email;
	
	@Column(name="addr")
	private String Address;
	
	//----------------------------//
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
