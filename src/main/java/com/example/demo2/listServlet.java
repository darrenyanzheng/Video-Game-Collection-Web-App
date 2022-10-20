package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "listServlet", value = "/listServlet")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listOfGames(request, response);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listOfGames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        CrudOperations crudOperations = new CrudOperations("jdbc:mysql://localhost:3306/games", "root", "password", "com.mysql.cj.jdbc.Driver");
        List<videoGame> listOfGames = crudOperations.listOfGames();
        request.setAttribute("listOfGames", listOfGames);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewcollection.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
