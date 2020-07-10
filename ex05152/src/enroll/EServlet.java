package enroll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet(value= {"/enroll/insert", "/enroll/delete", "/enroll/update"})
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EDAO edao=new EDAO();
		String scode=request.getParameter("scode");
		String lcode=request.getParameter("lcode");
		
		switch(request.getServletPath()) {
		case "/enroll/insert":
			try {
				int cnt=edao.insert(scode, lcode);
				JSONObject jObject=new JSONObject();
				jObject.put("cnt", cnt);
				PrintWriter out=response.getWriter();
				out.println(jObject);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		case "/enroll/delete":
			try {
				edao.delete(scode, lcode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		case "/enroll/update":	
			try {
				String grade=request.getParameter("grade");
				EVO vo=new EVO();
				vo.setLcode(lcode);
				vo.setScode(scode);
				vo.setGrade(Integer.parseInt(grade));
				edao.update(vo);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		}
	}
}
