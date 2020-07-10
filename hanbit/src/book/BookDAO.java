package book;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bbs.Database;

public class BookDAO {
	
	//도서 수정
	public void update(BookVO vo) {
		try {
			String sql="update goodsinfo set title=?, writer=?, price=? where code=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getCode());
			ps.execute();
			
		} catch(Exception e) {
			System.out.println("도서 수정 : " + e.toString());
		}
	}
	//도서 삭제
	public void delete(String code) {
		try {
			String sql="delete from goodsinfo where code=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, code);
			ps.execute();
		} catch(Exception e) {
			System.out.println("도서 삭제 : " + e.toString());
		}
	}
	//read
	public BookVO read(String code) {
		BookVO vo=new BookVO();
		try {
			String sql="select * from goodsinfo where code=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				vo.setCode(rs.getString("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				ps.execute();
			}
		} catch(Exception e) {
			System.out.println("도서 내용" + e.toString());
		}
		
		return vo;
	}
	
	
	//도서 등록
	public int insert(BookVO vo) {
		int count=0;
		try {
			String sql="call add_book(?,?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, vo.getCode());
			cs.setString(2, vo.getTitle());
			cs.setString(3, vo.getWriter());
			cs.setInt(4, vo.getPrice());
			cs.registerOutParameter(5, java.sql.Types.INTEGER);
			cs.execute();
			
			count=cs.getInt(5);
			
		} catch(Exception e) {
			System.out.println("도서등록 : " + e.toString());
		}
		
		return count;
	}
	
	//도서목록 출력
	public JSONObject list(String key, String word, int page, int perPage, String order, String desc) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list('goodsinfo',?,?,?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, key);
			cs.setString(2, word);
			cs.setString(3, order);
			cs.setString(4, desc);
			cs.setInt(5, (page-1)*perPage);
			cs.setInt(6, perPage);
			cs.execute();
			
			ResultSet rs=cs.getResultSet();
			
			JSONArray jArray=new JSONArray();
			
			while(rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("code", rs.getString("code"));
				obj.put("title", rs.getString("title"));
				obj.put("writer", rs.getString("writer"));
				/*DecimalFormat df=new DecimalFormat("#,###원");
				obj.put("price", df.format(rs.getInt("price")));  ~원으로 출력되는 포맷 */ 
				obj.put("price", rs.getInt("price"));
				jArray.add(obj);
				
			}
			jObject.put("list", jArray);//검색 목록
			
			cs.getMoreResults(); //다음 result로 이동
			
			rs=cs.getResultSet();
			int count=0;
			if(rs.next()) {
				count=rs.getInt("total");
			}
				jObject.put("count", count); // 전체 데이터 갯수
				jObject.put("page", page); //현재 페이지
				jObject.put("perPage", perPage); //페이지당 출력건수
				int totPage=count%perPage==0?count/perPage:count/perPage+1;
				jObject.put("totPage", totPage); //전체 페이지
					
		} catch(Exception e) {
			System.out.println("도서목록:" + e.toString());
		}
		
		return jObject;
	}
}
