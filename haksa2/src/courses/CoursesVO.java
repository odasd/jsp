package courses;

import professors.ProfessorVO;

public class CoursesVO extends ProfessorVO{
	
	
	private String lcode;
	private String lname;
	private int hours;
	private String room;
	private int capacity;
	private int persons;
	private String instructor;
	private String pname;
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
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Override
	public String toString() {
		return "CoursesVO [lcode=" + lcode + ", lname=" + lname + ", hours=" + hours + ", room=" + room + ", capacity="
				+ capacity + ", persons=" + persons + ", instructor=" + instructor + ", pname=" + pname
				+ ", getLcode()=" + getLcode() + ", getLname()=" + getLname() + ", getHours()=" + getHours()
				+ ", getRoom()=" + getRoom() + ", getCapacity()=" + getCapacity() + ", getPersons()=" + getPersons()
				+ ", getInstructor()=" + getInstructor() + ", getPname()=" + getPname() + ", getPcode()=" + getPcode()
				+ ", getDept()=" + getDept() + ", getHirdate()=" + getHirdate() + ", getTitle()=" + getTitle()
				+ ", getSalary()=" + getSalary() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
