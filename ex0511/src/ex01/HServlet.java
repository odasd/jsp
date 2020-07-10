package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hap")//주소를 지정하는 부분
public class HServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1~100까지의 합
		int sum=0;
		for(int i=0;i<=100;i++) {
			sum=sum+i;
		}
		//1~100까지의 짝수의 합
		int esum=0;
		for(int i=2;i<=100;i+=2) {
			esum=esum+i;
		}
		
		//브라우저에 출력하기 위한 out 객체 생성
		//서블릿은 자바명령어, html은 출력하기위해 사용
		response.setContentType("text/html;charset=UTF-8");	//한글깨지는것을 방지하는 부분
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>1~100까지의 합=" + sum + "</h1>");
		out.println("<h1>1~100까지의 짝수의 합=" + esum + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
