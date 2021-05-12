package eu.ensup.Gestion5;

import eu.ensup.gestion5.domain.ERole;
import eu.ensup.gestion5.dto.PersonDTO;
import eu.ensup.gestion5.service.ConnectionService;
import eu.ensup.gestion5.service.PersonService;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="newstudent", value="/newstudent")
public class NewStudentController extends HttpServlet {


    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("gettttt");
        try {
            operation(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("posdtman");
        try {
            operation(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void operation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        HttpSession userSession = request.getSession();

        String prenom = request.getParameter("firstname");
        String nom = request.getParameter("lastname");
        String adresse = request.getParameter("adress");
        String telephone = request.getParameter("phone");
        String naissance = request.getParameter("birthdate");
        String email = request.getParameter("email");


        PersonService personService = new PersonService();
        personService.create(nom,email,adresse,telephone,prenom, "reza",4, null,"azre");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
