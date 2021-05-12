package eu.ensup.Gestion5;

import eu.ensup.gestion5.dto.CourseDTO;
import eu.ensup.gestion5.dto.PersonDTO;
//import eu.ensup.gestion5.service.CourseService;
import eu.ensup.gestion5.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="course", value="/course")
public class CourseController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }

    protected void operation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        CourseService courseService = new CourseService();

        List<CourseDTO> listCourse = courseService.getAll();
        request.setAttribute("list",listCourse);

        if (request.getParameter("getCourse")!=null) {
            int idCourse = Integer.parseInt(request.getParameter("getCourse"));
            CourseDTO course = courseService.get(idCourse);
            request.setAttribute("course", course);
            request.getRequestDispatcher("getonecourse.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("getcourse.jsp").forward(request, response);
        }


    }

}
