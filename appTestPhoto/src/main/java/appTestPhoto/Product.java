package appTestPhoto;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT_PHOTO")
public class Product {
@Id
@GeneratedValue
@Column(name="PRODUCT_ID")
	private Integer pid;
@Lob
	private byte[] photo;
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public byte[] getPhoto() {
	return photo;
}
public void setPhoto(byte[] photo) {
	this.photo = photo;
}
}
