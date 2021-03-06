package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	//전제 데이터의 갯수
	   public int count(String key, String word) {
	      int count=0;
	      try {
	         String sql="select count(code) total from goodsinfo where " + key + " like ? ";
	         //String sql="select count(*) total from goodsinfo where " + key + " like ? "; --같은거다
	         PreparedStatement ps=Database.CON.prepareStatement(sql);
	         ps.setString(1, "%" + word + "%");
	         ResultSet rs=ps.executeQuery();
	         if(rs.next()) { //데이터가 하나여서 if로 가져옴
	            count=rs.getInt("total");
	         }
	      } catch(Exception e) {
	         System.out.println("전체데이터의 갯수" + e.toString());
	      }
	      
	      return count;
	   }
	   
	   //도서목록 출력
	   public ArrayList<BookVO> list(String key, String word, int page) {
	      ArrayList<BookVO> list=new ArrayList<BookVO>();
	      try {
	         String sql="select * from goodsinfo where " + key + " like ? limit ? , 10 ";
	         PreparedStatement ps=Database.CON.prepareStatement(sql);
	         ps.setString(1, "%" + word + "%");
	         ps.setInt(2, ((page-1)*10));
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()) {
	            BookVO vo=new BookVO();
	            vo.setCode(rs.getString("code"));
	            vo.setTitle(rs.getString("title"));
	            vo.setWriter(rs.getString("writer"));
	            vo.setPrice(rs.getInt("price"));
	            list.add(vo);
	         }
	      } catch(Exception e) {
	         System.out.println("도서목록 출력 : " + e.toString());
	      }
	      return list;
	   }
}
