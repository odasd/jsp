package courses;

public class CVO {
	   private String lcode;
	   private String lname;
	   private int hours;
	   private String room;
	   private String instructor;
	   private int capacity;
	   private int persons;
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
	   public String getInstructor() {
	      return instructor;
	   }
	   public void setInstructor(String instructor) {
	      this.instructor = instructor;
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
	   public String getPname() {
	      return pname;
	   }
	   public void setPname(String pname) {
	      this.pname = pname;
	   }
	   @Override
	   public String toString() {
	      return "CVO [lcode=" + lcode + ", lname=" + lname + ", hours=" + hours + ", room=" + room + ", instructor="
	            + instructor + ", capacity=" + capacity + ", persons=" + persons + ", pname=" + pname + ", getLcode()="
	            + getLcode() + ", getLname()=" + getLname() + ", getHours()=" + getHours() + ", getRoom()=" + getRoom()
	            + ", getInstructor()=" + getInstructor() + ", getCapacity()=" + getCapacity() + ", getPersons()="
	            + getPersons() + ", getPname()=" + getPname() + ", getClass()=" + getClass() + ", hashCode()="
	            + hashCode() + ", toString()=" + super.toString() + "]";
	   }
	   
	}