package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editUser", urlPatterns = "/editUser")
public class EditUserController extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);
        User user = userDao.readUser(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usernameParam = req.getParameter("username");
        String emailParam = req.getParameter("email");
        String passParam = req.getParameter("password");
        String groupIdParam = req.getParameter("groupId");
        int groupId = Integer.parseInt(groupIdParam);
        userDao.updateUser(new User(usernameParam, emailParam, passParam, groupId));
    }
}
