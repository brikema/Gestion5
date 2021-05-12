<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="eu.ensup.gestion5.dto.CourseDTO" %>
<%@ page import="eu.ensup.gestion5.dto.PersonDTO" %>
<%@ page import="eu.ensup.gestion5.dto.MarkDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>

<html lang="fr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Gestion Etabissement - Lister les étudiants</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
        <!-- <meta http-equiv="refresh" content="1"> -->

        <!-- External Libraries DNS -->
        <link href="https://fonts.googleapis.com/css2?family=Markazi+Text&family=Mukta&family=Roboto+Slab&family=Staatliches&display=swap" rel="stylesheet"> <!-- Google Fonts for the fonts -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.0/css/all.css"> <!-- Font Awesome for the icons -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script type="text/javascript" src="script.js"  async defer></script>
    </head>
    <body>
    <main>

        <div class="main_grid_margeLeft"></div>
        <div class="main_grid_margeRight"></div>

        <div class="main_grid_content">
            <div class="page-java _row">
                <div class="page-java_header _col _col-12">
                    <a href="index.jsp" class="link-normal"><i class="fas fa-arrow-left"></i> Retour</a>
                    <h1>Statistiques</h1>
                </div>
                <div id="error-manager" class="_col _col-12 error-manager">
                    <ul id="error-manager-list">
                    </ul>
                </div>
                <div style="display:flex;" class="_col _col-12">
                    <div action="mark" class="page-java_content  _row">
                        <canvas id="myChart"></canvas>
                    </div>
                </div>
                <div class="page-java_footer _row">
                    <span><i class="far fa-copyright"></i> Brice Martineau</span>
                </div>
            </div>
        </div>

    <script>

        var ctx = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Mauvais', 'Moyens', 'Bons', 'Excellents'],
                datasets: [{
                    label: 'Niveau des élèves',
                    data: [<%= request.getAttribute("nbMauvais") %>, <%= request.getAttribute("nbMoyen") %>, <%= request.getAttribute("nbBon") %>, <%= request.getAttribute("nbExcellent") %>],
                    backgroundColor: [
                        'rgb(20, 20, 20)',
                        'rgb(11, 106, 125)',
                        'rgb(17, 157, 164)',
                        'rgb(191, 219, 247)'

                    ],
                    borderColor: [
                        'rgb(20, 20, 20)',
                        'rgb(11, 106, 125)',
                        'rgb(17, 157, 164)',
                        'rgb(191, 219, 247)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

    </script>
    </main>
    </body>
</html>