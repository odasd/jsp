package professors;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import user.UserVO;

public class PDAO {
	public Connection con() throws Exception{
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "haksa";
        String password = "pass";
     
        Class.forName(driver);
        Connection connection=DriverManager.getConnection(url, user, password);
        return connection;
     }
	
	//���� ��� ���
	public ArrayList<PVO> list()throws Exception{
		ArrayList<PVO> list=new ArrayList<PVO>();
		String sql="select * from professors";
		PreparedStatement ps=con().prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			PVO vo=new PVO();
			vo.setPcode(rs.getString("pcode"));
			vo.setPname(rs.getString("pname"));
			vo.setDept(rs.getString("dept"));
			vo.setTitle(rs.getString("title"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHiredate(rs.getDate("hiredate"));
			list.add(vo);
		}
		return list;
	}
	
	//�������
	public void insert(PVO vo)throws Exception{
		String sql="insert into professors(pcode,pname,dept,title,hiredate,salary) values(?,?,?,?,sysdate,?)";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, vo.getPcode());
		ps.setString(2, vo.getPname());
		ps.setString(3, vo.getDept());
		ps.setString(4, vo.getTitle());
		ps.setInt(5, vo.getSalary());
		ps.execute();
	}
	
	//��������
	public void delete(String pcode)throws Exception{
		String sql="delete from professors where pcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, pcode);
		ps.execute();
	}
	
	//�����б�
	public PVO read(String pcode)throws Exception{
		PVO vo=new PVO();
		String sql="select * from professors where pcode=?";
		PreparedStatement ps=con().prepareStatement(sql);
		ps.setString(1, pcode);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			vo.setPcode(rs.getString("pcode"));
			vo.setPname(rs.getString("pname"));
			vo.setDept(rs.getString("dept"));
			vo.setTitle(rs.getString("title"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHiredate(rs.getDate("hiredate"));
		}
		return vo;
	}
	
	//��������
		public void update(PVO vo)throws Exception{
			String sql="update professors set pname=?, dept=?, title=?, salary=? where pcode=?";
			PreparedStatement ps=con().prepareStatement(sql);
			ps.setString(1, vo.getPname());
			ps.setString(2, vo.getDept());
			ps.setString(3, vo.getTitle());
			ps.setInt(4, vo.getSalary());
			ps.setString(5, vo.getPcode());
			ps.execute();
		}
		
		//Ư�������� ������, �����л����
		public JSONObject cslist(String pcode) throws Exception {
			JSONObject jObject=new JSONObject();
			String sql="{call out_cslist(?,?,?)}";
			CallableStatement cs=con().prepareCall(sql);
			cs.setString(1, pcode);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet crs=(ResultSet)cs.getObject(2);
			JSONArray cArray=new JSONArray();
			while(crs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("lcode", crs.getString("lcode"));
				obj.put("lname", crs.getString("lname"));
				obj.put("hours", crs.getString("hours"));
				obj.put("room", crs.getString("room"));
				cArray.add(obj);
			}
			jObject.put("cArray", cArray);
			
			ResultSet srs=(ResultSet)cs.getObject(3);
			JSONArray sArray=new JSONArray();
			while(srs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("scode", srs.getString("scode"));
				obj.put("sname", srs.getString("sname"));
				obj.put("dept", srs.getString("dept"));
				obj.put("year", srs.getString("year"));
				sArray.add(obj);
			}
			jObject.put("sArray", sArray);
			
			return jObject;
		}
}
