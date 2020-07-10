package bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;


@WebServlet(value= {"/bbs/list","/bbs/insert","/bbs/delete" ,"/bbs/read" ,"/bbs/list.json"})
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //�μ�Ʈ�ϴ� �۾� �ҷ��ö�
		response.setContentType("text/html;charset=UTF-8"); //��½� �ѱ۱������� �ذ�
		PrintWriter out=response.getWriter(); //�о�ö��� get
		RequestDispatcher dis=null;
		
		BBSDAO dao=new BBSDAO();
		switch(request.getServletPath()) {
		
		case "/bbs/read" :
			String strNO=request.getParameter("no");
			request.setAttribute("vo", dao.read(Integer.parseInt(strNO)));
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			break;
		
		case "/bbs/insert" :
			response.sendRedirect("insert.jsp");
			break;
		
		case "/bbs/list" :
			response.sendRedirect("list.jsp");
			break;
			
		case "/bbs/list.json" : //rest API(�ּҸ� �Է��ϸ� �����͸� �������� ��) �̰Ÿ� �����ϸ� ���� �������, json������ ����
			String key=request.getParameter("key")==null?"title":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String order=request.getParameter("order")==null?"seqno":request.getParameter("order");
			String desc=request.getParameter("desc")==null?"":request.getParameter("desc");
			String strpage=request.getParameter("page")==null?"1":request.getParameter("page");
			int page=Integer.parseInt(strpage);
			String strperPage=request.getParameter("perPage")==null?"10":request.getParameter("perPage");
			int perPage=Integer.parseInt(strperPage);
			
			out.println(dao.list(key, word, page, perPage, order, desc));
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //�����ͺ��̽��� �μ�Ʈ�� �Է�
		request.setCharacterEncoding("UTF-8"); //post������ �Ѿ�� ���� ������Ʈ
		BBSDAO dao=new BBSDAO();
		
		switch(request.getServletPath()) {
		
		case "/bbs/delete" :
			String strNo2=request.getParameter("no");
			int seqno=Integer.parseInt(strNo2);
			try {
				dao.delete(seqno);
			} catch(Exception e) {
				System.out.println("�Խñ� ���� : " + e.toString());
			}
			response.sendRedirect("list");
			break;
		
		case "/bbs/insert" :
			BBSVO vo=new BBSVO();
			
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
				
			dao=new BBSDAO();
			dao.insert(vo);
			
			response.sendRedirect("list");
			break;
		}
	}

}
