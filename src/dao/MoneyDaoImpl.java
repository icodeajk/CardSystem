package dao;

import db.DB;
import vo.money;
import vo.xiqu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by 22787 on 2017/12/2.
 */
public class MoneyDaoImpl {
	Map<String, String> map = new HashMap<>();
	private Connection conn = null;

	public MoneyDaoImpl() {
		conn = DB.getConn();
	}

	public boolean usemoney(String username1, int usemoney) {
		PreparedStatement prep = null;
		ResultSet rs = null;
		int usemoney1 = 0;
		boolean flag = false;
		try {
			prep = conn.prepareStatement("SELECT money FROM xiqu WHERE username=?");
			prep.setString(1, username1);
			rs = prep.executeQuery();
			while (rs.next()) {
				usemoney1 = usemoney;
				usemoney = rs.getInt("money") - usemoney;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (usemoney >= 0) {
			try {
				flag = true;
				prep = conn.prepareStatement("UPDATE xiqu SET money=? WHERE username=?");
				prep.setInt(1, usemoney);
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
			try {
				prep = conn.prepareStatement("INSERT into money(username,usemoney,usedata)VALUE (?,?,?)");
				prep.setString(1, username1);
				prep.setInt(2, usemoney1);
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH) + 1;// 注意月份
				int day = now.get(Calendar.DAY_OF_MONTH);
				int hour = now.get(Calendar.HOUR_OF_DAY);
				int minute = now.get(Calendar.MINUTE);
				String c = year + "." + month + "." + day + "," + hour + ":" + minute + "";
				// String c="1204";
				prep.setString(3, c);
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