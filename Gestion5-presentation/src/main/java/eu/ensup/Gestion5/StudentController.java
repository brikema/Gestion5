package eu.ensup.Gestion5;

import eu.ensup.gestion5.domain.Person;
import eu.ensup.gestion5.domain.Student;
import eu.ensup.gestion5.dto.CourseDTO;
import eu.ensup.gestion5.dto.PersonDTO;
import eu.ensup.gestion5.dto.StudentDTO;
import eu.ensup.gestion5.service.ConnectionService;
import eu.ensup.gestion5.service.CourseService;
import eu.ensup.gestion5.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="student", value="/student")
public class StudentController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }

    protected void operation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        PersonService personService = new PersonService();
        CourseService courseService = new CourseService();

        // On récupère la liste de tous les inscrits
        List<PersonDTO> listPerson = personService.getAll();
        //request.setAttribute("list",listPerson);

        // On affiche que les étudiants
        List<PersonDTO> listStudent = new ArrayList();
        for (int i = 0; i < listPerson.size(); i++) {
            if (listPerson.get(i) instanceof StudentDTO){
                listStudent.add(listPerson.get(i));
            }
        }

        request.setAttribute("list",listStudent);

        if (request.getParameter("getStudent")!=null) {
            int idStudent = Integer.parseInt(request.getParameter("getStudent"));
            PersonDTO student = personService.get(idStudent);
            request.setAttribute("student", student);
            request.getRequestDispatcher("getonestudent.jsp").forward(request, response);
        } else if (request.getParameter("modifyStudent")!=null) {
            int idStudent = Integer.parseInt(request.getParameter("modifyStudent"));
            String prenom = request.getParameter("firstname");
            String nom = request.getParameter("lastname");
            String adresse = request.getParameter("adress");
            String telephone = request.getParameter("phone");
            String naissance = request.getParameter("birthdate");
            String email = request.getParameter("email");

            personService.update(nom, email, adresse, telephone, prenom, "1234", 4, null, "/", 0);
            request.getRequestDispatcher("getstudents.jsp").forward(request, response);

        } else if (request.getParameter("deleteStudent")!=null) {
            int idStudent = Integer.parseInt(request.getParameter("deleteStudent"));
            personService.delete(idStudent);
            request.getRequestDispatcher("getstudents.jsp").forward(request, response);
        } else if (request.getParameter("linkCourseToStudent")!=null) {
            int idStudent = Integer.parseInt(request.getParameter("linkCourseToStudent"));
            PersonDTO student = personService.get(idStudent);
            request.setAttribute("student", student);


            List<CourseDTO> listCourse = courseService.getAll();
            request.setAttribute("courseList",listCourse);

            request.getRequestDispatcher("linkCourseToStudent.jsp").forward(request, response);

        } else if (request.getParameter("linkCourseToStudentAction")!=null) {

            PersonDTO etudiant = personService.get(Integer.parseInt(request.getParameter("linkCourseToStudentAction").split(" ")[1]));
            int idEtudiant = etudiant.getId();
            CourseDTO course = courseService.get(Integer.parseInt(request.getParameter("linkCourseToStudentAction").split(" ")[0]));
            int idCourse = course.getId();

            personService.linkToCourse(idEtudiant, idCourse);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("getstudents.jsp").forward(request, response);
        }

    }
}
