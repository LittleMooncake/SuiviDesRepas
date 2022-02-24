<%@ page import="java.util.List" %>
<%@ page import="fr.eni.bo.Repas" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.eni.bo.Aliments" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Historique </title>
</head>
<body>
    <h1> HISTORIQUE </h1>
    <table>
        <tr>
            <th> Date </th>
            <th> Heure </th>
            <th> Action </th>
        </tr>
        <%
            List<Repas> listeRepas = (List<Repas>) request.getAttribute("historique");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEEE dd MM yyyy");
            for (Repas repas : listeRepas){
        %>
        <tr>
            <td><%= repas.getDateRepas().format(formatter) %></td>
            <td><%= repas.getHeureRepas().toString() %></td>
            <td>
                <% for (Aliments aliments : repas.getAliments()){%>
                <%= aliments.getNom() %>
                <br>
                <% } %>
            </td>
        </tr>
        <%
            }
        %>
    </table>


    <a href="ServletAjoutRepas">Ajouter un nouveau repas</a>
    <br>
    <a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
