package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "add-Servlet", urlPatterns = "/add-Servlet")
public class addServlet extends HttpServlet {
    private CrudOperations CrudOperations;

    public void init() {
        CrudOperations CrudOperations = new CrudOperations("jdbc:mysql://localhost:3306/jdbc", "root", "yAYEEtgus510", "com.mysql.cj.jdbc.Driver");
    }

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

        CrudOperations.insert(videoGame);
        response.sendRedirect("viewcollection.jsp");

    }





    private void listAllGames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        List<videoGame> listOfGames = CrudOperations.listOfGames();
        request.setAttribute("listOfGames", listOfGames);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewcollection.jsp");
        requestDispatcher.forward(request, response);


    }

}
