package bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import database.SqlVO;

@WebServlet(value= {"/bbs/list","/bbs/insert"})
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out=response.getWriter();
	    BBSDAO bdao=new BBSDAO();
	    JSONObject jobject = new JSONObject();
		
		switch(request.getServletPath()) {
		case "/bbs/list":
			System.out.println("bbs/list");
			SqlVO sqlVO=new SqlVO();
			String key=request.getParameter("key")==null?"bno":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String order=request.getParameter("order")==null?"bno":request.getParameter("order");
			String desc=request.getParameter("desc")==null?"":request.getParameter("desc");
			String page=request.getParameter("page")==null?"1":request.getParameter("page");
			String perPage=request.getParameter("perPage")==null?"5":request.getParameter("perPage");
			
			sqlVO.setKey(key);
			sqlVO.setWord(word);
			sqlVO.setOrder(order);
			sqlVO.setDesc(desc);
			sqlVO.setPage(Integer.parseInt(page));
			sqlVO.setPerPage(Integer.parseInt(perPage));
			out.println(bdao.list(sqlVO));
			System.out.println(sqlVO.toString());
			break;
			
		case "/bbs/insert":
			response.sendRedirect("insert.jsp");
			break;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		switch(request.getServletPath()) {
		
		case "/bbs/insert" :
			BBSVO vo=new BBSVO();
			vo.setTitle(request.getParameter("title"));
			vo.setContents(request.getParameter("contents"));
			//vo.setUlike(Integer.parseInt(request.getParameter("ulike")));
			
			BBSDAO dao=new BBSDAO();
			dao.insert(vo);
			
			response.sendRedirect("list.jsp");
			break;
		}
	}

}
