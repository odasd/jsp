package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


@WebServlet(value= {"/user/list", "/user/insert", "/user/read", "/user/update", "/user/delete","/user/list.json", "/user/login", "/user/logout"}) //url이 한개면 스위치를 안써도 됨
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //오브젝트 데이터를 출력할때 한글 깨지는걸 막는거. 겟에서 출력할때는 리스폰스, 포스트로 넘어 온 값은 리퀘스트.셋 캐릭터 인코딩
		PrintWriter out=response.getWriter(); // out는 브라우저에 출력할때 필요 , 위에것과 순서가 바껴도 한글깨짐
		UserDAO dao=new UserDAO();
		RequestDispatcher dis=null;
		switch(request.getServletPath()) {
		
		case "/user/read" :
			String id=request.getParameter("id");
			request.setAttribute("vo", dao.read(id));
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			
			break;
		
		case "/user/insert" :
				dis=request.getRequestDispatcher("insert.jsp");
				dis.forward(request, response);
			break;
		
		case "/user/logout" :
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("/index.jsp");
			break;
		
		case "/user/login" :
			dis=request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
			break;
		
		case "/user/list.json" :
		String key=request.getParameter("key");
		String word=request.getParameter("word");
		String strpage=request.getParameter("page");
		String order=request.getParameter("order");
		String desc=request.getParameter("desc");
		int page=Integer.parseInt(strpage);
		String strperPage=request.getParameter("perPage");
		int perPage=Integer.parseInt(strperPage);
	
		out.println(dao.list(key, word, page, perPage, order, desc));
		break;
		
		case "/user/list" :
			response.sendRedirect("list.jsp");
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("UTF-8");
		UserDAO dao=new UserDAO();
		UserVO vo=new UserVO();
		
		switch(request.getServletPath()) {
		
		case "/user/update":
			vo.setId(request.getParameter("id"));
			vo.setName(request.getParameter("name"));
			vo.setJob(request.getParameter("job"));
			vo.setTel(request.getParameter("tel"));
			
			System.out.println(vo.toString());
			try {
				dao.update(vo);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			
			break;
			
		case "/user/delete" :
			String id=request.getParameter("id");
			try {
				dao.delete(id);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		
		case "/user/insert" :
			
			vo=new UserVO();
			vo.setId(request.getParameter("id"));
			vo.setPassword(request.getParameter("pass"));
			vo.setName(request.getParameter("name"));
			vo.setJob(request.getParameter("job"));
			vo.setTel(request.getParameter("tel"));
			JSONObject jObject=dao.insert(vo);
			out.println(jObject);
			
			break;
		
		case "/user/login" :
			id=request.getParameter("id");
			String password=request.getParameter("password");
			
			dao=new UserDAO();
			vo=dao.loginCheck(id, password);
			
			jObject=new JSONObject();
			jObject.put("id", vo.getId()); //로그인이 됐는지 안됐는지 알아보기위해 json데이터로 만들어줌
			out.print(jObject);
			
			HttpSession session=request.getSession();//브라우저가 닫힐때까지 로그인 정보를 저장하고 있음
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			break;
		}
	}

}
