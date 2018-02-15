package com.hibernate.apps1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Products {
	@Id
	@GeneratedValue
	@Column
	private int s_no;
	@Column
	private String s_Name;
	@Column 
	private int s_Age;
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_Name() {
		return s_Name;
	}
	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}
	public int getS_Age() {
		return s_Age;
	}
	public void setS_Age(int s_Age) {
		this.s_Age = s_Age;
	}
	@Override
	public String toString() {
		return "Products [s_no=" + s_no + ", s_Name=" + s_Name + ", s_Age="
				+ s_Age + "]";
	}
}
