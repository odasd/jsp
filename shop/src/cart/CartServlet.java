package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import order.OrderVO;
import product.ProductDAO;
import product.ProductVO;

@WebServlet(value = { "/cart/insert", "/cart/update", "/cart/delete"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getServletPath()) {
		case "/cart/insert":
			HttpSession session = request.getSession();
			ArrayList<OrderVO> listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");
			ProductDAO pdao = new ProductDAO();
			ProductVO productVO = pdao.read(request.getParameter("prod_id"));

			OrderVO cartVO = new OrderVO();
			cartVO.setProd_id(productVO.getProd_id());
			cartVO.setProd_name(productVO.getProd_name());
			cartVO.setPrice(productVO.getPrice1());
			cartVO.setQuantity(1);
			cartVO.setSum(cartVO.getPrice() * cartVO.getQuantity());
			
			 boolean isFind=false; 
			if (listCart == null) {
				listCart = new ArrayList<OrderVO>();
			} else {
				for (OrderVO oldVO : listCart) {
					if (oldVO.getProd_id().equals(cartVO.getProd_id())) {
						oldVO.setQuantity(oldVO.getQuantity() + 1);
						oldVO.setSum(oldVO.getPrice() * oldVO.getQuantity());
						isFind = true;
					}
				}
			}
			if (!isFind)
				listCart.add(cartVO);
				session.setAttribute("listCart", listCart);
			break;
			
		case "/cart/update" :
			
			session = request.getSession();
			listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");
			String prod_id=request.getParameter("prod_id");
			String strQuantity=request.getParameter("quantity");
			int quantity=Integer.parseInt(strQuantity);
			for(OrderVO oldVO:listCart) {
				if(oldVO.getProd_id().equals(prod_id)) {
					oldVO.setQuantity(quantity);
					oldVO.setSum(oldVO.getPrice()*oldVO.getQuantity());
				}
			}
			
			break;
			
		case "/cart/delete" :
			session = request.getSession();
			listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");
			prod_id=request.getParameter("prod_id");
			for(int i=0; listCart.size()>i; i++) {
				if(listCart.get(i).getProd_id().equals(prod_id)) {
					listCart.remove(i);
					break;
				}
			}
			
			break;
		}
	}

}
