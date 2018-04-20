package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DB;

public class CardDelDaoImpl {
	Map<String, String> map = new HashMap<>();
	private Connection conn = null;

	public CardDelDaoImpl() {
		conn = DB.getConn();
	}
	public boolean delCard(String username) {
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
		if(flag1==true) 
		 {
			
			try {
				flag=true;
				prep = conn.prepareStatement("delete from xiqu where username=?");
				prep.setString(1, username);
				prep.executeUpdate();
				prep = conn.prepareStatement("delete from lib where username=?");
				prep.setString(1, username);
				prep.executeUpdate();
				prep = conn.prepareStatement("delete from money where username=?");
				prep.setString(1, username);
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
		}else {
			flag=false;
		}
		return flag;
	}
	
}
