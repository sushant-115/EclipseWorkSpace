package app6;

import javax.persistence.*;

@Entity
public class Store {
	@Id
	@GeneratedValue
	@Column(name="STORE_ID")
	private Integer storeId;
	private String storeName;
	private String storeAddr;
	@ManyToOne
	private Product product;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddr() {
		return storeAddr;
	}

	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
