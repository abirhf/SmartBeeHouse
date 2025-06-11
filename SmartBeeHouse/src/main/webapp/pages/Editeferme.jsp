<%@ page import="entities.ferme" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier une Ferme</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
</head>
<body>

<h2>Modifier la Ferme</h2>

<%
    ferme f = (ferme) request.getAttribute("ferme");
    if (f == null) {
%>
    <p style="color:red; text-align:center;"> Erreur : la ferme est introuvable.</p>
    <p style="text-align:center;"><a href="fermes">Retour à la liste</a></p>
<%
    } else {
%>

<form action="fermes" method="post">
    <input type="hidden" name="id" value="<%= f.getId() %>">
    Nom : <input type="text" name="nom" value="<%= f.getNom() %>"><br>
    Localisation : <input type="text" name="localisation" value="<%= f.getLocalisation() %>"><br>
    Propriétaire : <input type="text" name="proprietaire" value="<%= f.getProprietaire() %>"><br>
    <input type="submit" value="Enregistrer les modifications">
</form>

<a href="fermes">Retour à la liste</a>

<%
    }
%>

</body>
</html>
