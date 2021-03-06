package courses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import enroll.EDAO;
import enroll.EVO;
import professors.PDAO;


@WebServlet(value= {"/cou/list","/cou/insert","/cou/delete","/cou/read","/cou/update", "/cou/enroll"})
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		CDAO dao=new CDAO();
		EDAO edao=new EDAO();
		RequestDispatcher dis=null;		
		switch(request.getServletPath()) {
		case "/cou/enroll":
			String lcode=request.getParameter("lcode");
			try {
				ArrayList<EVO> clist=edao.clist(lcode);
				JSONArray jArray=new JSONArray();
				for(EVO vo:clist) {
					JSONObject obj=new JSONObject();
					obj.put("scode", vo.getScode());
					obj.put("sname", vo.getSname());
					obj.put("grade", vo.getGrade());
					obj.put("edate", vo.getEdate());
					jArray.add(obj);
				}
				PrintWriter out=response.getWriter();
				out.println(jArray);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		//--------------------------------------
		case "/cou/list":
			System.out.println("Get /cou/list");
			try {
				request.setAttribute("array", dao.list());
			}catch(Exception e){
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
			break;
		//-----------------------------------------------	
		case "/cou/insert":
			System.out.println("Get /cou/insert");
			try {
				PDAO pdao = new PDAO();
				request.setAttribute("plist", pdao.list());
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("insert.jsp");
			dis.forward(request, response);
			break;
		case "/cou/delete":
			System.out.println("Get /cou/delete");
			break;
		case "/cou/read":
			System.out.println("Get /cou/read");
			lcode=request.getParameter("lcode");
			try {
				request.setAttribute("vo",dao.read(lcode));
				PDAO pdao = new PDAO();
				request.setAttribute("plist", pdao.list());
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			break;
		case "/cou/update":
			System.out.println("Get /cou/update");
			break;			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CDAO dao=new CDAO();
		CVO vo=new CVO();
		switch(request.getServletPath()) {
		case "/cou/list":
			System.out.println("Post /cou/list");
			break;
		case "/cou/insert":
			System.out.println("Post /cou/insert");
			try {
				vo.setLcode(request.getParameter("lcode"));
				vo.setLname(request.getParameter("lname"));
				vo.setRoom(request.getParameter("room"));
				String hours=request.getParameter("hours");
				vo.setHours(Integer.parseInt(hours));
				vo.setInstructor(request.getParameter("instructor"));
				System.out.println(vo.getInstructor());
				dao.insert(vo);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/cou/delete":
			System.out.println("Post /cou/delete");
			String lcode=request.getParameter("lcode");
			try {
				dao.delete(lcode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/cou/read":
			System.out.println("Post /cou/read");
			break;
		case "/cou/update":
			System.out.println("Post /cou/update");
			try {
				vo.setLcode(request.getParameter("lcode"));
				vo.setLname(request.getParameter("lname"));
				vo.setRoom(request.getParameter("room"));
				String hours=request.getParameter("hours");
				vo.setHours(Integer.parseInt(hours));
				vo.setInstructor(request.getParameter("instructor"));
				System.out.println(vo.getInstructor());
				dao.update(vo);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;			
		}
	}
}
