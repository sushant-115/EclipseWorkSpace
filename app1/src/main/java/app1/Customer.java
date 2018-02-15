package app1;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BANK_DB")
public class Customer {
	@Id
	@GenericGenerator(name = "CUST_gen", strategy = "app1.CustomerIdGenerator")
	@GeneratedValue(generator="CUST_gen")
	@Column(name="C_ID")
	private String c_id;
	@Column(name="C_NAME")
	private String c_name;
	@Column(name="C_ACCNO")
	private Integer c_accno;
	@Column(name="PIN_NO")
	private Integer pin_no;
	@Column(name="BALANCE")
	private Double balance;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Integer getC_accno() {
		return c_accno;
	}
	public void setC_accno(Integer c_accno) {
		this.c_accno = c_accno;
	}
	public Integer getPin_no() {
		return pin_no;
	}
	public void setPin_no(Integer pin_no) {
		this.pin_no = pin_no;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_accno="
				+ c_accno + ", pin_no=" + pin_no + ", balance=" + balance + "]";
	}
	

	

}
