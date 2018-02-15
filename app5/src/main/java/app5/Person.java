package app5;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="PERSON_DETAILS")
public class Person {
	@Id
	@GeneratedValue
	@Column(name="PERSON_ID")
	private Integer personId;
	@Column(name="PERSON_NAME")
	private String personName;
	@Temporal(value = TemporalType.DATE)
	@Column(name="PERSON_DOB")
	private Date personDOB;
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
	private Passport passport;
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Date getPersonDOB() {
		return personDOB;
	}
	public void setPersonDOB(Date personDOB) {
		this.personDOB = personDOB;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
}
