package courses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import students.SVO;

public class CDAO {
	public Connection con() throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "haksa";
		String password = "pass";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);    
		return con;
    }
	
	//강좌목록출력
	public ArrayList<CVO> list()throws Exception{
		ArrayList<CVO> list=new ArrayList<CVO>();
		String sql="select c.*, pname from courses c, professors where pcode=instructor";
		PreparedStatement ps=con().prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			CVO vo=new CVO();
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setHours(rs.getInt("hours"));
			vo.setRoom(rs.getString("room"));
			vo.setPname(rs.getString("pname"));
			list.add(vo);
		}
		return list;
	}
	
	//교수가 강의하는 강좌목록출력
	public ArrayList<CVO> plist(String pcode)throws Exception{
		ArrayList<CVO> list=new ArrayList<CVO>();
		String sql="select c.*, pname from courses c, professors where pcode=instructor and pcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, pcode);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			CVO vo=new CVO();
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setHours(rs.getInt("hours"));
			vo.setRoom(rs.getString("room"));
			vo.setPname(rs.getString("pname"));
			list.add(vo);
		}
		return list;
	}
		
	//강좌등록
	public void insert(CVO vo)throws Exception{
		String sql="insert into courses(lcode,lname,room,hours,instructor) values(?,?,?,?,?)";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, vo.getLcode());
		ps.setString(2, vo.getLname());
		ps.setString(3, vo.getRoom());
		ps.setInt(4, vo.getHours());
		ps.setString(5, vo.getInstructor());
		ps.execute();
	}
	
	//강좌정보 읽기
	public CVO read(String lcode)throws Exception{
		CVO vo=new CVO();
		String sql="select * from courses where lcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, lcode);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setHours(rs.getInt("hours"));
			vo.setRoom(rs.getString("room"));
			vo.setInstructor(rs.getString("instructor"));
		}
		return vo;
	}
	
	//강좌삭제
	public void delete(String lcode)throws Exception{
		String sql="delete from courses where lcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, lcode);
		ps.execute();
	}
	
	//강좌수정
	public void update(CVO vo)throws Exception{
		String sql="update courses set lname=?,room=?,hours=?,instructor=? where lcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(5, vo.getLcode());
		ps.setString(1, vo.getLname());
		ps.setString(2, vo.getRoom());
		ps.setInt(3, vo.getHours());
		ps.setString(4, vo.getInstructor());
		ps.execute();
	}
}
