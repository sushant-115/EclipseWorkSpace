package csv;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE_DETAILS3")
public class Employee {
@Id
@Column(name="EMP_ID")
	private Integer empId;
@Column(name="EMP_NAME")
private String empName;
@Column(name="SAL")
private Double sal;
@Column(name="DEPT")
private Integer dept;
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Double getSal() {
	return sal;
}
public void setSal(Double sal) {
	this.sal = sal;
}
public Integer getDept() {
	return dept;
}
public void setDept(Integer dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", sal=" + sal
			+ ", dept=" + dept + "]";
}

}
