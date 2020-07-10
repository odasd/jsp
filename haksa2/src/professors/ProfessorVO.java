package professors;

import java.sql.Date;

public class ProfessorVO {
	private String pcode;
	private String pname;
	private String dept;
	private Date hirdate;
	private String title;
	private int salary;
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Date getHirdate() {
		return hirdate;
	}
	public void setHirdate(Date hirdate) {
		this.hirdate = hirdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "ProfessorVO [pcode=" + pcode + ", pname=" + pname + ", dept=" + dept + ", hirdate=" + hirdate
				+ ", title=" + title + ", salary=" + salary + ", getPcode()=" + getPcode() + ", getPname()="
				+ getPname() + ", getDept()=" + getDept() + ", getHirdate()=" + getHirdate() + ", getTitle()="
				+ getTitle() + ", getSalary()=" + getSalary() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
