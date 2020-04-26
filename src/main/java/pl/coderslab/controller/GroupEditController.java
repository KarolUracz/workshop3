package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editGroup", urlPatterns = "/editGroup")
public class GroupEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);
        GroupDao groupDao = new GroupDao();
        Group group = groupDao.readGroup(id);
        req.setAttribute("group", group);
        req.getRequestDispatcher("/editGroup.jsp").forward(req, resp);
    }
}
