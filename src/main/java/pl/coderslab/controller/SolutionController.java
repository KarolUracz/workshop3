package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "solution", urlPatterns = "/solution")
public class SolutionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);
        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.readSolution(id);
        req.setAttribute("solution", solution);
        req.getRequestDispatcher("/solution.jsp").forward(req, resp);
    }
}
