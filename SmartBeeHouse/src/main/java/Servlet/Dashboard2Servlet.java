package Servlet;

import DAO.SiteApiculture_DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class Dashboard2Servlet extends HttpServlet {

    private SiteApiculture_DAO siteDAO;

    @Override
    public void init() throws ServletException {
        siteDAO = new SiteApiculture_DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fermeIdStr = request.getParameter("fermeId");
        Map<Integer, Integer> data = new HashMap<>();

        if (fermeIdStr != null && !fermeIdStr.isEmpty()) {
            try {
                int id = Integer.parseInt(fermeIdStr);
                int count = siteDAO.getNombreSitesParFermeId(id); // méthode à créer
                data.put(id, count);
            } catch (NumberFormatException e) {
                // Ignorer ou loguer l'erreur
            }
        } else {
            data = siteDAO.getNombreSitesParFerme();
        }

        request.setAttribute("data", data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/dashboard2.jsp");
        dispatcher.forward(request, response);
    }
}
