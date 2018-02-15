package app5;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="PASSPORT_DETAILS")
public class Passport {
	@Id
	@GeneratedValue
	@Column(name="PASSPORT_NO")
	private Integer passportNo;
	@Column(name="PASSPORT_ID")
	private String passportId;
	@Column(name="ISSUED_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date issuedDate;
	@Temporal(value = TemporalType.DATE)
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	@OneToOne()
	@JoinColumn(name="PERSON_ID")
	private Person person;
	public Integer getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(Integer passportNo) {
		this.passportNo = passportNo;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

}
