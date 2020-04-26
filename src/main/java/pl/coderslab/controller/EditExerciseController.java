package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editExercise", urlPatterns = "/editExercise")
public class EditExerciseController extends HttpServlet {
    ExerciseDao exerciseDao = new ExerciseDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);
        Exercise exercise = exerciseDao.readExercise(id);
        req.setAttribute("exercise", exercise);
        req.getRequestDispatcher("/editExercise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titleParam= req.getParameter("title");
        String descParam = req.getParameter("description");
        exerciseDao.updateExercise(new Exercise(titleParam, descParam));
    }
}
