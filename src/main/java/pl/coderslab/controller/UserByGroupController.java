package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "users", urlPatterns = "/users")
public class UserByGroupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupidParam = req.getParameter("groupId");
        int groupId = Integer.parseInt(groupidParam);
        UserDao userDao = new UserDao();
        List<User> allByGroupId = userDao.findAllByGroupId(groupId);
        req.setAttribute("users", allByGroupId);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
