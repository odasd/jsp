package students;

import java.sql.Date;

import professors.ProfessorVO;

public class StudentsVO extends ProfessorVO {
	
	private String scode;
	private String sname;
	private String dept;
	private String year;
	private String advisor;
	private Date birthday;
	private String pname;
	
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "StudentsVO [scode=" + scode + ", sname=" + sname + ", dept=" + dept + ", year=" + year + ", advisor="
				+ advisor + ", birthday=" + birthday + ", pname=" + pname + ", getScode()=" + getScode()
				+ ", getSname()=" + getSname() + ", getDept()=" + getDept() + ", getYear()=" + getYear()
				+ ", getAdvisor()=" + getAdvisor() + ", getBirthday()=" + getBirthday() + ", getPname()=" + getPname()
				+ ", getPcode()=" + getPcode() + ", getHirdate()=" + getHirdate() + ", getTitle()=" + getTitle()
				+ ", getSalary()=" + getSalary() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
