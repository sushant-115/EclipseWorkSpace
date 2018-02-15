package app7;

import javax.persistence.*;
@Entity
public class Address {
	@Id
	@GeneratedValue
	@Column(name="ADDR_ID")
	private Integer addId;
	private String city;
	private String state;
	private String country;
	
	
	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}
}
