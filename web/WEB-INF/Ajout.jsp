<%@ page import="java.util.List" %>
<%@ page import="fr.eni.messages.LecteurMessage" %><%--
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
    <%
        List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodeErreur");
        if(listeCodesErreur!=null)
        {
    %>
    <p style="color:red;" >Erreur, le repas n'a pas pu être ajouté :</p>
    <%
        for(int codeErreur:listeCodesErreur)
        {
    %>
    <p style="color:red;"><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
    <%
            }
        }
    %>

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
