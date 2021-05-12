<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="eu.ensup.gestion5.dto.PersonDTO" %>
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
        <script type="text/javascript" src="script.js"  async defer></script>
    </head>
    <body>
    <main>

        <div class="main_grid_margeLeft"></div>
        <div class="main_grid_margeRight"></div>

        <div class="main_grid_content">
            <div class="page-java _row">
                <div class="page-java_header _col _col-12">
                    <a href="student" class="link-normal"><i class="fas fa-arrow-left"></i> Retour à la liste</a>
                    <h1><%= ((PersonDTO)request.getAttribute("student")).getFirstname() %> <%= ((PersonDTO)request.getAttribute("student")).getLastname() %></h1>
                </div>
                <div id="error-manager" class="_col _col-12 error-manager">
                    <ul id="error-manager-list">
                    </ul>
                </div>
                <div style="display:flex;" class="_col _col-12">
                    <form action="student" class="page-java_content  _row">
                            <div class="form-java_input-container _col _col-6 _col-sm-12">
                                <label class="form-java_label _col _col-12">Prénom</label>
                                <input name="firstname" id="firstname" class="form-java_text _col _col-12" value="<%= ((PersonDTO)request.getAttribute("student")).getFirstname() %>">
                            </div>
                            <div class="form-java_input-container _col _col-6 _col-sm-12">
                                <label class="form-java_label _col _col-12">Nom</label>
                                <input name="lastname" id="lastname"class="form-java_text _col _col-12" value="<%= ((PersonDTO)request.getAttribute("student")).getLastname() %>">
                            </div>
                            <div class="form-java_input-container _col _col-6 _col-sm-12">
                                <label class="form-java_label _col _col-12">Adresse</label>
                                <input name="adress" id="adress" class="form-java_text _col _col-12" value="<%= ((PersonDTO)request.getAttribute("student")).getAddress() %>">
                            </div>
                            <div class="form-java_input-container _col _col-6 _col-sm-12">
                                <label class="form-java_label _col _col-12">Téléphone</label>
                                <input name="phone" id="phone" class="form-java_text _col _col-12" value="<%= ((PersonDTO)request.getAttribute("student")).getPhoneNumber() %>">
                            </div>
                            <div class="form-java_input-container _col _col-6 _col-sm-12">
                                <label class="form-java_label _col _col-12">Date de Naissance</label>
                                <input name="birthdate" id="birthdate" class="form-java_text _col _col-12" type="date" value="">
                            </div>
                            <div class="form-java_input-container _col _col-6 _col-sm-12">
                                <label class="form-java_label _col _col-12">Email</label>
                                <input name="email" id="email" class="form-java_text _col _col-12" value="<%= ((PersonDTO)request.getAttribute("student")).getMailAddress() %>">
                            </div>
                            <div class="_col-12 _col">
                                <button class="button-square-reverse button-submit" value="<%= ((PersonDTO)request.getAttribute("student")).getId() %>" name="modifyStudent" id="modifyStudent"><i class="fas fa-edit"></i> Modifier</button>
                                <button class="button-error button-square-reverse button-submit" value="<%= ((PersonDTO)request.getAttribute("student")).getId() %>" name="deleteStudent" id="deleteStudent"><i class="fas fa-trash"></i> Supprimer</button>
                            </div>
                            <div class="_col-12 _col">
                                <button class="button-square-reverse button-submit" value="<%= ((PersonDTO)request.getAttribute("student")).getId() %>" name="linkCourseToStudent" id="linkCourseToStudent">Ajouter un cours</button>
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