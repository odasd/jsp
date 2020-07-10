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
		RequestDispatcher dis=null; //데이터를 가져갈때는 디스패쳐를 사용, 데이터를 가져오지 않을때는  센드 리디렉트
		UserDAO dao=new UserDAO();
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String uname=request.getParameter("uname");
		switch(request.getServletPath()) { //리퀘스트에 있는 서블릿 경로
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
			//requestDispatcher랑 forward는 셋트이므로 꼭 함께 사용해주어야 한다.
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
