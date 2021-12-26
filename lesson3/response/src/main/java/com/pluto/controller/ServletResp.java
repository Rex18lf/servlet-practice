package com.pluto.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletResp", value = "/ServletResp")
public class ServletResp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String result="<html>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print("B站");
        out.print("<html><body>");
        out.print("<h1>Java<br>MyBatis</h1>");
        out.print("<a href=\"https://www.bilibili.com\">b站</a>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
