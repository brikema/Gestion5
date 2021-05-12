package eu.ensup.Gestion5;

import eu.ensup.gestion5.dto.PersonDTO;
import eu.ensup.gestion5.dto.StudentDTO;
//import eu.ensup.gestion5.service.CourseService;
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

@WebServlet(name="chart", value="/chart")
public class ChartController extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }

    protected void operation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonService personService = new PersonService();

        List<PersonDTO> listPerson = personService.getAll();
        List<PersonDTO> listStudent = new ArrayList();
        for (int i = 0; i < listPerson.size(); i++) {
            if (listPerson.get(i) instanceof StudentDTO){
                listStudent.add(listPerson.get(i));
            }
        }

        int nbMauvais = 0;
        int nbMoyen = 0;
        int nbBon = 0;
        int nbExcellent = 0;

        for (int i = 0; i < listStudent.size(); i++) {
            if (personService.getAverage(listStudent.get(i).getId()) < 10){
                nbMauvais += 1;
            } else if (personService.getAverage(listStudent.get(i).getId()) > 10 && personService.getAverage(listStudent.get(i).getId()) < 14) {
                nbMoyen += 1;
            } else if (personService.getAverage(listStudent.get(i).getId()) > 14 && personService.getAverage(listStudent.get(i).getId()) < 17) {
                nbBon += 1;
            } else if (personService.getAverage(listStudent.get(i).getId()) > 17) {
                nbExcellent += 1;
            }
            listStudent.get(i).getId();
        }

        request.setAttribute("nbMauvais", nbMauvais);
        request.setAttribute("nbMoyen", nbMoyen);
        request.setAttribute("nbBon", nbBon);
        request.setAttribute("nbExcellent", nbExcellent);


        request.getRequestDispatcher("chart.jsp").forward(request, response);
    }
}
