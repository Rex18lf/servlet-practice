package com.pluto.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "applyServlet", value = "/applyServlet")
public class applyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,money;
        userName=request.getParameter("username");
        money=request.getParameter("money");
        Cookie card1=new Cookie("username",userName);
        Cookie card2=new Cookie("money",money);
        response.addCookie(card1);
        response.addCookie(card2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
