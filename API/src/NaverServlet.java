

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value= {"/naver/blog", "/naver/book"})
public class NaverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String url="";
		String query=request.getParameter("query");
		int start=(Integer.parseInt(request.getParameter("start")));
		int display=(Integer.parseInt(request.getParameter("display")));
		
		switch(request.getServletPath()) {
		case "/naver/blog" :
			url="https://openapi.naver.com/v1/search/blog";
			String result=NaverAPI.main(url, query, start, display); //스테틱타입이라 이렇게 쓸수있음
			out.println(result);
			break;
			
		case "/naver/book" :
			url="https://openapi.naver.com/v1/search/book.json";
			result=NaverAPI.main(url, query, start, display); //스테틱타입이라 이렇게 쓸수있음
			out.println(result);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
