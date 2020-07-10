package order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Database;

public class OrderDAO {
	
	public void insert(OrderVO vo){
		try {
		String sql="insert into orders(cvs_code, product_code, category_code, order_quantity, order_date, order_id) "
				+ "values(?,?,?,?,?,now(),?)";
		PreparedStatement ps=Database.CON.prepareStatement(sql);
		ps.setString(1, vo.getCvs_code());
		ps.setInt(2, vo.getProduct_code());
		ps.setString(3,  vo.getCategory_code());
		ps.setInt(4, vo.getOrder_quantity());
		ps.setDate(5, vo.getOrder_date());
		ps.setInt(6, vo.getOrder_id());
		ps.execute();
		}catch (Exception e) {
			System.out.println("orderinsert:" + e.toString());
		}
		
	}
	
	
	// 새로운 order_code 얻기
		public String getID() {
			String id = "";
			try {
				String sql = "select max(order_code) id from orders";
				PreparedStatement ps = Database.CON.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String maxID = rs.getString("id").substring(1);
					id = "O" + (maxID) + 1;
				}
			} catch (Exception e) {
				System.out.println("새로운 상품코드 얻기 : " + e.toString());
			}
			return id;
		}
}
