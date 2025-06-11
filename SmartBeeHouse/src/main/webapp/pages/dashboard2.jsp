<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Sites par Ferme</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/style.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<h2> Nombre de sites d'apiculture par ferme</h2>

<!-- Image décorative -->
<div style="text-align: center; margin-bottom: 20px;">
    <img src="<%= request.getContextPath() %>/images/site.png" alt="Sites" style="width: 320px; height: 200px;">
</div>

<!-- Tableau -->
<div class="dashboard">
    <table>
        <tr>
            <th>ID de la ferme</th>
            <th>Nombre de sites</th>
        </tr>

        <%
            Map<Integer, Integer> data = (Map<Integer, Integer>) request.getAttribute("data");
            if (data != null && !data.isEmpty()) {
                for (Entry<Integer, Integer> entry : data.entrySet()) {
        %>
        <tr>
            <td><%= entry.getKey() %></td>
            <td><%= entry.getValue() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2">Aucune donnée disponible</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<!-- Formulaire de filtre -->
<form action="dashboard2" method="get" style="text-align: center; margin-top: 20px;">
    <label for="fermeId"> Filtrer par ID de ferme :</label>
    <input type="number" name="fermeId" id="fermeId">
    <input type="submit" value="Filtrer">
</form>

<!-- Graphique -->
<canvas id="chartSites" width="400" height="200" style="display: block; margin: 30px auto;"></canvas>

<script>
    const ctx2 = document.getElementById('chartSites').getContext('2d');
    const data2 = {
        labels: [
            <% for (Map.Entry<Integer, Integer> entry : data.entrySet()) { %>
                "Ferme <%= entry.getKey() %>",
            <% } %>
        ],
        datasets: [{
            label: 'Nombre de sites',
            data: [
                <% for (Map.Entry<Integer, Integer> entry : data.entrySet()) { %>
                    <%= entry.getValue() %>,
                <% } %>
            ],
            backgroundColor: ['#f5b700', '#f9c74f', '#ffd166', '#f4a261', '#e76f51'],
            borderWidth: 1
        }]
    };

    new Chart(ctx2, {
        type: 'pie',
        data: data2,
        options: {
            responsive: true
        }
    });
</script>

<!-- Bouton retour -->
<div class="retour-accueil">
    <a href="<%= request.getContextPath() %>/pages/index.jsp"> Retour a l'accueil</a>
</div>

</body>
</html>
