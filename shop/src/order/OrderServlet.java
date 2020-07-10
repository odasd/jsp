package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(value = { "/order/list", "/order/insert" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		OrderDAO odao = new OrderDAO();

		switch (request.getServletPath()) {

		case "/order/list":
			ArrayList<OrderVO> list = odao.list(request.getParameter("order_id"));
			JSONArray jArray = new JSONArray();
			for (OrderVO vo : list) {
				JSONObject obj = new JSONObject();
				obj.put("prod_id", vo.getProd_id());
				obj.put("prod_name", vo.getProd_name());
				obj.put("company", vo.getCompany());
				obj.put("price", vo.getPrice());
				obj.put("quantity", vo.getQuantity());
				obj.put("sum", vo.getQuantity() * vo.getPrice());
				jArray.add(obj);
			}
			out.println(jArray);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		OrderVO vo=new OrderVO();
		vo.setOrder_id(request.getParameter("order_id"));
		vo.setProd_id(request.getParameter("prod_id"));
		String quantity=request.getParameter("quantity");
		vo.setQuantity(Integer.parseInt(quantity));
		String price=request.getParameter("price");
		vo.setPrice(Integer.parseInt(price));
		
		OrderDAO dao=new OrderDAO();
		
		switch(request.getServletPath()) {
		
		case "/order/insert" :
			dao.insert(vo);
			break;
		}
	}

}
