package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.Database;

public class UserDAO {
	
	//���� �������� ����
	   public int count(String key, String word) {
	      int count=0;
	      try {
	         String sql="select count(id) total from userinfo where " + key + " like ? ";
	         //String sql="select count(*) total from goodsinfo where " + key + " like ? "; --�����Ŵ�
	         PreparedStatement ps=Database.CON.prepareStatement(sql);
	         ps.setString(1, "%" + word + "%");
	         ResultSet rs=ps.executeQuery();
	         if(rs.next()) { //�����Ͱ� �ϳ����� if�� ������
	            count=rs.getInt("total");
	         }
	      } catch(Exception e) {
	         System.out.println("��ü�������� ����" + e.toString());
	      }
	      
	      return count;
	   }
	
	public ArrayList<UserVO> list(String key, String word, int page, int perpagenum) {
		ArrayList<UserVO> list=new ArrayList<UserVO>();
		try {
			String sql="select * from userinfo where " + key + " like ? order by id desc limit ?, ?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			ps.setInt(2, ((page-1)*perpagenum));
			ps.setInt(3, perpagenum);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserVO vo=new UserVO();
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setJob(rs.getString("job"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
				
			}
		} catch(Exception e) {
			System.out.println("�Խ��� ��� : " + e.toString());
		}
		return list;
	}
}
