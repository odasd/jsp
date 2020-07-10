package enroll;

public class EVO {
	private String scode;
	private String sname;
	private String lcode;
	private String lname;
	private int grade;
	private String edate;
	
	
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
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	@Override
	public String toString() {
		return "EVO [scode=" + scode + ", sname=" + sname + ", lcode=" + lcode + ", lname=" + lname + ", grade=" + grade
				+ ", edate=" + edate + "]";
	}
	
	
}