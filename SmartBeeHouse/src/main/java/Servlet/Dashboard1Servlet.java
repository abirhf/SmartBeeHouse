package Servlet;

import java.io.IOException;
import java.util.Map;

import DAO.ruche_DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Dashboard1Servlet extends HttpServlet {

    private ruche_DAO rucheDAO;

    @Override
    public void init() throws ServletException {
        rucheDAO = new ruche_DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<Integer, Integer> data = rucheDAO.getNombreRuchesParSite();
        request.setAttribute("data", data);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dashboard1.jsp");
        dispatcher.forward(request, response);
    }
}
