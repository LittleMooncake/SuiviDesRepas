<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout repas</title>
</head>
<body>
    <h1> AJOUT </h1>
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
    <div>
    <form method="post" action="ServletAjoutRepas">
        <div>
            <label> date </label>
            <input type="date" name="date">
            <br>
            <label> heure </label>
            <input type="time" name="time">
            <br>
            <label> repas </label>
            <textarea name="repas" cols="30" rows="5"></textarea>
        </div>

        <div>
            <button type="submit"> </button>
            <a href="index.jsp">Retour</a>
        </div>
    </form>
    </div>

</body>
</html>
