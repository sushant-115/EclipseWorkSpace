package com.product.entity;

import javax.persistence.*;

@Entity
@Table
public class VideoProfile {
	@Id
	@GeneratedValue
private Integer vid;
private String vName;
@Lob
private byte[] video;
public Integer getVid() {
	return vid;
}
public void setVid(Integer vid) {
	this.vid = vid;
}
public String getvName() {
	return vName;
}
public void setvName(String vName) {
	this.vName = vName;
}
public byte[] getVideo() {
	return video;
}
public void setVideo(byte[] video) {
	this.video = video;
}

}
