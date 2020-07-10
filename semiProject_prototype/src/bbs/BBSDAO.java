package bbs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.CallableStatement;

import database.Database;
import database.SqlVO;

public class BBSDAO {
	
	//게시글 등록하기
	public boolean insert(BBSVO vo) {
		boolean success=false;
		
		try {
			String sql="insert into bbs(title,contents,ulike,date) values(?,?,?,now())";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContents());
			ps.setInt(3, vo.getUlike());
			ps.execute();
			success=true;
		}catch(Exception e) {
			success=false;
			System.out.println("게시판 글쓰기:"+e.toString());
		}
		return success;
		
	}
	
	   public JSONObject list(SqlVO vo) {
	      JSONObject jobject = new JSONObject();
	      try {
	         String sql = "call list(?,?,?,?,?,?,?)";
	         CallableStatement cs =(CallableStatement) Database.CON.prepareCall(sql);
	         cs.setString(1, "bbs");
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
	            obj.put("bno", rs.getInt("bno"));
	            obj.put("title", rs.getString("title"));
	            obj.put("contents", rs.getString("contents"));
	            obj.put("ulike", rs.getInt("ulike"));
	            obj.put("dislike", rs.getInt("dislike"));
	            
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	            
	            String strDate = sdf.format(rs.getTimestamp("date"));
	            obj.put("date", strDate);
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
	         System.out.println("게시글목록" + e.toString());
	      }
	      return jobject;
	   }
}