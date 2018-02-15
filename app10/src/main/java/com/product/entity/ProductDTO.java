package com.product.entity;

import java.util.Arrays;

import javax.persistence.Lob;

public class ProductDTO {
	private Integer pid;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private String pName;
	private Double pPrice;
	private Integer quan;
	@Lob
	private byte[] photo;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Double getpPrice() {
		return pPrice;
	}
	public void setpPrice(Double pPrice) {
		this.pPrice = pPrice;
	}
	public Integer getQuan() {
		return quan;
	}
	public void setQuan(Integer quan) {
		this.quan = quan;
	}
	@Override
	public String toString() {
		return "ProductDTO [pName=" + pName + ", pPrice=" + pPrice + ", quan="
				+ quan + ", photo=" + Arrays.toString(photo) + "]";
	}
	
	

}
