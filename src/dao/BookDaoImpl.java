package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import db.DB;

public class BookDaoImpl {
	Map<String, String> map = new HashMap<>();
	private Connection conn = null;

	public BookDaoImpl() {
		conn = DB.getConn();
	}
	public boolean tookbook(String username1, int bookid) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		int booknum = 0;
		String book=new String();
		boolean flag = false;
		try {
			prep = conn.prepareStatement("SELECT * FROM book WHERE bookid=?");
			prep.setInt(1, bookid);
			rs = prep.executeQuery();
			while (rs.next()) {
				booknum=rs.getInt("num")-1;
				book=rs.getString("book");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (booknum >= 0) {
			try {
				flag = true;
				prep = conn.prepareStatement("UPDATE book SET num=? WHERE bookid=?");
				prep.setInt(1, booknum);
				prep.setInt(2, bookid);
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
				prep = conn.prepareStatement("INSERT into lib(bookid,username,date,book)VALUE (?,?,?,?)");
				prep.setInt(1, bookid);
				prep.setString(2, username1);
			
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH) + 1;// 注意月份
				int day = now.get(Calendar.DAY_OF_MONTH);
				int hour = now.get(Calendar.HOUR_OF_DAY);
				int minute = now.get(Calendar.MINUTE);
				String c = year + "." + month + "." + day + "," + hour + ":" + minute + "";
				// String c="1204";
				prep.setString(3, c);
				prep.setString(4, book);
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
