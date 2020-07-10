package database;

import product.ProductDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println(Database.CON);
		SqlVO vo = new SqlVO();
		vo.setKey("product_code");
		vo.setWord("");
		vo.setOrder("product_code");
		vo.setDesc("");
		vo.setPage(1);
		vo.setPerPage(2);
		
		ProductDAO pdao = new ProductDAO();
		System.out.println(pdao.list(vo));
		
	}

}
