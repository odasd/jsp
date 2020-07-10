package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pinfo-result")//������ ����ϴ� ����:�����¸� html���� �ϰ�, db�� ���õ� �͵��� �������� �ϱ� ���� ����Ͽ���.
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
		out.printf("�̸�: %s <br>", name);
		out.printf("���̵�: %s <br>", id);
		out.printf("��ȣ: %s <br>", pwd);
		
		if(gender.equals("m")) {
			out.print("���� : �� <br>");
		}else {
			out.print("���� : �� <br>");
		}
		
		if(iNotice.equals("on")) {
			out.print("���� ���� : ���� <br>");
		}else {
			out.print("���� ���� : �������� <br>");
		}
		
		if(cNotice == null) {
			out.print("���� ���� : �������� <br>");
		}else {
			out.print("���� ���� : ���� <br>");
		}
		
		if(dNotice == null) {
			out.print("��� ���� : �������� <br>");
		}else {
			out.print("��� ���� : ���� <br>");
		}
		
		out.printf("����: %s <br>", job);
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
