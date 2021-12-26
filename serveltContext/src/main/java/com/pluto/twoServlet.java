package com.pluto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "twoServlet", value = "/twoServlet")
public class twoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application=request.getServletContext();
        Integer data=(Integer) application.getAttribute("key1");
        System.out.println(data);
        Cookie card=new Cookie("key1","abc");
        response.addCookie(card);
        Cookie[] cookie=request.getCookies();
        for(Cookie cookie1:cookie){
            String key = card.getName();
            String value=card.getValue();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
