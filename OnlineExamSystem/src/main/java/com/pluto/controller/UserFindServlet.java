package com.pluto.controller;

import com.pluto.dao.UserDao;
import com.pluto.entities.Users;
import com.pluto.util.JDBCutil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.jar.JarEntry;

@WebServlet(name = "UserFindServlet", value = "/UserFindServlet")
public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        List<Users> list=dao.findAll();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<table border='2' align='center'>");
        writer.print("<tr>");
        writer.print("<td>用户编号</td>");
        writer.print("<td>用户姓名</td>");
        writer.print("<td>用户密码</td>");
        writer.print("<td>用户性别</td>");
        writer.print("<td>用户邮箱</td>");
        writer.print("<td>操作</td>");
        writer.print("</tr>");
        for (Users usr:list){
            writer.print("<tr>");
            writer.print("<td>"+usr.getUserId()+"</td>");
            writer.print("<td>"+usr.getUserName()+"</td>");
            writer.print("<td>"+usr.getPassword()+"</td>");
            writer.print("<td>"+usr.getGender()+"</td>");
            writer.print("<td>"+usr.getEmail()+"</td>");
            writer.print("<td><a href='/system/delete?userId="+usr.getUserId()+"'>删除用户</a></td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
