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
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "haksa";
        String password = "pass";
     
        Class.forName(driver);
        Connection connection=DriverManager.getConnection(url, user, password);
        return connection;
     }
	
	public ArrayList<CVO> list()throws Exception{
		ArrayList<CVO> list=new ArrayList<CVO>();
		String sql="select c.*, pname from courses c, professors p where p.pcode=c.instructor";
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
	
	//학생등록
    public void insert(CVO vo)throws Exception{
        String sql="insert into courses(lcode,lname,hours,room,instructor) values(?,?,?,?,?)";
        PreparedStatement ps = con().prepareStatement(sql);
        ps.setString(1, vo.getLcode());
        ps.setString(2, vo.getLname());
        ps.setInt(3, vo.getHours());
        ps.setString(4, vo.getRoom());
        ps.setString(5, vo.getInstructor());
        ps.execute();
        con().close();
     }
	
	
	//학생삭제
	public void delete(String lcode)throws Exception{
		String sql="delete from courses where lcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, lcode);
		ps.execute();
	}
	
	//학생읽기
	public CVO read(String lcode)throws Exception{
		CVO vo=new CVO();
		String sql="select * from courses where lcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, lcode);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setHours(rs.getInt("hours"));
			vo.setRoom(rs.getString("room"));
			vo.setInstructor(rs.getString("instructor"));
		}
		return vo;
	}
	
	//학생수정
		public void update(CVO vo)throws Exception{
			String sql="update courses set lname=?, hours=?, room=?, instructor=? where lcode=?";
			PreparedStatement ps=con().prepareStatement(sql);
			ps.setString(1, vo.getLname());
			ps.setInt(2, vo.getHours());
			ps.setString(3, vo.getRoom());
			ps.setString(4, vo.getInstructor());
			ps.setString(5, vo.getLcode());
			ps.execute();
		}
}
