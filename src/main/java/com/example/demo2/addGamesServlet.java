package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "add-Servlet", urlPatterns = "/add-Servlet")
public class addGamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deez get request was made");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("a post request was made");
        String name = request.getParameter("name");
        String platform = request.getParameter("platform");
        String publisher = request.getParameter("publisher");
        String beaten = request.getParameter("beaten");

        String date = request.getParameter("purchasedDate");



        try {
            videoGame videoGame = new videoGame(name, platform, publisher, beaten, date);
            System.out.println(videoGame);
            MyJDBC myJDBC = new MyJDBC();
            myJDBC.insert(videoGame);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
