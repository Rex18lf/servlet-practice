package com.pluto.httpsession.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "oneServlet", value = "/oneServlet")
public class oneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName;
        goodsName=request.getParameter("goodsName");
        HttpSession session = request.getSession();
        Integer goodsNum=(Integer) session.getAttribute(goodsName);
        if(goodsNum==null)session.setAttribute(goodsName,1);
        else session.setAttribute(goodsName,1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
