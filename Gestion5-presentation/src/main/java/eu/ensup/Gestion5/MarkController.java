package eu.ensup.Gestion5;

import eu.ensup.gestion5.dto.CourseDTO;
import eu.ensup.gestion5.dto.MarkDTO;
import eu.ensup.gestion5.dto.PersonDTO;
import eu.ensup.gestion5.dto.StudentDTO;
//import eu.ensup.gestion5.service.CourseService;
//import eu.ensup.gestion5.service.MarkService;
import eu.ensup.gestion5.service.PersonService;
import eu.ensup.gestion5.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="mark", value="/mark")
public class MarkController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }

    protected void operation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonService personService = new PersonService();
        MarkService markService = new MarkService();
        CourseService courseService = new CourseService();

        List<PersonDTO> listPerson = personService.getAll();
        List<PersonDTO> listStudent = new ArrayList();
        for (int i = 0; i < listPerson.size(); i++) {
            if (listPerson.get(i) instanceof StudentDTO){
                listStudent.add(listPerson.get(i));
            }
        }
        request.setAttribute("listPerson", listStudent);

        List<CourseDTO> listCourse = courseService.getAll();
        request.setAttribute("listCourse", listCourse);

        if (request.getParameter("createMark")!=null) {

            int personMark = Integer.parseInt(request.getParameter("personMark"));
            int courseMark = Integer.parseInt(request.getParameter("courseMark"));
            Float markMark = Float.parseFloat(request.getParameter("mark"));
            String assessment = request.getParameter("assessment");

            MarkDTO mark = new MarkDTO();
            mark.setIdStudent(personMark);
            mark.setIdCourse(courseMark);
            mark.setMark(markMark);
            mark.setAssessment(assessment);
            markService.create(mark);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("getmark.jsp").forward(request, response);
        }
    }

}
