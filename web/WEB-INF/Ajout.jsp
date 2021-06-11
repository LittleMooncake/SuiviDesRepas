<%--
  Created by IntelliJ IDEA.
  User: ydrouet2021
  Date: 10/06/2021
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout</title>
</head>
<body>
    <form method="post" action="ServletAjoutRepas">
        <label>Date</label>
        <input type="date" name="date">
        <br>
        <label>Heure</label>
        <input type="time" name="time">
        <br>
        <textarea name="aliments" cols="30" rows="5"></textarea>
        <br>
        <input type="submit">
    </form>
    <a href="index.jsp">Retour</a>
</body>
</html>
