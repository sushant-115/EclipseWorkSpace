package testHbmBlob;

import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name="EMP_DETAILS_WITH_PHOTO")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private Integer empId;
	@Column(name="EMP_NAME")
	private String name;
	@Lob
	@Column(name="EMP_PHOTO")
	private byte[] empPhoto;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getEmpPhoto() {
		return empPhoto;
	}
	public void setEmpPhoto(byte[] empPhoto) {
		this.empPhoto = empPhoto;
	}
	
	}

