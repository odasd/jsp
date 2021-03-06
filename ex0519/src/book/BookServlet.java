package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value={"/book/list"})
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis=null;
		BookDAO dao=new BookDAO();
		
		switch(request.getServletPath()) {
		case "/book/list" :
			String key=request.getParameter("key")==null?"code":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String strpage=request.getParameter("page")==null?"1":request.getParameter("page");
			int page=Integer.parseInt(strpage);
			
			System.out.println(key + "--------" + word + "--------" + page);
			//전체페이지 구하기
			int count=dao.count(key, word);
			int totpage=0;
			if(count%10==0) {
				totpage=count/10;
			} else {
				totpage=(count/10)+1;
			}
			
			//int totpage=count%10==0?count/5:(count/10)+1; if문 안쓰고 삼항연산자로 사용한것
			
			request.setAttribute("key", key);
			request.setAttribute("word", word);
			request.setAttribute("page", page);
			request.setAttribute("totpage", totpage);
			request.setAttribute("count", count);
			request.setAttribute("list", dao.list(key, word, page));
			dis=request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
