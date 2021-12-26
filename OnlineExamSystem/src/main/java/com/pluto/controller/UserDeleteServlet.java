package com.pluto.controller;

import com.pluto.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId;
        response.setContentType("text/html;charset=utf-8");
        UserDao dao=new UserDao();
        userId=request.getParameter("userId");
        int result=0;
        result=dao.delete(userId);
        PrintWriter writer = response.getWriter();
        if(result==1)
            writer.print("<font style='color:red;font-size=40'>用户信息删除成功</font>");
        else
            writer.print("<font style='color:red;font-size=40'>用户信息删除成功</font>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
