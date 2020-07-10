package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


@WebServlet(value= {"/book/list","/book/cart", "/cart/delete","/book/cartUpdate","/book/read" ,"/book/update", "/book/delete" ,"/book/insert" ,"/book/list.json"}) //url이 한개면 스위치를 안써도 됨
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //오브젝트 데이터를 출력할때 한글 깨지는걸 막는거. 겟에서 출력할때는 리스폰스, 포스트로 넘어 온 값은 리퀘스트.셋 캐릭터 인코딩
		PrintWriter out=response.getWriter(); // out는 브라우저에 출력할때 필요 , 위에것과 순서가 바껴도 한글깨짐
		BookDAO dao=new BookDAO();
		BookVO vo=new BookVO();
		RequestDispatcher dis=null;
		
		switch(request.getServletPath()) {
		
		
		case "/book/read" :
			String code=request.getParameter("code");
			request.setAttribute("vo", dao.read(code));
			dis=request.getRequestDispatcher("read.jsp");
			dis.forward(request, response);
			
			break;
		
		case "/book/cart" :
			response.sendRedirect("cart.jsp");
			break;
		
		case "/book/insert" : //from을 가지고 오는거라 get
			response.sendRedirect("insert.jsp");
			break;
		
		case "/book/list.json" :
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
		
		case "/book/list" :
			response.sendRedirect("list.jsp");
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		BookDAO dao=new BookDAO();
		BookVO vo=new BookVO();
		RequestDispatcher dis=null;
		
		switch(request.getServletPath()) {
		
		case "/cart/delete" :
				String[] array=request.getParameterValues("array");
				HttpSession session=request.getSession();
				ArrayList<CartVO> listCart=(ArrayList<CartVO>)session.getAttribute("listCart");
				for(int i=0; i<listCart.size(); i++) {
					for(int j=0; j<array.length; j++) {
						if(listCart.get(i).getCode().equals(array[j])) {
							listCart.remove(i);
						}
					}
				}
				
				int cnt=0;
				int tot=0;
				for(int i=0; i<listCart.size(); i++) {
					cnt=cnt+listCart.get(i).getNumber();
					tot=tot+listCart.get(i).getSum();
				}
				
				session.setAttribute("cnt", cnt);
				session.setAttribute("tot", tot);
				session.setAttribute("listCart", listCart);
				
			break;
			
		
		case "/book/update" :
			vo.setCode(request.getParameter("code"));
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			String strPrice=request.getParameter("price");
			vo.setPrice(Integer.parseInt(strPrice));
			
			System.out.println(vo.toString());
			
			try {
				dao.update(vo);
				
				
				String code=request.getParameter("code");
				String title=request.getParameter("title");
				String strPrice2=request.getParameter("price");
				int price=Integer.parseInt(strPrice2);
				
					CartVO cartvo=new CartVO();
					
					
					
	
				
				System.out.println(cartvo.toString());
				session=request.getSession();
				listCart=(ArrayList<CartVO>)session.getAttribute("listCart");
				for(int i=0; i<listCart.size(); i++) {
						if(listCart.get(i).getCode().equals(code)) {
							if(listCart.get(i).getTitle()!=(title) || listCart.get(i).getPrice()!=(price)) {
								
								int num = listCart.get(i).getNumber();
								cartvo.setNumber(num);
								listCart.remove(i);
								
								cartvo.setCode(code);
								cartvo.setTitle(title);
								cartvo.setPrice(price);
								cartvo.setCnt(cartvo.getCnt()+1);
								cartvo.setSum(cartvo.getPrice() * cartvo.getNumber());
								
								listCart.add(cartvo);	
							} 
						}
				}
				cnt=0;
				tot=0;
				for(int i=0; i<listCart.size(); i++) {
					cnt=cnt+listCart.get(i).getNumber();
					tot=tot+listCart.get(i).getSum();
				}
				
				session.setAttribute("cnt", cnt);
				session.setAttribute("tot", tot);
				session.setAttribute("listCart", listCart);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
			
			
			
			
		case "/book/delete" :
			String code=request.getParameter("code");
			try {
				dao.delete(code);
				int cnt2=0;
				int tot2=0;
				code=request.getParameter("code");
				session=request.getSession();
				listCart=(ArrayList<CartVO>)session.getAttribute("listCart");
				for(int i=0; i<listCart.size(); i++) {
						if(listCart.get(i).getCode().equals(code)) {
							cnt2=listCart.get(i).getNumber();
							tot2=listCart.get(i).getSum();
							listCart.remove(i);
						}
				}
				
				session.getAttribute("cnt");
				session.getAttribute("tot");
				
				cnt=(Integer)session.getAttribute("cnt")-cnt2;
				tot=(Integer)session.getAttribute("tot")-tot2;
				
				session.setAttribute("cnt", cnt);
				session.setAttribute("tot", tot);
				
				for(int i=0; i<listCart.size(); i++) {
					cnt=cnt+listCart.get(i).getNumber();
					tot=tot+listCart.get(i).getSum();	
				}
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list");
			break;
		
		case "/book/cartUpdate" :
			code=request.getParameter("code");
			String strNumber=request.getParameter("number");
			int number=Integer.parseInt(strNumber);
			
			
			session=request.getSession();
			listCart=(ArrayList<CartVO>)session.getAttribute("listCart");
			for(CartVO v:listCart) {
				if(v.getCode().equals(code)) {
					v.setNumber(number);
					v.setSum(v.getNumber() * v.getPrice());
					
				}
			}
			cnt=0;
			tot=0;
			for(int i=0; i<listCart.size(); i++) {
				cnt=cnt+listCart.get(i).getNumber();
				tot=tot+listCart.get(i).getSum();
			}
			
			session.setAttribute("cnt", cnt);
			session.setAttribute("tot", tot);
			
			break;
		
		case "/book/cart" : //여기 열심히 봐라
			
			code=request.getParameter("code");
			String title=request.getParameter("title");
			String strPrice2=request.getParameter("price");
			int price=Integer.parseInt(strPrice2);
			
			
			CartVO cartvo=new CartVO();
			cartvo.setCode(code);
			cartvo.setTitle(title);
			cartvo.setPrice(price);
			cartvo.setNumber(1);
			cartvo.setCnt(cartvo.getCnt()+1);
			cartvo.setSum(cartvo.getPrice() * cartvo.getNumber());
			System.out.println(cartvo.toString());
			
			session=request.getSession();
			listCart=(ArrayList<CartVO>)session.getAttribute("listCart");
			if(listCart==null) {
				listCart=new ArrayList<CartVO>();
				listCart.add(cartvo);
			} else {
				boolean find=false;
				for(CartVO v:listCart) {
					if(v.getCode().equals(code)) {
						v.setNumber(v.getNumber()+1);
						v.setSum(v.getPrice() * v.getNumber());
						
						int num = v.getNumber();
						v.setNumber(num);
						
						find=true;
					}
				} 
				if(find==false) {
					listCart.add(cartvo);
				}
			}
			cnt=0;
			tot=0;
			for(int i=0; i<listCart.size(); i++) {
				cnt=cnt+listCart.get(i).getNumber();
				tot=tot+listCart.get(i).getSum();
				
				
			}
			
			
			session.setAttribute("cnt", cnt);
			session.setAttribute("tot", tot);
			
			session.setAttribute("listCart", listCart);
			
			break;
		
		case "/book/insert" :
			vo=new BookVO();
			
			vo.setCode(request.getParameter("code"));
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			strPrice=request.getParameter("price");
			vo.setPrice(Integer.parseInt(strPrice));
			
			dao=new BookDAO();
			int count=dao.insert(vo);
			
			JSONObject jObject=new JSONObject();
			jObject.put("count", count);
			out.println(jObject);
			break;
		}
	}

}
