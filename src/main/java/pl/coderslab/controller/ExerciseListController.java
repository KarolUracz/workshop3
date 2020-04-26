package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "exerciseList", urlPatterns = "/exerciseList")
public class ExerciseListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> allExercises = exerciseDao.findAllExercises();
        req.setAttribute("exercises", allExercises);
        req.getRequestDispatcher("/exerciseList.jsp");
    }
}
