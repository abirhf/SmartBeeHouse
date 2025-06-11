<%@ page import="java.util.*, entities.ruche" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
    
    <title>Liste des Ruches</title>
</head>
<body>

<h2>Liste des Ruches</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Nb Etages</th>
        <th>Nb Cadres</th>
        <th>Etat</th>
        <th>Productivite</th>
        <th>ID Site</th>
        <th>Actions</th>
    </tr>

    <%
        List<ruche> ruches = (List<ruche>) request.getAttribute("ruches");
        if (ruches != null) {
            for (ruche r : ruches) {
    %>
    <tr>
        <td><%= r.getId() %></td>
        <td><%= r.getNbEtages() %></td>
        <td><%= r.getNbCadres() %></td>
        <td><%= r.getEtat() %></td>
        <td><%= r.getProductivite() %></td>
        <td><%= r.getSiteId() %></td>
        <td>
            <form action="ruches" method="get" style="display:inline;">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="<%= r.getId() %>">
                <input type="submit" value="Modifier">
            </form>
            <form action="ruches" method="get" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= r.getId() %>">
                <input type="submit" value="Supprimer">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<h2>Ajouter une Ruche</h2>

<form action="ruches" method="post">
    Nombres des etages : <input type="number" name="nbEtages"><br>
    Nombres des cadres : <input type="number" name="nbCadres"><br>
    Etat : <input type="text" name="etat"><br>
    Productivite (1-3) : <input type="number" name="productivite" min="1" max="3"><br>
    ID Site : <input type="text" name="siteId"><br>
    <input type="submit" value="Ajouter">
</form>
<div style="text-align: center; margin-top: 30px;">
    <a href="<%= request.getContextPath() %>/pages/index.jsp">Retour a l'accueil</a>
</div>
</body>
</html>
