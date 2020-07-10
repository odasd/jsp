package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs-post")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	//�ѱ��� ������ �ʰ� �ϴ� ���
		request.setCharacterEncoding("UTF-8");	//request.getParameter�� ������ �ѱ��� ������ �ʰ� �ϴ� ���
		
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		request.setAttribute("n", name);
		request.setAttribute("t", title);
		request.setAttribute("c", content);
		
		Date date=new Date();
		Long time=date.getTime();
		String fileName=time + ".txt";
		String filePath="C:/temp/"+ fileName;
		PrintWriter writer=null;
		
		try {
			writer=new PrintWriter(filePath);
			writer.printf("�ۼ���: %s %n", name);
			writer.printf("����: %s %n", title);
			writer.printf("-----------------------------------%n");
			writer.print(content);
			writer.close();
			
			//response.sendRedirect("writeResult.jsp");	//response.sendRedirect�� ()��ȣ������ �̵��ϰڴ�. �ٵ��̰� request���� ����������.
			RequestDispatcher dis=request.getRequestDispatcher("writeResult.jsp");	//�̰͵� �̵��ϴ°ǵ� dispatcher�� request�� ���� ���� ���δ� ������ �� �ִ�.
			dis.forward(request, response);
			
		}catch(Exception e){System.out.println(e.toString());}
		
		/*
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.printf("�̸�: %s <br>", name);
		out.printf("����: %s <br>", title);
		out.print("----------------------------<br>");
		out.printf("%s <br>", content);
		out.print("----------------------------<br>");
		out.print("</body>");
		out.print("</html>");
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	//�ѱ��� ������ �ʰ� �ϴ� ���
		request.setCharacterEncoding("UTF-8");	//request.getParameter�� ������ �ѱ��� ������ �ʰ� �ϴ� ���
		
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("�̸�: " + name + "<br>");
		out.print("����: " + title + "<br>");
		out.print("----------------------------<br>");
		out.print(content + "<br>");
		out.print("----------------------------<br>");
		out.print("</body>");
		out.print("</html>");
	}
}
