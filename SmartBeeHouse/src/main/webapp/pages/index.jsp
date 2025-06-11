<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Smart Bee House - Accueil</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css">
</head>
<body>

<!-- Image ruche -->
<img src="<%= request.getContextPath() %>/images/ruche.jpg" alt="Ruche" class="header-image">

<h2>Bienvenue dans Smart Bee House 🐝</h2>

<div class="menu">
    <a href="/SmartBeeHouse/fermes">📋 Gérer les Fermes</a>
    <a href="/SmartBeeHouse/sites">📍 Gérer les Sites d’Apiculture</a>
    <a href="/SmartBeeHouse/ruches">🏠 Gérer les Ruches</a></div>
    <div class="menu">
    <a href="<%= request.getContextPath() %>/dashboard1">📊 Dashboard : Ruches par site d apiculture</a>
    <a href="<%= request.getContextPath() %>/dashboard2">📈 Dashboard : Sites par Ferme</a>
    
</div>

</body>
</html>
