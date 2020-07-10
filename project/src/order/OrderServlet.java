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




@WebServlet(value= {"/order/insert", "/order/cartlist"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
		
		case "/order/cartlist" :
			HttpSession session = request.getSession();
			ArrayList<OrderVO> listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");
			OrderVO cartVO = new OrderVO();
			cartVO.setProduct_code(Integer.parseInt(request.getParameter("product_code")));
			cartVO.setProduct_name(request.getParameter("product_name"));
			cartVO.setCategory_code(request.getParameter("category_code"));
			cartVO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
			cartVO.setOrder_quantity(1);
			cartVO.setCvs_code(request.getParameter("cvs_code"));
			System.out.println(cartVO);
			listCart.add(cartVO);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		
	}

}
