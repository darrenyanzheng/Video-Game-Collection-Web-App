package com.example.demo2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "deleteServlet", value = "/deleteServlet")
public class deleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            deleteGame(request, response);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("videoGame_id"));
        CrudOperations crudOperations = new CrudOperations("jdbc:mysql://localhost:3306/games", "root", "password", "com.mysql.cj.jdbc.Driver");
        crudOperations.deleteGame(id);
        response.sendRedirect("listServlet");
    }
}
