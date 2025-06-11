<%@ page import="entities.site_apiculture" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
    
    <title>Modifier un Site</title>
</head>
<body>

<h2>Modifier le Site</h2>

<%
    site_apiculture s = (site_apiculture) request.getAttribute("site");
%>

<form action="sites" method="post">
    <input type="hidden" name="id" value="<%= s.getId() %>">

    Latitude : <input type="text" name="latitude" value="<%= s.getLatitude() %>"><br>
    Longitude : <input type="text" name="longitude" value="<%= s.getLongitude() %>"><br>
    Altitude : <input type="text" name="altitude" value="<%= s.getAltitude() %>"><br>
    Date De Creation : <input type="date" name="dateCreation" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(s.getDateCreation()) %>"><br>
    Date De Cloture : 
    <input type="date" name="dateCloture" 
        value="<%= (s.getDateCloture() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(s.getDateCloture()) : "") %>"><br>
    ID Ferme : <input type="text" name="fermeId" value="<%= s.getFermeId() %>"><br>

    <input type="submit" value="Enregistrer les modifications">
</form>

<a href="sites">Retour a la liste</a>

</body>
</html>
