<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Ruches par Site</title>
    
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/style.css">
</head>
<body>

<h2> Nombre de ruches par site d apiculture</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID du site</th>
        <th>Nombre de ruches</th>
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
    <tr><td colspan="2">Aucune donnée trouvée.</td></tr>
<%
    }
%>
</table>

<div class="retour-accueil">
    <a href="<%= request.getContextPath() %>/pages/index.jsp"> Retour a l'accueil</a>
</div>
<div style="text-align: center; margin-bottom: 20px;">
    <img src="<%= request.getContextPath() %>/images/ruches1.avif" alt="Ruche" style="width: 120px; height: auto;">
</div>

<!-- Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<canvas id="chartRuches" width="800" height="400" style="display: block; margin: 0 auto;"></canvas>

<script>
    const ctx = document.getElementById('chartRuches').getContext('2d');

    const data = {
        labels: [
            <% for (Map.Entry<Integer, Integer> entry : ((Map<Integer, Integer>)request.getAttribute("data")).entrySet()) { %>
                "Site <%= entry.getKey() %>",
            <% } %>
        ],
        datasets: [{
            label: 'Nombre de ruches',
            data: [
                <% for (Map.Entry<Integer, Integer> entry : ((Map<Integer, Integer>)request.getAttribute("data")).entrySet()) { %>
                    <%= entry.getValue() %>,
                <% } %>
            ],
            backgroundColor: '#f5b700',
            borderColor: '#d4a017',
            borderWidth: 1
        }]
    };

    new Chart(ctx, {
        type: 'bar',
        data: data,
        options: {
            responsive: true,
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
</script>


</body>
</html>
