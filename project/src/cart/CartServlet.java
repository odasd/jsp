package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import order.OrderVO;



@WebServlet(value= {"/cart/insert"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		switch(request.getServletPath()) {
	case "/cart/insert" :
		HttpSession session=request.getSession();
	    ArrayList<OrderVO> listCart=(ArrayList<OrderVO>)session.getAttribute("listCart");
       
        OrderVO cartVO=new OrderVO();
        cartVO.setCvs_code(request.getParameter("cvs_code"));
        cartVO.setCategory_code(request.getParameter("category_code"));
        cartVO.setProduct_code(Integer.parseInt(request.getParameter("product_code")));
        cartVO.setOrder_quantity(1);
        
        boolean find=false;
        
        if(listCart==null) {
           listCart=new ArrayList<OrderVO>();
        }else {
           for(OrderVO v:listCart) {
              if(v.getProduct_code()==cartVO.getProduct_code()) {
              v.setOrder_quantity(v.getOrder_quantity()+1);
              find=true;
              }
           }
        }
        if(find==false) {
           listCart.add(cartVO);
        }
        session.setAttribute("listCart", listCart);
        break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
