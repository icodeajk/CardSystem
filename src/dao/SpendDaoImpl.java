package dao;

import db.DB;

import vo.money;
import vo.xiqu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 22787 on 2017/12/4.
 */
public class SpendDaoImpl {
    private Connection conn;
    public SpendDaoImpl(){
        conn= DB.getConn();
    }
    public List<money> queryMoney(String username){
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<money> list=new ArrayList<money>();
        try {
            pstm=conn.prepareStatement("SELECT * FROM money WHERE username=?");
            pstm.setString(1,username);
            rs=pstm.executeQuery();
            while (rs.next()){
                money money=new money();
                money.setUsername(rs.getString("username"));
                money.setSpend(rs.getInt("usemoney"));
               money.setDate(rs.getString("usedata"));
               list.add(money);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}


        }
         return list;


    }
}
