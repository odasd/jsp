package bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value= {"/bbs/list"})
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BBSDAO dao=new BBSDAO();
		RequestDispatcher dis=null;
		
		switch(request.getServletPath()) {
		
		case "/bbs/list" :
			String key=request.getParameter("key")==null?"title":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String strpage=request.getParameter("page")==null?"1":request.getParameter("page");
			int page=Integer.parseInt(strpage);
			
			int count=dao.count(key, word);
			int totpage=count%5==0?count/5:(count/5)+1;
			
			
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
