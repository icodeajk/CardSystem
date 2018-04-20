package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import vo.library;

/**
 * Created by 22787 on 2017/12/2.
 */
public class LibraryDaoImpI {

	private Connection conn = null;

	public LibraryDaoImpI() {
		conn = DB.getConn();
	}

	public List<library> queryAll() {

		PreparedStatement prep = null;
		ResultSet rs = null;
		List<library> list = new ArrayList<library>();
		try {
			prep = conn.prepareStatement("SELECT *FROM lib ORDER BY bookid");
			rs = prep.executeQuery();
			while (rs.next()) { 
				library libr = new library();
				libr.setUsername(rs.getString("username"));
				libr.setBookid(rs.getInt("bookid"));
				libr.setBook(rs.getString("book"));
				libr.setDate1(rs.getString("date"));

				list.add(libr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (prep != null) {
				try {
					prep.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;

	}
}
