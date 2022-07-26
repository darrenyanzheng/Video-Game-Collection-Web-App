<%--
  Created by IntelliJ IDEA.
  User: darre
  Date: 7/18/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <link href="${pageContext.request.contextPath}/resources/css/addgame.css" rel="stylesheet" >
    <title>Add a Game</title>
    <link href="http://fonts.cdnfonts.com/css/montserrat" rel="stylesheet">

</head>
<body>
    <div class = "center">
        <h2> Add a Game </h2>
        <h3>
            <a href = "listServlet"> List Of Games </a>


        </h3>
        <form method = "post" action = "addServlet">
            <label for = "name"> Name:    </label>
            <input type = "text" id = "name" required name = "name">
            <br>
            <br>

            <label for = "platform"> Platform: </label>

            <select name = "platform" id = "platform" required>

                <option value = "gba"> Gameboy Advance</option>
                <option value = "n3ds"> Nintendo 3DS </option>
                <option value = "n64"> Nintendo 64 </option>
                <option value = "nds"> Nintendo DS </option>
                <option value = "ngc"> Nintendo Gamecube </option>
                <option value = "nswitch"> Nintendo Switch </option>
                <option value = "nwii"> Nintendo Wii </option>
                <option value = pc> PC </option>
                <option value = "ps1"> Playstation 1 </option>
                <option value = "ps2"> Playstation 2 </option>
                <option value = "ps3"> Playstation 3 </option>
                <option value = "ps4"> Playstation 4 </option>
                <option value = "ps5"> Playstation 5 </option>
                <option value = "psp"> Playstation Portable </option>
                <option value = "psvita"> Playstation vita </option>
                <option value = "xbox"> Xbox </option>
                <option value = "x360"> Xbox 360 </option>
                <option value = "xbone"> Xbox One </option>


            </select>
            <br>
            <br>

            <label for = "publisher"> Publisher: </label>
            <input type = "text" id = "publisher" required name = "publisher">
            <br>
            <br>

            <label for = "yesBeaten"> Beaten </label>
            <input type = "radio" id = "yesBeaten" name = "beaten" value = "yes">

            <label for = "noBeaten"> Not beaten </label>
            <input type = "radio" id = "noBeaten" name = "beaten" value = "no" checked>

            <br>
            <br>

            <label for = "purchasedDate"> Date Bought: </label>
            <input type = "date" id = "purchasedDate" required name = "purchasedDate">

            <br>
            <br>

            <input type = "submit" id = "submitButton">
        </form>
    </div>

</body>
</html>
