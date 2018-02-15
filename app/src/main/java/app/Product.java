package app;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@GenericGenerator(name = "P_GEN", strategy = "app.ProductsIdGenerator")
	@GeneratedValue(generator="P_GEN")
	
	
	@Column
	private String p_no;
	@Column
	private String p_name;
	@Column
	private double p_price;
	public String getP_no() {
		return p_no;
	}
		public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getP_price() {
		return p_price;
	}
	public void setP_price(double p_price) {
		this.p_price = p_price;
	}
	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_price="
				+ p_price + "]";
	}

}
