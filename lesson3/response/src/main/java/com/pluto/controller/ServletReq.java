package com.pluto.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletReq", value = "/ServletReq")
public class ServletReq extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        System.out.println(request.getMethod());
        System.out.println("URL:"+url);
        String uri=request.getRequestURI();
        System.out.println("URI:"+uri);
        Enumeration<String> parameters = request.getParameterNames();
        while(parameters.hasMoreElements()){
            String nextElement = parameters.nextElement();
            String value = request.getParameter(nextElement);
            System.out.println(nextElement+":"+value);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String url = request.getRequestURL().toString();
        System.out.println(request.getMethod());
        System.out.println("URL:"+url);
        String uri=request.getRequestURI();
        System.out.println("URI:"+uri);
        Enumeration<String> parameters = request.getParameterNames();
        while(parameters.hasMoreElements()){
            String nextElement = parameters.nextElement();
            String value = request.getParameter(nextElement);
            System.out.println(nextElement+":"+value);
        }
    }
}
