package com.messaging.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="User_photo")
@DynamicUpdate
public class UserProfilePhoto {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(unique=true)
	private String uName;
@Lob
	private byte[] photo;
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public byte[] getPhoto() {
	return photo;
}
public void setPhoto(byte[] photo) {
	this.photo = photo;
}

}
