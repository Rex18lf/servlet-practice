package com.pluto.controller;

import com.pluto.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String password=request.getParameter("password");
        UserDao dao=new UserDao();
        int result=dao.login(userName,password);
//        PrintWriter writer = response.getWriter();
        if(result==1)
            response.sendRedirect("/system/index.html");
        else
            response.sendRedirect("/system/login_error.html");

    }
}
