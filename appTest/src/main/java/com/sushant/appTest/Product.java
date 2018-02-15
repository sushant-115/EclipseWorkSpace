package com.sushant.appTest;

import javax.persistence.*;

@Entity
@Table(name="product_photo")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="PRODUCT_ID")
private Integer pid;
	@Lob
	@Column(name="PHOTO")
private byte[] photo;
}
