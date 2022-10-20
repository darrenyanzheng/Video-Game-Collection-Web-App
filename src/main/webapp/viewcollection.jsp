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
    <link href="${pageContext.request.contextPath}/resources/css/viewcollection.css" rel="stylesheet" >
    <link href="http://fonts.cdnfonts.com/css/montserrat" rel="stylesheet">
    <div class = "addButton">
        <a href = "addgame.jsp"> Add New Game </a>
    </div>
</head>
<body>
    <table class = "dataTable">
        <thead>
            <tr>
                <th>ID:</th>
                <th>Name:</th>
                <th>Platform:</th>
                <th>Publisher:</th>
                <th>Beaten:</th>
                <th>Date Bought:</th>
                <th>Modify: </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var = "videoGame" items="${listOfGames}" >
                <tr>
                    <td>
                        <c:out value = "${videoGame.id}" /> <td>
                        <c:out value = "${videoGame.name}" /> <td>
                        <c:out value = "${videoGame.platform}" /> <td>
                        <c:out value = "${videoGame.publisher}" /> <td>
                        <c:out value = "${videoGame.beaten}" /> <td>
                        <c:out value = "${videoGame.dateBought}" /> <td>
                            <a href = "editgame.jsp?videoGame_id=${videoGame.id}" ><button class = "buttonEdit">Edit</button></a>
                        <br>
                        <br>

                        <div id="deletebuttons">
                            <form method = post action = deleteServlet>
                                <input type="hidden" name="videoGame_id" value='${videoGame.id}' />
                                <input type="submit" value="Delete" class = "buttonDelete">
                            </form>
                        </div>

                    </td>
                </tr>
            </c:forEach>
        </tbody>



    </table>

</body>
</html>
