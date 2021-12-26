package com.pluto.dao;

import com.pluto.entities.Users;
import com.pluto.util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //    private JDBCutil tool=new JDBCutil();
    public int add(Users user) throws SQLException {
        Connection conn = JDBCutil.getConnection();
        String sql = "insert into users(userName, password,gender,email) values(?,?,?,?)";
        int result = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return result;
    }

    public List<Users> findAll()  {
        Connection conn = JDBCutil.getConnection();
        String sql="select * from users;";
        ResultSet res=null;
        List<Users> userList=new ArrayList<>();
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            res = ps.executeQuery();
            while(res.next()){
                Integer userId=res.getInt("userId");
                String userName=res.getString("userName");
                String password=res.getString("password");
                String gender=res.getString("gender");
                String email=res.getString("email");
                Users user=new Users(userId,userName,password,gender,email);
                userList.add(user);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public int delete(String userId){
        Connection conn=JDBCutil.getConnection();
        String sql="delete from users where userId=?";
        int result=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(userId));
            result=ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int login(String userName,String password){
        String sql="select count(*) as num from users where userName=? and password=?";
        Connection conn=JDBCutil.getConnection();
        int result=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                result=rs.getInt("num");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
