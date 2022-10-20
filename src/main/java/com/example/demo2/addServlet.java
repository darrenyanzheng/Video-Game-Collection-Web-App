package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "addServlet", urlPatterns = "/addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            addGame(request, response);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void addGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String name = request.getParameter("name");
        String platform = request.getParameter("platform");
        String publisher = request.getParameter("publisher");
        String beaten = request.getParameter("beaten");
        String date = request.getParameter("purchasedDate");

        videoGame videoGame = new videoGame(name, platform, publisher, beaten, date);
        CrudOperations crudOperations = new CrudOperations("jdbc:mysql://localhost:3306/games", "root", "password", "com.mysql.cj.jdbc.Driver");

        crudOperations.insert(videoGame);
        response.sendRedirect("listServlet");


    }



}
