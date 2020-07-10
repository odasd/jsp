package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pinfo-result")//서블릿을 사용하는 이유:결과출력만 html에서 하고, db에 관련된 것들은 서블릿에서 하기 위해 사용하였다.
public class PInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String gender=request.getParameter("gender");
		String iNotice=request.getParameter("iNotice");
		String cNotice=request.getParameter("cNotice");
		String dNotice=request.getParameter("dNotice");
		String job=request.getParameter("job");
		
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.printf("이름: %s <br>", name);
		out.printf("아이디: %s <br>", id);
		out.printf("암호: %s <br>", pwd);
		
		if(gender.equals("m")) {
			out.print("성별 : 남 <br>");
		}else {
			out.print("성별 : 여 <br>");
		}
		
		if(iNotice.equals("on")) {
			out.print("공지 메일 : 받음 <br>");
		}else {
			out.print("공지 메일 : 받지않음 <br>");
		}
		
		if(cNotice == null) {
			out.print("광고 메일 : 받지않음 <br>");
		}else {
			out.print("광고 메일 : 받음 <br>");
		}
		
		if(dNotice == null) {
			out.print("배송 메일 : 받지않음 <br>");
		}else {
			out.print("배송 메일 : 받음 <br>");
		}
		
		out.printf("직업: %s <br>", job);
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
