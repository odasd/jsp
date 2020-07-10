package students;

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


@WebServlet(value= {"/stu/list", "/stu/insert", "/stu/delete", "/stu/update", "/stu/read"}) //서블릿은 컨트롤러
public class SServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //doget 주소를 쳤을때 바로 가는것
		RequestDispatcher dis=null;
		SDAO dao=new SDAO();
		switch(request.getServletPath()) {
		case "/stu/list" :
			try {
			ArrayList<SVO> list=dao.list();
			request.setAttribute("array", list);
			} catch(Exception e) {
				System.out.println(e.toString());
			}
			//System.out.println("get /stu/list");
			dis=request.getRequestDispatcher("list.jsp");  //가지고 갈 값이 있으면 디스패쳐
			dis.forward(request, response);
			break;
		case "/stu/insert" :
			//System.out.println("get /stu/insert");
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
		case "/stu/delete" :
			//System.out.println("get /stu/delete");
			
			break;
		case "/stu/update" :
			//System.out.println("get /stu/update");
			break;
		case "/stu/read" :
			//System.out.println("get /stu/read");
			String scode=request.getParameter("scode");
			pdao=new PDAO();
			try {
				request.setAttribute("vo", dao.read(scode));
				ArrayList<PVO> plist=pdao.list();
				request.setAttribute("plist", plist);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			break;
	}
}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SDAO dao=new SDAO();
		SVO vo=new SVO();
		switch(request.getServletPath()) {
		case "/stu/list" :
			//System.out.println("get /stu/list");
			
			break;
		case "/stu/insert" :
			//System.out.println("get /stu/insert");
			vo.setScode(request.getParameter("scode"));
			vo.setSname(request.getParameter("sname"));
			vo.setDept(request.getParameter("dept"));
			String year=request.getParameter("year");
			vo.setYear(Integer.parseInt(year));
			vo.setBirthday(request.getParameter("birthday"));
			vo.setAdvisor(request.getParameter("advisor"));
			System.out.println(vo.toString());
			try {
				dao.insert(vo);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list"); //가지고 갈 값이 없을경우 리다이렉트
			break;
		case "/stu/delete" :
			//System.out.println("get /stu/delete");
			String scode=request.getParameter("scode");
			try {
				dao.delete(scode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		case "/stu/update" :
			vo.setScode(request.getParameter("scode"));
			vo.setSname(request.getParameter("sname"));
			vo.setDept(request.getParameter("dept"));
			year=request.getParameter("year");
			vo.setYear(Integer.parseInt(year));
			//vo.setBirthday(request.getParameter("birthday"));
			vo.setAdvisor(request.getParameter("advisor"));
			System.out.println(vo.toString());
			try {
				dao.update(vo);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
		case "/stu/read" :
			//System.out.println("get /stu/read");
			break;
	}
	}

}
