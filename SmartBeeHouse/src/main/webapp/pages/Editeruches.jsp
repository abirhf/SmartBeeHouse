<%@ page import="entities.ruche" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
    
    <title>Modifier une Ruche</title>
</head>
<body>

<h2>Modifier la Ruche</h2>

<%
    ruche r = (ruche) request.getAttribute("ruche");
%>

<form action="ruches" method="post">
    <input type="hidden" name="id" value="<%= r.getId() %>">

    Nb Étages : <input type="number" name="nbEtages" value="<%= r.getNbEtages() %>"><br>
    Nb Cadres : <input type="number" name="nbCadres" value="<%= r.getNbCadres() %>"><br>
    État : <input type="text" name="etat" value="<%= r.getEtat() %>"><br>
    Productivité : <input type="number" name="productivite" min="1" max="3" value="<%= r.getProductivite() %>"><br>
    ID Site : <input type="text" name="siteId" value="<%= r.getSiteId() %>"><br>

    <input type="submit" value="Enregistrer">
</form>

<a href="ruches">Retour à la liste</a>

</body>
</html>
