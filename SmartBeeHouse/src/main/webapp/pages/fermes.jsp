<%@ page import="java.util.*, entities.ferme" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
    
    <title>Liste des Fermes</title>
</head>
<body>

<h2>Liste des Fermes</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Localisation</th>
        <th>Proprietaire</th>
        <th>Actions</th>
    </tr>

    <%
        List<ferme> fermes = (List<ferme>) request.getAttribute("fermes");
        if (fermes != null) {
            for (ferme f : fermes) {
    %>
    <tr>
        <td><%= f.getId() %></td>
        <td><%= f.getNom() %></td>
        <td><%= f.getLocalisation() %></td>
        <td><%= f.getProprietaire() %></td>
        <td>
            <form action="fermes" method="get" style="display:inline;">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="<%= f.getId() %>">
                <input type="submit" value="Modifier">
            </form>
            <form action="fermes" method="get" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= f.getId() %>">
                <input type="submit" value="Supprimer">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<h2>Ajouter une Ferme</h2>

<form action="fermes" method="post">
    Nom : <input type="text" name="nom"><br>
    Localisation : <input type="text" name="localisation"><br>
    Proprietaire : <input type="text" name="proprietaire"><br>
    <input type="submit" value="Ajouter">
</form>
<div style="text-align: center; margin-top: 30px;">
    <a href="<%= request.getContextPath() %>/pages/index.jsp">Retour a l'accueil</a>
</div>

</body>
</html>
