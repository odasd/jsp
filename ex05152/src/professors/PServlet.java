package professors;

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

import courses.CDAO;
import courses.CVO;

@WebServlet(value= {"/pro/list", "/pro/insert", "/pro/delete", "/pro/read", "/pro/update", "/pro/courses"})
public class PServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dis=null;
		PDAO dao=new PDAO();
		CDAO cdao=new CDAO();
		
		switch(request.getServletPath()) {
		case "/pro/courses":
			String pcode=request.getParameter("pcode");
			try {
				ArrayList<CVO> plist=cdao.plist(pcode);
				JSONArray jArray=new JSONArray();
				for(CVO vo:plist) {
					JSONObject obj=new JSONObject();
					obj.put("lcode", vo.getLcode());
					obj.put("lname", vo.getLname());
					obj.put("room", vo.getRoom());
					obj.put("hours", vo.getHours());
					jArray.add(obj);
				}
				PrintWriter out=response.getWriter();
				out.println(jArray);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		case "/pro/read":
			pcode=request.getParameter("pcode");
			try {
				PVO vo=dao.read(pcode);
				request.setAttribute("vo", vo);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);;
			break;
			
		case "/pro/delete":
			pcode=request.getParameter("pcode");
			try {
				dao.delete(pcode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/pro/insert":
			dis=request.getRequestDispatcher("insert.jsp");
			dis.forward(request, response);;
			break;
		case "/pro/list":
			try {
				request.setAttribute("list", dao.list());
			}catch(Exception e) {
				System.out.println();
			}
			dis=request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PDAO dao=new PDAO();
		switch(request.getServletPath()) {
		case "/pro/insert":
			PVO vo=new PVO();
			vo.setPcode(request.getParameter("pcode"));
			vo.setPname(request.getParameter("pname"));
			vo.setDept(request.getParameter("dept"));
			vo.setTitle(request.getParameter("title"));
			String strSalary=request.getParameter("salary");
			vo.setSalary(Integer.parseInt(strSalary));
			System.out.println(vo.toString());
			try {
				dao.insert(vo);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/pro/update":
			vo=new PVO();
			vo.setPcode(request.getParameter("pcode"));
			vo.setPname(request.getParameter("pname"));
			vo.setDept(request.getParameter("dept"));
			vo.setTitle(request.getParameter("title"));
			strSalary=request.getParameter("salary");
			vo.setSalary(Integer.parseInt(strSalary));
			System.out.println(vo.toString());
			try {
				dao.update(vo);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");	
			break;
		}
	}
}
