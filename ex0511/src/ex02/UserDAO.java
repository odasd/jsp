package ex02;
import java.sql.*;
import java.util.*;

public class UserDAO {
	public Connection con() throws Exception{
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";
      String user = "haksa";
      String password = "pass";

      Class.forName(driver);
      Connection con=DriverManager.getConnection(url, user, password);
      return con;
   }
	
	//목록출력
	public ArrayList<UserVO> list(){
		ArrayList<UserVO> list=new ArrayList<UserVO>();
		String sql="select * from tbl_user";
		try {
			PreparedStatement ps=con().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserVO vo=new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setUname(rs.getString("uname"));
				list.add(vo);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return list;
	}
}
