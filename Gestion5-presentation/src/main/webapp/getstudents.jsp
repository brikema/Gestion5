<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="eu.ensup.gestion5.dto.PersonDTO" %>
<%@ page import="java.util.List" %>
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
                    <a href="index.jsp" class="link-normal"><i class="fas fa-arrow-left"></i> Retour</a>
                    <h1>Liste des étudiants</h1>
                </div>
                <div id="error-manager" class="_col _col-12 error-manager">
                    <ul id="error-manager-list">

                    </ul>
                </div>
                <div style="display:flex;" class="_col _col-12">
                <form action="student" class="page-java_content  _row">
                    <div class="_col _col-12">
                        <input type="text" class="form-java_text-searchbar form-java_text _col _col-12 fAwesome" id="studentSearchBar" onkeyup="searchStudent()" placeholder="Chercher un étudiant...">
                        <div class="list-click--borderless">
                            <% for(PersonDTO e : (List<PersonDTO>) request.getAttribute("list")){ %>
                                    <a href="student" class="list-click_item">

                                        <button class="button-toReset" value="<%= e.getId() %>" name="getStudent" id="getStudent">
                                            <span class="list-click_item_text"><%= e.getFirstname() +" "+e.getLastname()%></span>
                                        </button>
                                    </a>

                            <% } %>
                        </div>
                    </div>
                </form>
                </div>
                <div class="page-java_footer _row">
                    <span><i class="far fa-copyright"></i> Brice Martineau</span>
                </div>
            </div>
        </div>

    </main>
    </body>
</html>