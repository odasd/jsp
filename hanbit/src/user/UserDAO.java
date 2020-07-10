package user;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bbs.Database;
import book.BookVO;

public class UserDAO {
	
	//유저 수정
		public void update(UserVO vo) {
			try {
				String sql="update userinfo set name=?, job=?, tel=? where id=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getJob());
				ps.setString(3, vo.getTel());
				ps.setString(4, vo.getId());
				ps.execute();
				
			} catch(Exception e) {
				System.out.println("회원정보 수정 : " + e.toString());
			}
		}
		//유저 삭제
		public void delete(String id) {
			try {
				String sql="delete from userinfo where id=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, id);
				ps.execute();
			} catch(Exception e) {
				System.out.println("회원 삭제 : " + e.toString());
			}
		}
	
	
	//유저 정보
	public UserVO read(String id) {
		UserVO vo=new UserVO();
		try {
			String sql="select * from userinfo where id=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setJob(rs.getString("job"));
				vo.setTel(rs.getString("tel"));
				ps.execute();
			}
		} catch(Exception e) {
			System.out.println("회원 정보" + e.toString());
		}
		
		return vo;
	}
	//회원가입
	public JSONObject insert(UserVO vo) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call add_user(?,?,?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, vo.getId());
			cs.setString(2, vo.getPassword());
			cs.setString(3, vo.getName());
			cs.setString(4, vo.getJob());
			cs.setString(5, vo.getTel());
			cs.registerOutParameter(6, java.sql.Types.INTEGER);
			cs.execute();
			jObject.put("count", cs.getInt(6));
			
		} catch(Exception e) {
			System.out.println("회원가입 : " + e.toString());
		}
		return jObject;
	}
	
	
	//로그인 체크
	public UserVO loginCheck(String id, String password) {
		UserVO vo=new UserVO();
		try {
			String sql="select * from userinfo where id=? and password=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			System.out.println("로그인 체크 : " + e.toString());
		}
		return vo;
	}
	
	
	
	//유저목록 출력
	public JSONObject list(String key, String word, int page, int perPage, String order, String desc) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list('userinfo',?,?,?,?,?,?)";
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
				obj.put("name", rs.getString("name"));
				obj.put("id", rs.getString("id"));
				obj.put("password", rs.getString("password"));
				obj.put("job", rs.getString("job"));
				obj.put("tel", rs.getString("tel"));
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
			System.out.println("회원목록:" + e.toString());
		}
		
		return jObject;
	}
}
