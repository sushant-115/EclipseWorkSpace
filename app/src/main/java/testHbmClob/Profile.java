package testHbmClob;

import java.util.Arrays;

import javax.persistence.*;
@Entity
@Table(name="PROFILE_ADD")
public class Profile {
	@Id
	@Column(name="S_NO")
	private Integer sno;
	@Column(name="S_NAME")
	private String name;
	@Lob
	@Column(name="S_FILE")
	private char[] photo;
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char[] getPhoto() {
		return photo;
	}
	public void setPhoto(char[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Profile [sno=" + sno + ", name=" + name + ", photo="
				+ Arrays.toString(photo) + "]";
	}
	
	

}
