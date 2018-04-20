package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DB;

public class CardDaoImpl {
	Map<String, String> map = new HashMap<>();
	private Connection conn = null;

	public CardDaoImpl() {
		conn = DB.getConn();
	}
	public boolean addCard(String username, String password,int door,String name,String work, int money) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		boolean flag1=false;
		boolean flag = false;
		try {
			prep = conn.prepareStatement("SELECT username FROM xiqu");
		
			rs = prep.executeQuery();
			while (rs.next()) {
				if(username.equals(rs.getString("username"))) {
					flag1=true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag1==true) {
			return flag;
		}
		else {
			
			try {
				flag=true;
				prep = conn.prepareStatement("INSERT into xiqu(username, password,door,name,work, money)VALUE (?,?,?,?,?,?)");
				prep.setString(1, username);
				prep.setString(2, password);
				prep.setInt(3, door);
				prep.setString(4, name);
				prep.setString(5,  work);
				prep.setInt(6,  money);
				prep.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (prep != null) {
					try {
						prep.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
	}
	
}
