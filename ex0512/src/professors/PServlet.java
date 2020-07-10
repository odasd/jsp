package professors;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value= {"/pro/list", "/pro/insert", "/pro/delete", "/pro/read", "/pro/update"}) //�� ������ �ּҸ� �����ִ� ������ �Ѵ�. ���⼭ ������ ��ü�� �ּҰ��� �̸� �������ִ� �� 
public class PServlet extends HttpServlet { //import javax.servlet.ServletException �󸮺귯���� ��Ӿ���� ����ϱ����� ���(extends)��Ų��.
	private static final long serialVersionUID = 1L; //����ȭ �������� 1L�� �޸��Ҵ�ũ��(�������)�� �ڵ����� �����ϴ� ��, 1L�� �� ������ ������ȭ�� ������ �߻��Ҽ� �ִ�.(1L�̶�� ������ �����ϴµ� ũ����� �˾Ƽ� ������)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//doget(get�� �����϶�) ������Ʈ�� �������� ���� ���޹޾� ����� �� 
		// �� �������� ������ url���� ��������(� Ŭ���̾�Ʈ(��)�� ��û�ߴ����� ���� ��), ������Ʈ(�������� ������ url�� ���� url)
		RequestDispatcher dis=null; //����ġ�� ���ϰ� ����ϱ� ���� ���������� ������
		PDAO dao=new PDAO();
		
		switch(request.getServletPath()) { //����ġ���� ����ϱ����� ���ǰ��� �������� �н����� �����ͼ� �����
		case "/pro/read":
			String pcode=request.getParameter("pcode"); //������ �Էµ� pcode�� ���� ������ ���� pcode�� �Է���
			try {
				PVO vo=dao.read(pcode); //�ŰԺ��� pcode�� ������ dao�� read�޼��� ���ప�� PVO vo�� ġȯ
				request.setAttribute("vo", vo); //ó��(����)���� �ٸ� ���� �Ѱ��ֱ� ���� ������Ʈ�� �� ��Ʈ����Ʈ�� �ϴµ� �� ��Ʈ����Ʈ�� ������Ʈ�� �������� �� ����� ���� ������ �ִٴ� ��
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			dis=request.getRequestDispatcher("read.jsp"); //����ġ ����(���� �ȴٰ� ����)�� ����jsp�� �Ѵ�
			dis.forward(request, response); //����jsp�� �����带(���� ��û) ��, ������ ���� vo�� ���� ������. ��� �ѱ� ���� *����jsp���� ó���� �ٷ� ���������� ���*
			break;
			
		case "/pro/delete":
			pcode=request.getParameter("pcode");
			try {
				dao.delete(pcode);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			response.sendRedirect("list"); //list.jsp���� read.jsp�� ��û, �������� �� �������� ��û�� ��η� read.jsp���� ��ȯ�� ������ delete.jsp�� ��û��-> ������ ������ �ȴ�(read.jsp���� delete url�� �ֱ⶧��)
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	//��(������Ʈ, ��������)�� ������
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
