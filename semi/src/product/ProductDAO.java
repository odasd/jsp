package product;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import database.Database;
import database.SqlVO;

public class ProductDAO {
	// 상품목록출력
			public JSONObject list(SqlVO vo) {
				JSONObject jobject = new JSONObject();
				try {
					String sql = "call list(?,?,?,?,?,?,?)";
					CallableStatement cs = Database.CON.prepareCall(sql);
					cs.setString(1, "pclist");
					cs.setString(2, vo.getKey());
					cs.setString(3, vo.getWord());
					cs.setString(4, vo.getOrder());
					cs.setString(5, vo.getDesc());
					cs.setInt(6, vo.getPage());
					cs.setInt(7, vo.getPerPage());
					cs.execute();

					ResultSet rs = cs.getResultSet();
					JSONArray jArray = new JSONArray();
					while (rs.next()) {
						JSONObject obj = new JSONObject();
						obj.put("product_code", rs.getInt("product_code"));
						obj.put("product_name", rs.getString("product_name"));
						obj.put("product_price", rs.getInt("product_price"));
						obj.put("company", rs.getString("company"));
						obj.put("category_code", rs.getString("category_code"));
						obj.put("category_name", rs.getString("category_name"));
						obj.put("img", rs.getString("img"));
						obj.put("product_del", rs.getString("prod_del"));
						
						DecimalFormat df = new DecimalFormat("#,###");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						
						String strDate = sdf.format(rs.getDate("product_date"));
						String strExp = sdf.format(rs.getDate("product_exp"));
						obj.put("product_date", strDate);
						obj.put("product_exp", strExp);
						jArray.add(obj);
					}
					jobject.put("array", jArray);
				
					//검색 데이터 갯수
			         cs.getMoreResults();
			         rs=cs.getResultSet();
			         int count=0;
			         if(rs.next()) { count=rs.getInt("total"); }
			         int perPage =vo.getPerPage();
			         int totPage = count%vo.getPerPage()==0?
			               count/perPage:count/perPage+1;
			            jobject.put("count", count); //전체 데이터
			            jobject.put("page", vo.getPage());//현재페이지
			            jobject.put("perPage", vo.getPerPage());//페이지당 갯수
			            jobject.put("totPage", totPage);//전체페이지
				
				} catch (Exception e) {
					System.out.println("상품목록" + e.toString());
				}
				return jobject;
			}
			
		public void insert(ProductVO vo) {
		try {
			String sql="insert into product(product_code, product_name, product_price, company, product_date, product_exp, category_code, img, prod_del) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setInt(1, vo.getProduct_code());
			ps.setString(2, vo.getProduct_name());
			ps.setInt(3, vo.getProduct_price());
			ps.setString(4, vo.getCompany());
			ps.setDate(5, vo.getProduct_date());
			ps.setDate(6, vo.getProduct_exp());
			ps.setString(7, vo.getCategory_code());
			ps.setString(8, vo.getImg());
			ps.setString(9, vo.getProd_del());
			ps.execute();
		} catch(Exception e) {
			System.out.println("상품등록 : "+e.toString());
		}	
		}
}
