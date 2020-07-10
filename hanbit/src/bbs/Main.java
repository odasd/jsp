package bbs;

import book.BookDAO;
import user.UserDAO;

public class Main {

	public static void main(String[] args) {
		BBSDAO dao=new BBSDAO();
		//System.out.println(dao.list("title", "입장", 1,5));
		
		BookDAO bdao=new BookDAO();
		//System.out.println(bdao.list("title", "자바", 1,3));
		
		UserDAO udao=new UserDAO();
		//System.out.println(udao.list("id", "s", 1,3));
	}

}
