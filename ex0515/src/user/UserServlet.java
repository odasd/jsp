package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet(value= {"/login", "/logout","/user/list", "/user/insert", "/user/delete", "/user/update"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=null; //�����͸� ���������� �����ĸ� ���, �����͸� �������� ��������  ���� ����Ʈ
		UserDAO dao=new UserDAO();
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String uname=request.getParameter("uname");
		switch(request.getServletPath()) { //������Ʈ�� �ִ� ���� ���
		case "/logout":
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("/login");
		break;
		case "/login":
			dis=request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		break;
		case "/user/update":
			id=request.getParameter("id");
			uname=request.getParameter("uname");
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String uname=request.getParameter("uname");
		UserVO vo=null;
		switch(request.getServletPath()) {
		case "/login":
			UserDAO udao=new UserDAO();
			try {
			vo=udao.loginCheck(id, pass);
			JSONObject jObject=new JSONObject();
			jObject.put("id", vo.getId());
			jObject.put("name", vo.getUname());
			PrintWriter out=response.getWriter();
			out.println(jObject);
			
			HttpSession session=request.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getUname());
			
			} catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		case "/user/insert":
			id=request.getParameter("id");
			pass=request.getParameter("pass");
			uname=request.getParameter("uname");
			
			vo=new UserVO();
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
