<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Collection Web App</title>
</head>
    <body>
        <h1><%= "Video Game Collection Web Application" %>
        </h1>
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
        <link href="http://fonts.cdnfonts.com/css/montserrat" rel="stylesheet">
    <br/>
            <a href = "addgame.jsp">
                <button class="buttonAdd"> Add Game </button>
            </a>
        </div>

            <a href = "listServlet">
                <button class = "buttonList"> View Collection </button>
            </a>
        </div>

        <br>
        <br>
        <p class = "intro"> Hello! This is my first project and is a web based application that represents a video game collection.
            It is built with MVC architecture and uses Servlets to handle requests along with Tomcat Apache as the
            server. It has CRUD functionality and allows you to dynamically modify the contents that is connected to MySQL.
        </p>
        <div class = "technologies">
            <p>
                 Technologies Used:
            </p>
            <ul>
                <li> Tomcat Apache Server (Server, WebContainer)</li>
                <li> Servlet (Request Handler)</li>
                <li> JSP (Java with HTML) </li>
                <li> MySQL (Database to store information)</li>
            </ul>
        </div>

        <div class = "dependencies">
            <p>
                Dependencies Needed:
            </p>
            <ul>
                <li> JSTL (Tag library that allows for control of JSP)</li>
                <li> JDBC (Allows for communication between Java and DB)</li>
                <li> Servlet </li>
            </ul>
        </div>

        </p>

        <br>




</body>
</html>