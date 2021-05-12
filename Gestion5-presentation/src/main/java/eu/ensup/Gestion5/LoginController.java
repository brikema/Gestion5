package eu.ensup.Gestion5;

import eu.ensup.gestion5.service.ConnectionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="login", value="/login")
public class LoginController extends HttpServlet {


    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operation(request, response);
    }

    protected void operation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ConnectionService connectionService = new ConnectionService();
       int id = connectionService.checkConnection(login, password);
        if (id != 0)
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }
}
