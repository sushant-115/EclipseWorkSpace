package app6;

import java.util.Set;

import javax.persistence.*;
@Entity
public class Product {
	@Id
	@GeneratedValue
	@Column(name="PRODUCT_ID")
private Integer pId;
private String pName;
private Double pPrice;
@OneToMany(cascade=CascadeType.ALL )
private Set<Store> store;

public Integer getpId() {
	return pId;
}

public void setpId(Integer pId) {
	this.pId = pId;
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

public Set<Store> getStore() {
	return store;
}

public void setStore(Set<Store> store) {
	this.store = store;
}

@Override
public String toString() {
	return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice
			+ ", store=" + store + "]";
}


}
