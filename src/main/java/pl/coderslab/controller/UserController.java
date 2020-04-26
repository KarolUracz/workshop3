package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParam = req.getParameter("id");
        int id = Integer.parseInt(userIdParam);
        UserDao userDao = new UserDao();
        User user = userDao.readUser(id);
        req.setAttribute("user", user);
        SolutionDao solutionDao = new SolutionDao();
        List<Solution> allSolutionsByUserId = solutionDao.findAllSolutionsByUserId(id);
        req.setAttribute("solutions", allSolutionsByUserId);
        req.getRequestDispatcher("/user.jsp").forward(req, resp);

    }
}
