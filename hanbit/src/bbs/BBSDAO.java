package bbs;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BBSDAO {
	
	//�Խñ� ����
	public void delete(int seqno) {
		try {
			String sql="delete from bbs where seqno=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setInt(1, seqno);
			ps.execute();
		} catch(Exception e) {
			System.out.println("�Խñ� ���� : " + e.toString());
		}
	
	}
	
	
	//�Խñ� ���б�
	public BBSVO read(int seqno) {
		BBSVO vo=new BBSVO();
		try {
			String sql="select * from bbs where seqno=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setInt(1, seqno);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setSeqno(rs.getInt("seqno"));
				vo.setWriter(rs.getString("writer"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				vo.setWdate(sdf.format(rs.getTimestamp("wdate")));
			}
			
			
		} catch(Exception e) {
			System.out.println("�Խñ� �б� : " + e.toString());
		}
		
		return vo;
	}
	
	
	//�Խ��� �۾���
	public boolean insert(BBSVO vo) {
		boolean success=false;
		try {
			String sql="insert into bbs(title, writer, content) values(?,?,?)";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			ps.execute();
			success=true;
		} catch(Exception e) {
			success=false;
			System.out.println("�Խ��� �۾���"  + e.toString());
		}
		
		
		return success;
	}
	
	//�Խ��� ������
	public JSONObject list(String key, String word, int page, int perPage, String order, String desc) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list('bbs',?,?,?,?,?,?)";
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
				obj.put("seqno", rs.getInt("seqno"));
				obj.put("title", rs.getString("title"));
				obj.put("writer", rs.getString("writer"));
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String wdate=sdf.format(rs.getTimestamp("wdate"));
				
				obj.put("wdate", rs.getString("wdate"));
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
			System.out.println(e.toString());
		}
		return jObject;
		
		
	}
}
