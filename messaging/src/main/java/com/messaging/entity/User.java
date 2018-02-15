package com.messaging.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Messaging_User")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique=true)
	private String uname;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String mobile;
	private Date dob;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
