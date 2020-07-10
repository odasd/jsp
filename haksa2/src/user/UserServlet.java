package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


@WebServlet(value= {"/user/login","/user/logout"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getServletPath()) {
		
		case "/user/logout" :
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		UserDAO udao=new UserDAO();
		PrintWriter out=response.getWriter();
		
		switch(request.getServletPath()) {
		
		case "/user/login" :
			UserVO vo=udao.login(id);
			int check=0; //아이디가 없는경우
			if(vo.getId()!=null) { 
				if(vo.getPass().equals(pass)) {
					check=2; //id, pass가 일치하는 경우
					HttpSession session=request.getSession();
					session.setAttribute("id", vo.getId());
					session.setAttribute("name", vo.getName());
				} else {
					check=1; //id 있으나 pass가 일치하는 않는경우
				}
			} 
			JSONObject jObject=new JSONObject();
			jObject.put("check", check);
			out.println(jObject);
			System.out.println("check : " + check);
			break;
		}
		
	}

}
