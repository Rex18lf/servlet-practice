package com.pluto.controller;

import com.pluto.dao.UserDao;
import com.pluto.entities.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserAddServlet", value = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName, password, gender, email;
        UserDao dao = new UserDao();
        Users usr = null;
        int result = 0;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        gender = request.getParameter("gender");
        email = request.getParameter("email");
        usr = new Users(null, userName, password, gender, email);
        try {
            result = dao.add(usr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out=response.getWriter();
        if(result==1)
            out.print("<font style='color:red;font-size=40'>用户信息注册成功</font>");
        else
            out.print("<font style='color:red;font-size=40'>用户信息注册失败</font>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
