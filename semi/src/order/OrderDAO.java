package order;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Database;

public class OrderDAO {

	public int insert(OrderVO vo) {
		int count = 1;
		try {
			String sql = "call add_orders(?,?,?,?,?)";
			CallableStatement cs = Database.CON.prepareCall(sql);
			cs.setString(1, vo.getCvs_code());
			cs.setInt(2, vo.getProduct_code());
			cs.setString(3, vo.getCategory_code());
			cs.setInt(4, vo.getOrder_quantity());
			cs.registerOutParameter(5, java.sql.Types.INTEGER);
			cs.execute();
			count = cs.getInt(5);

		} catch (Exception e) {
			System.out.println("orderinsert:" + e.toString());
		}

		return count;
	}

}
