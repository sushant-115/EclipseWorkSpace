package com.product.entity;

import javax.persistence.*;

@Entity
@Table(name="Product_M")
public class ProductEntity{
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private Integer pid;
	@Column(name="NAME")
	private String pName;
	@Column(name="PRICE")
	private Double pPrice;
	@Column(name="QUANTITY")
	private Integer quan;
	@Lob
	@Column(name="PHOTO")
	private byte[] photo;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
		return "ProductEntity [pid=" + pid + ", pName=" + pName + ", pPrice="
				+ pPrice + ", quan=" + quan + "]";
	}

}
