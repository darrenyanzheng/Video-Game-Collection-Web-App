package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateServlet", value = "/updateServlet")
public class updateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateGame(request, response);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void updateGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String id = (request.getParameter("videoGame_id"));
        int videoGameid = Integer.parseInt(id);
        String name = request.getParameter("name");
        String platform = request.getParameter("platform");
        String publisher = request.getParameter("publisher");
        String beaten = request.getParameter("beaten");
        String date = request.getParameter("purchasedDate");

        videoGame videoGame = new videoGame(videoGameid, name, platform, publisher, beaten, date);
        CrudOperations crudOperations = new CrudOperations("jdbc:mysql://localhost:3306/games", "root", "password", "com.mysql.cj.jdbc.Driver");
        crudOperations.updateGame(videoGame);
        response.sendRedirect("listServlet");
    }
}
