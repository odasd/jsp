package jsoup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@WebServlet(value= {"/jsoup"})
public class JsoupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getServletPath()) {
		case "/jsoup":
			try {
				System.out.println(".................");
				 Document doc=Jsoup.connect("http://www.naver.com/").get();
			     Elements elements=doc.select(".ah_list .ah_l");
			     for(Element e:elements.select(".ah_item")){
			    	 System.out.println("..");
		            System.out.println(e.select(".ah_r").text());
		            System.out.println(e.select(".ah_k").text());
			     }
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
