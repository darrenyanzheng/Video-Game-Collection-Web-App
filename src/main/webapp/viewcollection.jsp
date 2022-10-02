<%--
  Created by IntelliJ IDEA.
  User: darre
  Date: 7/31/2022
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>My Collection</title>
    <h3>
        <a href = "addgame.jsp"> Add New Game </a>

        <a href = "listServlet"> List Of Games </a>

    </h3>
</head>
<body>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID:</th>
            <th>Name:</th>
            <th>Platform:</th>
            <th>Publisher:</th>
            <th>Beaten:</th>
            <th>Date Bought:</th>
            <th>Modify: </th>
        </tr>
        <c:forEach var = "videoGame" items="${listOfGames}" >
            <tr>
                <td>
                    <c:out value = "${videoGame.id}" /> <td>
                    <c:out value = "${videoGame.name}" /> <td>
                    <c:out value = "${videoGame.platform}" /> <td>
                    <c:out value = "${videoGame.publisher}" /> <td>
                    <c:out value = "${videoGame.beaten}" /> <td>
                    <c:out value = "${videoGame.dateBought}" /> <td>

                    <a href = "editgame.jsp?videoGame_id=${videoGame.id}"><button>Edit</button></a>
                    <br>
                    <br>

                    <div id="deletebuttons">
                        <form method = post action = deleteServlet>
                            <input type="hidden" name="videoGame_id" value='${videoGame.id}' />
                            <input type="submit" value="Delete" >
                        </form>
                    </div>

                </td>
            </tr>
        </c:forEach>



    </table>

</body>
</html>
