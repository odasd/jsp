package professors;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import database.SqlVO;


@WebServlet(value= {"/professors/list","/professors/ck", "/professors/cslist" ,"/professors/insert","/professors/read","/professors/update", "/professors/delete"})
public class ProfessorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");     
		 PrintWriter out=response.getWriter();
	     ProfessorsDAO pdao=new ProfessorsDAO();
	     JSONObject jObject=new JSONObject(); 
	     
	     switch(request.getServletPath()) {      
	     
	     case "/professors/cslist" :
	    	 out.println(pdao.cslist(request.getParameter("pcode")));
	    	 break;
	     
	     case "/professors/delete" :
	    	 out.println(pdao.delete(request.getParameter("pcode")));
	    	 break;
	     
	     case "/professors/read" :
	    	 request.setAttribute("vo", pdao.read(request.getParameter("pcode")));
	    	 RequestDispatcher dis=request.getRequestDispatcher("read.jsp");
	    	 dis.forward(request, response);
	    	 break;
	     
	     case "/professors/ck" :
	    	 int count=pdao.codeCheck(request.getParameter("pcode"));
	    	 jObject.put("count", count);
	    	 out.println(jObject);
	    	 break;
	     
	     case "/professors/list":           
	    	 SqlVO sqlVO=new SqlVO();          
	    	 String key=request.getParameter("key")==null?"pcode":request.getParameter("key");          
	    	 String word=request.getParameter("word")==null?"":request.getParameter("word");        
	    	 String order=request.getParameter("order")==null?"pcode":request.getParameter("order");    
	    	 String desc=request.getParameter("desc")==null?"":request.getParameter("desc");         
	    	 String page=request.getParameter("page")==null?"1":request.getParameter("page");        
	    	 String perPage=request.getParameter("perPage")==null?"5":request.getParameter("perPage");
	    	 sqlVO.setKey(key);         
	         sqlVO.setWord(word);      
	         sqlVO.setOrder(order);     
	         sqlVO.setDesc(desc);        
	         sqlVO.setPage(Integer.parseInt(page));   
	         sqlVO.setPerPage(Integer.parseInt(perPage));    
	         out.println(pdao.list(sqlVO));   //브라우저 출력
	         System.out.println(sqlVO);		//콘솔 출력
	         break; 
	     }
	         
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		ProfessorVO vo=new ProfessorVO();
	    ProfessorsDAO pdao=new ProfessorsDAO();
	    JSONObject jObject=new JSONObject(); 
	    
	    
	    vo.setPcode(request.getParameter("pcode"));
	    vo.setPname(request.getParameter("pname"));
	    vo.setTitle(request.getParameter("title"));
	    vo.setDept(request.getParameter("dept"));
	    String salary=request.getParameter("salary");
	    vo.setSalary(Integer.parseInt(salary));
	    String yy=request.getParameter("yy");
	    String mm=request.getParameter("mm");
	    String dd=request.getParameter("dd");
	    String strHirdate=yy+"-"+mm+"-"+dd;
	    try {
	    	java.sql.Date hiredate=Date.valueOf(strHirdate);
	    	vo.setHirdate(hiredate);
	    } catch(Exception e) {
	    	System.out.println(vo.toString());
	    }
	    
	    switch(request.getServletPath()) {
	    
	    case "/professors/insert" :
	    	pdao.insert(vo);
	    	response.sendRedirect("list.jsp");
	    	break;
	    	
	    case "/professors/update" :
			  System.out.println(vo.toString());
			  pdao.update(vo);
			  response.sendRedirect("list.jsp");
			  break;	
	    
	    }
	}

}
