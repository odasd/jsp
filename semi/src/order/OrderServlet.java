package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;




@WebServlet(value= {"/order/insert","/order/id"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		OrderVO vo= new OrderVO();
		vo.setCvs_code(request.getParameter("cvs_code"));
		vo.setProduct_code(Integer.parseInt(request.getParameter("product_code")));
		vo.setCategory_code(request.getParameter("category_code"));
		vo.setOrder_quantity(Integer.parseInt(request.getParameter("order_quantity")));
		OrderDAO dao=new OrderDAO();
		
		switch(request.getServletPath()){
		case "/order/insert":
			int order_id=dao.insert(vo);
			JSONObject jObject=new JSONObject();
			jObject.put("order_id", order_id);
			out.print(jObject);
			break;
		}
		
	}

}
