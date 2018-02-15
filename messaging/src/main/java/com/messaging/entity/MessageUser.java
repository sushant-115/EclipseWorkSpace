package com.messaging.entity;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Message_Table")
public class MessageUser {
    @Id
    @GeneratedValue
	private Integer id;
	private String senderUname;
	private String uName;
	private String message;
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenderUname() {
		return senderUname;
	}
	public void setSenderUname(String senderUname) {
		this.senderUname = senderUname;
	}
	
}
