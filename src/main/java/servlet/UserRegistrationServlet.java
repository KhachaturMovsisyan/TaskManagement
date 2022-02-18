package servlet;

import taskManagement.meneger.UserManager;
import taskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/addUser")
public class UserRegistrationServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        userManager.registerUser(user);
        req.setAttribute("allUsers",userManager.getAllUsers());

        req.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(req,resp);
    }
}
