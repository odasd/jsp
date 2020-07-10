package user;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bbs.Database;
import book.BookVO;

public class UserDAO {
	
	//���� ����
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
				System.out.println("ȸ������ ���� : " + e.toString());
			}
		}
		//���� ����
		public void delete(String id) {
			try {
				String sql="delete from userinfo where id=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, id);
				ps.execute();
			} catch(Exception e) {
				System.out.println("ȸ�� ���� : " + e.toString());
			}
		}
	
	
	//���� ����
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
			System.out.println("ȸ�� ����" + e.toString());
		}
		
		return vo;
	}
	//ȸ������
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
			System.out.println("ȸ������ : " + e.toString());
		}
		return jObject;
	}
	
	
	//�α��� üũ
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
			System.out.println("�α��� üũ : " + e.toString());
		}
		return vo;
	}
	
	
	
	//������� ���
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
			jObject.put("list", jArray);//�˻� ���
			
			cs.getMoreResults(); //���� result�� �̵�
			
			rs=cs.getResultSet();
			int count=0;
			if(rs.next()) {
				count=rs.getInt("total");
			}
				jObject.put("count", count); // ��ü ������ ����
				jObject.put("page", page); //���� ������
				jObject.put("perPage", perPage); //�������� ��°Ǽ�
				int totPage=count%perPage==0?count/perPage:count/perPage+1;
				jObject.put("totPage", totPage); //��ü ������
					
			
		} catch(Exception e) {
			System.out.println("ȸ�����:" + e.toString());
		}
		
		return jObject;
	}
}
