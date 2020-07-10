package database;

import professors.ProfessorsDAO;
import students.StudentsDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println(Database.CON);
		SqlVO vo=new SqlVO();
		vo.setKey("sname");
		vo.setWord("");
		vo.setOrder("sname");
		vo.setDesc("");
		vo.setPage(1);
		vo.setPerPage(9);
		
		StudentsDAO sdao=new StudentsDAO();
		System.out.println(sdao.list(vo));
	}

}
