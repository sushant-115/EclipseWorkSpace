package app7;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class Student {
@Id
@GeneratedValue
@Column(name="STUDENT_ID")
	private Integer sId;
private String sName;
private Integer sMobile;
@ManyToOne(cascade=CascadeType.ALL)
private Address addr;
public Integer getsId() {
	return sId;
}
public void setsId(Integer sId) {
	this.sId = sId;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public Integer getsMobile() {
	return sMobile;
}
public void setsMobile(Integer sMobile) {
	this.sMobile = sMobile;
}
public Address getAddr() {
	return addr;
}
public void setAddr(Address addr) {
	this.addr = addr;
}
@Override
public String toString() {
	return "Student [sId=" + sId + ", sName=" + sName + ", sMobile=" + sMobile
			+ ", addr=" + addr + "]";
}

}
