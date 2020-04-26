package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numberSolutions = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        SolutionDao solutionDao = new SolutionDao();
        List<Solution> recentSolutions = solutionDao.findRecent(numberSolutions);
        req.setAttribute("recentSolutions", recentSolutions);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
