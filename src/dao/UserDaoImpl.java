package dao;

import db.DB;
import vo.money;
import vo.xiqu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 22787 on 2017/12/1.
 */
public class UserDaoImpl {

    private Connection conn=null;
    public  UserDaoImpl(){
        conn= DB.getConn();
    }
    public String FindWork(String username1){
        PreparedStatement prep=null;
        ResultSet rs=null;
        String job=null;
        try {
            prep=conn.prepareStatement("SELECT * FROM xiqu WHERE username=?");
            prep.setString(1,username1);
            rs=prep.executeQuery();
            rs.next();
            job=rs.getString("work");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            if(prep!=null){
                try {
                    prep.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
        }
           return job;
    }
    public void rePassword(String username1,String password1){
        PreparedStatement prep=null;

        try {
            prep=conn.prepareStatement("UPDATE xiqu SET password=? WHERE username=?");
            prep.setString(1,password1);
            prep.setString(2,username1);
            prep.execute();



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(prep!=null){
                try {
                    prep.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
        }



    }
    public List<xiqu> queryAll(){

        PreparedStatement prep=null;
        ResultSet rs=null;
        List<xiqu> list=new ArrayList<xiqu>();
       try{
           prep=conn.prepareStatement("SELECT *FROM xiqu ");

             rs=prep.executeQuery();
             while(rs.next()){
                 xiqu xiqu=new xiqu();
                 xiqu.setUsername(rs.getString("username"));
                 xiqu.setPassword(rs.getString("password"));
                 xiqu.setMoney(rs.getInt("money"));
                 xiqu.setWork(rs.getString("work"));
                 xiqu.setDoor(rs.getInt("door"));
                 xiqu.setName(rs.getString("name"));
                 list.add(xiqu);
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
           if(prep!=null){
               try {
                   prep.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }}}
        return list;

    }



   public boolean loginUser(String username1,String password1){
       boolean flag=false;
       PreparedStatement prep=null;
       ResultSet rs=null;

       try {
           prep=conn.prepareStatement(" SELECT * FROM xiqu WHERE username=? AND password=?");
           prep.setString(1,username1);
           prep.setString(2,password1);
           rs=prep.executeQuery();
           if(rs.next()){
                flag=true;

           }

       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           if(rs!=null){
               try {
                   rs.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }}
           if(prep!=null){
               try {
                   prep.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }}
       }
       return flag;
   }
}
