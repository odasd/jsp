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
		response.setContentType("text/html;charset=UTF-8");	//한글이 깨지지 않게 하는 방법
		request.setCharacterEncoding("UTF-8");	//request.getParameter로 가져온 한글을 깨지지 않게 하는 방법
		
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
			writer.printf("작성자: %s %n", name);
			writer.printf("제목: %s %n", title);
			writer.printf("-----------------------------------%n");
			writer.print(content);
			writer.close();
			
			//response.sendRedirect("writeResult.jsp");	//response.sendRedirect는 ()괄호안으로 이동하겠다. 근데이건 request값을 못가져간다.
			RequestDispatcher dis=request.getRequestDispatcher("writeResult.jsp");	//이것도 이동하는건데 dispatcher는 request에 담은 값을 전부다 가져갈 수 있다.
			dis.forward(request, response);
			
		}catch(Exception e){System.out.println(e.toString());}
		
		/*
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.printf("이름: %s <br>", name);
		out.printf("제목: %s <br>", title);
		out.print("----------------------------<br>");
		out.printf("%s <br>", content);
		out.print("----------------------------<br>");
		out.print("</body>");
		out.print("</html>");
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	//한글이 깨지지 않게 하는 방법
		request.setCharacterEncoding("UTF-8");	//request.getParameter로 가져온 한글을 깨지지 않게 하는 방법
		
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("이름: " + name + "<br>");
		out.print("제목: " + title + "<br>");
		out.print("----------------------------<br>");
		out.print(content + "<br>");
		out.print("----------------------------<br>");
		out.print("</body>");
		out.print("</html>");
	}
}
