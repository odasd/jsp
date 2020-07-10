package enroll;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import courses.CVO;


public class EDAO {
	
	public Connection con() throws Exception{
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "haksa";
        String password = "pass";
     
        Class.forName(driver);
        Connection connection=DriverManager.getConnection(url, user, password);
        return connection;
     }
	
	//Ư���л��� ��û�� ������û���
	public ArrayList<EVO> slist(String scode) throws Exception {
		ArrayList<EVO> list=new ArrayList<EVO>();
		String sql="select e.*, c.lname from enrollments e, courses c where scode=? and e.lcode=c.lcode order by edate desc";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, scode);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			EVO vo=new EVO();
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setEdate(rs.getString("edate"));
			vo.setGrade(rs.getInt("grade"));
			list.add(vo);
		}	
		return list;
	}
	
	//������û
	public int insert(String scode, String lcode) throws Exception {
		int cnt=0;
		String sql="{call add_enroll(?,?,?)}";
		CallableStatement cs=con().prepareCall(sql);
		cs.setString(1, scode);
		cs.setString(2, lcode);
		cs.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
		cs.execute();
		
		cnt=cs.getInt(3);
		
		return cnt;
	}
	
	//�������
	public void delete(String scode, String lcode) throws Exception {
		String sql="delete from enrollments where scode=? and lcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, scode);
		ps.setString(2, lcode);
		ps.execute();
	}
	
	//Ư�����¸� ��û�� �л����
		public ArrayList<EVO> clist(String lcode) throws Exception {
			ArrayList<EVO> list=new ArrayList<EVO>();
			String sql="select e.*, sname from enrollments e, students s where lcode=? and e.scode=s.scode";
			PreparedStatement ps=con().prepareStatement(sql);
			ps.setString(1, lcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EVO vo=new EVO();
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setEdate(rs.getString("edate"));
				vo.setGrade(rs.getInt("grade"));
				list.add(vo);
			}	
			return list;
		}
		
		public void update(EVO vo)throws Exception{
			String sql="update enrollments set grade=? where scode=? and lcode=?";
			PreparedStatement ps=con().prepareStatement(sql);
			ps.setInt(1, vo.getGrade());
			ps.setString(2, vo.getScode());
			ps.setString(3, vo.getLcode());
			ps.execute();
		}
}
