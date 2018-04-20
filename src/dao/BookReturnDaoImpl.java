package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import db.DB;

public class BookReturnDaoImpl {
	Map<String, String> map = new HashMap<>();
	private Connection conn = null;

	public BookReturnDaoImpl() {
		conn = DB.getConn();
	}
	public boolean returnbook(String username1, int bookid) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		boolean flag = false;
		try {
			prep = conn.prepareStatement("SELECT * FROM lib WHERE username=? AND bookid=?");
			prep.setString(1, username1);
			prep.setInt(2, bookid);
			rs = prep.executeQuery();
			while (rs.next()) {
				flag=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag==true) {
			try {
				
				prep = conn.prepareStatement("UPDATE book SET num=num+1 WHERE bookid=?");
				prep.setInt(1, bookid);
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
			try {
				prep = conn.prepareStatement("delete from lib where bookid=? and username=?");
				prep.setInt(1, bookid);
				prep.setString(2, username1);
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
		} else {
			flag = false;
		}
		return flag;
	}
	
}
