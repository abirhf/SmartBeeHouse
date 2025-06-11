<%@ page import="java.util.*, entities.site_apiculture" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
    
    <title>Liste des Sites d'Apiculture</title>
</head>
<body>

<h2>Liste des Sites d'Apiculture</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>Altitude</th>
        <th>Date de craation</th>
        <th>Date de cloture</th>
        <th>ID Ferme</th>
        <th>Actions</th>
    </tr>

    <%
        List<site_apiculture> sites = (List<site_apiculture>) request.getAttribute("sites");
        if (sites != null) {
            for (site_apiculture s : sites) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getLatitude() %></td>
        <td><%= s.getLongitude() %></td>
        <td><%= s.getAltitude() %></td>
        <td><%= s.getDateCreation() %></td>
        <td><%= s.getDateCloture() %></td>
        <td><%= s.getFermeId() %></td>
  <td>
    <div style="display: flex; justify-content: center; gap: 8px;">
        <form action="sites" method="get" style="margin: 0;">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="id" value="<%= s.getId() %>">
            <input type="submit" value="Modifier" class="btn-modifier">
        </form>

        <form action="sites" method="get" style="margin: 0;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="id" value="<%= s.getId() %>">
            <input type="submit" value="Supprimer" class="btn-supprimer">
        </form>
    </div>
</td>

    </tr>
    <%
            }
        }
    %>
</table>

<h2>Ajouter un Site</h2>

<form action="sites" method="post">
    Latitude : <input type="text" name="latitude"><br>
    Longitude : <input type="text" name="longitude"><br>
    Altitude : <input type="text" name="altitude"><br>
    Date de creation : <input type="date" name="dateCreation"><br>
    Date de cloture : <input type="date" name="dateCloture"><br>
    ID Ferme : <input type="text" name="fermeId"><br>
    <input type="submit" value="Ajouter">
</form>
<div style="text-align: center; margin-top: 30px;">
    <a href="<%= request.getContextPath() %>/pages/index.jsp"> Retour a l'accueil</a>
</div>
</body>
</html>
