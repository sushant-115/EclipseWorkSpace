package app1;

import javax.persistence.*;

@Entity
@Table(name="USER_DETAILS_2")
public class User {
@Id
@GeneratedValue
@Column(name="USER_NO")
	private Integer user_id;
@Column(name="USER_NAME")
private String uName;
@Column(name="USER_PWD")
private String pwd;
public Integer getUid() {
	return user_id;
}
public void setUid(Integer uid) {
	this.user_id = uid;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}

}
