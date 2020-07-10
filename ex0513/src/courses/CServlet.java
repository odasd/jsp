package courses;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import professors.PDAO;
import professors.PVO;


/**
 * Servlet implementation class CServlet
 */
@WebServlet(value= {"/cou/list", "/cou/insert", "/cou/delete", "/cou/read", "/cou/update"})
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=null;
		CDAO dao=new CDAO();
		switch(request.getServletPath()) {
		case "/cou/list" :
			//System.out.println("get /cou/list");
			try {
				ArrayList<CVO> list=dao.list();
				request.setAttribute("array", list);
				} catch(Exception e) {
					System.out.println(e.toString());
				}
				//System.out.println("get /stu/list");
				dis=request.getRequestDispatcher("list.jsp");  //가지고 갈 값이 있으면 디스패쳐
				dis.forward(request, response);
			break;
		case "/cou/insert" :
			//System.out.println("get /cou/insert");
			PDAO pdao=new PDAO();
			try {
				ArrayList<PVO> plist=pdao.list();
				request.setAttribute("plist", plist);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("insert.jsp");
			dis.forward(request, response);
			break;
		case "/cou/delete" :
			//System.out.println("get /cou/delete");
			
			break;
		case "/cou/read":
			//System.out.println("get /cou/read");
			String lcode=request.getParameter("lcode");
			pdao=new PDAO();
			try {
				request.setAttribute("vo", dao.read(lcode));
				ArrayList<PVO> plist=pdao.list();
				request.setAttribute("plist", plist);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			break;
		case "/cou/update":
			//System.out.println("get /cou/update");
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CDAO dao=new CDAO();
		CVO vo=new CVO();
		switch(request.getServletPath()) {
		case "/cou/list" :
		//	System.out.println("post /cou/list");
			break;
		case "/cou/insert" :
			//System.out.println("post /cou/insert");
			vo.setLcode(request.getParameter("lcode"));
			vo.setLname(request.getParameter("lname"));
		    String hours=request.getParameter("hours");
	        vo.setHours(Integer.parseInt(hours));
			vo.setRoom(request.getParameter("room"));
			vo.setInstructor(request.getParameter("instructor"));
			System.out.println(vo.toString());
			try {
				dao.insert(vo);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/cou/delete" :
			//System.out.println("post /cou/delete");
			String lcode=request.getParameter("lcode");
			try {
				dao.delete(lcode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/cou/read":
			System.out.println("post /cou/read");
			break;
		case "/cou/update":
			//System.out.println("post /cou/update");
			vo.setLcode(request.getParameter("lcode"));
			vo.setLname(request.getParameter("lname"));
			hours=request.getParameter("hours");
	        vo.setHours(Integer.parseInt(hours));
			vo.setRoom(request.getParameter("room"));
			vo.setInstructor(request.getParameter("instructor"));
			System.out.println(vo.toString());
			try {
				dao.update(vo);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		}
	}
	

}
