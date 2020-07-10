package professors;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value= {"/pro/list", "/pro/insert", "/pro/delete", "/pro/read", "/pro/update"}) //웹 서블릿은 주소를 가려주는 역할을 한다. 여기서 벨류는 대체할 주소값을 미리 지정해주는 것 
public class PServlet extends HttpServlet { //import javax.servlet.ServletException 라리브러리를 약속어들을 사용하기위해 상속(extends)시킨다.
	private static final long serialVersionUID = 1L; //직렬화 과정에서 1L은 메모리할당크기(저장공간)을 자동으로 생성하는 듯, 1L을 안 적을시 역직열화시 오류가 발생할수 있다.(1L이라는 공간을 생성하는데 크기또한 알아서 만들어라)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//doget(get을 실행하라) 리퀘스트와 리스폰스 값을 전달받아 오라는 뜻 
		// 웹 서블릿으로 지정한 url값과 리스폰스(어떤 클라이언트(웹)가 요청했는지에 대한 값), 리퀘스트(웹서블릿에 선언한 url중 현재 url)
		RequestDispatcher dis=null; //디스패치를 편하게 사용하기 위해 전역변수로 선언함
		PDAO dao=new PDAO();
		
		switch(request.getServletPath()) { //스위치문을 사용하기위한 조건값은 웹서블릿의 패스값을 가져와서 사용함
		case "/pro/read":
			String pcode=request.getParameter("pcode"); //웹에서 입력된 pcode의 값을 가져와 변수 pcode에 입력함
			try {
				PVO vo=dao.read(pcode); //매게변수 pcode를 가지는 dao의 read메서드 실행값을 PVO vo에 치환
				request.setAttribute("vo", vo); //처리(제어)값을 다른 곳에 넘겨주기 위해 리퀘스트에 셋 어트리뷰트를 하는데 셋 어트리뷰트는 리퀘스트와 리스폰스 둘 모두의 값을 가지고 있다는 뜻
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("read.jsp"); //디스패치 맵핑(연결 된다고 선언)을 리드jsp로 한다
			dis.forward(request, response); //리드jsp에 포워드를(제어 요청) 함, 포워드 값은 vo의 값을 가진다. 제어를 넘긴 값은 *리드jsp에서 처리후 바로 웹브라우저로 출력*
			break;
			
		case "/pro/delete":
			pcode=request.getParameter("pcode");
			try {
				dao.delete(pcode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list"); //list.jsp에서 read.jsp를 요청, 서버에서 웹 브라우저가 요청한 경로로 read.jsp값을 반환후 웹에서 delete.jsp를 요청함-> 데이터 삭제가 된다(read.jsp에서 delete url이 있기때문)
			break;
			
		case "/pro/insert":
			dis=request.getRequestDispatcher("insert.jsp");
			dis.forward(request, response);
			break;
			
		case "/pro/list":
			try {
				request.setAttribute("list", dao.list());
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	//값(리퀘스트, 리스폰스)을 전달함
		request.setCharacterEncoding("UTF-8");
		PDAO dao=new PDAO();
		
		switch(request.getServletPath()) {
		case "/pro/update":
			PVO vo=new PVO();
			vo.setPcode(request.getParameter("pcode"));
			vo.setPname(request.getParameter("pname"));
			vo.setDept(request.getParameter("dept"));
			vo.setTitle(request.getParameter("title"));
			String strSalary=request.getParameter("salary");
			vo.setSalary(Integer.parseInt(strSalary));
			
			System.out.println(vo.toString());
			try {
				dao.update(vo);
			}catch(Exception e){
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
			
		case "/pro/insert":
			vo=new PVO();
			vo.setPcode(request.getParameter("pcode"));
			vo.setPname(request.getParameter("pname"));
			vo.setDept(request.getParameter("dept"));
			vo.setTitle(request.getParameter("title"));
			strSalary=request.getParameter("salary");
			vo.setSalary(Integer.parseInt(strSalary));
			System.out.println(vo.toString());
			try {
				dao.insert(vo);
			}catch(Exception e){
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		}
	}
}
