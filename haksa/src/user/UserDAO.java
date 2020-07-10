package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Database;

public class UserDAO {
	
	//�α��� üũ
	public UserVO login(String id) {
		UserVO vo=new UserVO();
		try {
			String sql="select * from users where id=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			System.out.println("�α���üũ : " + e.toString());
		}
		return vo;
	}
	
	
	//ȸ�� �α��� üũ
		public UserVO company_login(String company_id) {
			UserVO vo=new UserVO();
			try {
				String sql="select * from company_users where company_id=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, Company_id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					vo.setCompany_id(rs.getString("Company_id"));
					vo.setPass(rs.getString("pass"));
					vo.setName(rs.getString("name"));
					vo.setEmail(rs.getString("Email"));
					vo.setTel(rs.getString("Tel"));
				}
			} catch(Exception e) {
				System.out.println("�α���üũ : " + e.toString());
			}
			return vo;
		}
		
		//���� �α���
		public UserVO cvs_login(String cvs_id) {
			UserVO vo=new UserVO();
			try {
				String sql="select * from cvs_users where cvs_id=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, cvs_id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					vo.setCvs_id(rs.getString("cvs_id"));
					vo.setPass(rs.getString("pass"));
					vo.setName(rs.getString("name"));
					vo.setEmail(rs.getString("Email"));
					vo.setTel(rs.getString("Tel"));
				}
			} catch(Exception e) {
				System.out.println("�α���üũ : " + e.toString());
			}
			return vo;
		}
}
