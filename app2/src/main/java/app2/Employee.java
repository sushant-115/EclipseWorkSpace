package app2;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EMP_dEtAILS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EMP_TYPE")
public class Employee {
	@Id
	@GenericGenerator(name = "EMP_GEN", strategy = "app2.EmployeeIdGenerator")
	@GeneratedValue(generator ="EMP_GEN")
	@Column(name="E_ID")
	private String e_id;
	@Column(name="E_NAME")
	private String e_name;
	@Column(name="P_ADDR")
	private String e_addr;
	@Column(name="E_SALARY")
	private Double e_sal;
	public Double getE_sal() {
		return e_sal;
	}
	public void setE_sal(Double e_sal) {
		this.e_sal = e_sal;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_addr() {
		return e_addr;
	}
	public void setE_addr(String e_addr) {
		this.e_addr = e_addr;
	}
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_addr="
				+ e_addr + ", e_sal=" + e_sal + "]";
	}
	
	
	

}
