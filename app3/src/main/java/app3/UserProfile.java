package app3;

import javax.persistence.*;

@Entity
@Table(name="USER_PROFILE")
public class UserProfile {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer uid;
	@Column(name="USER_NAME")
	private String uname;
	@Lob
	@Column(name="USER_IMAGE")
	private byte[] uImage;
	@Lob
	@Column(name="USER_RESUME")
	private char[] u_resume;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public byte[] getuImage() {
		return uImage;
	}
	public void setuImage(byte[] uImage) {
		this.uImage = uImage;
	}
	public char[] getU_resume() {
		return u_resume;
	}
	public void setU_resume(char[] u_resume) {
		this.u_resume = u_resume;
	}
	

}
