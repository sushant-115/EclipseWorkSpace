package excel;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.*;
import javax.persistence.Table;
@Entity
@Table(name="PRODUCT_EXCEL")
public class Product {
	@Id
	private Double pid;
	private String pname;
	private Double price;
	public Double getPid() {
		return pid;
	}
	public void setPid(Double pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
