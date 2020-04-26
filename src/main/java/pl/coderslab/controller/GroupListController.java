package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "groupList", urlPatterns = "/groupList")
public class GroupListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupDao groupDao = new GroupDao();
        List<Group> allGroups = groupDao.findAllGroups();
        System.out.println(allGroups);
        req.setAttribute("groupList", allGroups);
        req.getRequestDispatcher("/groupList.jsp").forward(req, resp);
    }
}
