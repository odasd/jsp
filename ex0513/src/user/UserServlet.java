package user;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value= {"/user/list", "/user/insert", "/user/delete", "/user/update"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=null; //�����͸� ���������� �����ĸ� ���, �����͸� �������� ��������  ���� ����Ʈ
		UserDAO dao=new UserDAO();
		
		switch(request.getServletPath()) { //������Ʈ�� �ִ� ���� ���
		case "/user/update":
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			try {
				dao.update(id,uname);
				response.sendRedirect("list");
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
			
		case "/user/delete":
			id=request.getParameter("id");
			try {
				dao.delete(id);
				response.sendRedirect("list");
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
			
		case "/user/list":
			try {
				ArrayList<UserVO> list=dao.list();
				request.setAttribute("list", list);
			}catch(Exception e){
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
			//requestDispatcher�� forward�� ��Ʈ�̹Ƿ� �� �Բ� ������־�� �Ѵ�.
			break;
			
		case "/user/insert":
			dis=request.getRequestDispatcher("insert.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		switch(request.getServletPath()) {
		case "/user/insert":
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String uname=request.getParameter("uname");
			
			UserVO vo=new UserVO();
			vo.setId(id);
			vo.setPass(pass);
			vo.setUname(uname);
			
			UserDAO dao=new UserDAO();
			try {
				dao.insert(vo);
				response.sendRedirect("list");
			}catch(Exception e){System.out.println(e.toString());}
			break;
		}
	}

}
