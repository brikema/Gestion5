<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Gestion Etabissement - Inscription d'un élève</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
        <!-- <meta http-equiv="refresh" content="1"> -->

        <!-- External Libraries DNS -->
        <link href="https://fonts.googleapis.com/css2?family=Markazi+Text&family=Mukta&family=Roboto+Slab&family=Staatliches&display=swap" rel="stylesheet"> <!-- Google Fonts for the fonts -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.0/css/all.css"> <!-- Font Awesome for the icons -->
        <script type="text/javascript" src="script.js"  async defer></script>
    </head>
    <body>
    <main>

        <div class="main_grid_margeLeft"></div>
        <div class="main_grid_margeRight"></div>

        <div class="main_grid_content">
            <div class="page-java _row">
                <div class="page-java_header _col _col-12">
                    <h1>Gestion5</h1>
                </div>
                <div id="error-manager" class="_col _col-12 error-manager">
                    <ul id="error-manager-list">

                    </ul>
                </div>
                <div style="display:flex;" class="_col _col-12">
                <div class="page-java_content  _row">
                    <div class="_col _col-12">
                        <div class="list-click--borderless">
                            <a href="student" class="list-click_item">
                                <span class="list-click_item_text">Liste des étudiants</span>
                            </a>
                            <a href="course" class="list-click_item">
                                <span class="list-click_item_text">Liste des cours</span>
                            </a>
                            <a href="" class="list-click_item--line">
                            </a>
                            <a href="newstudent.jsp" class="list-click_item">
                                <span class="list-click_item_text">Inscrire un étudiant</span>
                            </a>
                            <a href="mark" class="list-click_item">
                                <span class="list-click_item_text">Noter un étudiant</span>
                            </a>
                            <a href="chart" class="list-click_item">
                                <span class="list-click_item_text">Consulter les statistiques</span>
                            </a>
                        </div>
                    </div>
                </div>
                </div>
                <div class="page-java_footer _row">
                    <span><i class="far fa-copyright"></i> Brice Martineau</span>
                </div>
            </div>
        </div>

    </main>
    </body>
</html>