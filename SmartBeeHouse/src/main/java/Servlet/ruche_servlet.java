package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.ruche_DAO;
import entities.ruche;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ruche_servlet extends HttpServlet {

    private ruche_DAO rucheDAO;

    @Override
    public void init() throws ServletException {
        rucheDAO = new ruche_DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            rucheDAO.deleteRuche(id);
            response.sendRedirect("ruches");

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            ruche ruche = rucheDAO.getRucheById(id);
            request.setAttribute("ruche", ruche);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Editeruches.jsp");
            dispatcher.forward(request, response);

        } else {
            List<ruche> ruches = rucheDAO.getAllRuches();
            request.setAttribute("ruches", ruches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/ruches.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        int nbEtages = Integer.parseInt(request.getParameter("nbEtages"));
        int nbCadres = Integer.parseInt(request.getParameter("nbCadres"));
        String etat = request.getParameter("etat");
        int productivite = Integer.parseInt(request.getParameter("productivite"));
        int siteId = Integer.parseInt(request.getParameter("siteId"));

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            ruche ruche = new ruche(id, nbEtages, nbCadres, etat, productivite, siteId);
            rucheDAO.updateRuche(ruche);
        } else {
            ruche ruche = new ruche(0, nbEtages, nbCadres, etat, productivite, siteId);
            rucheDAO.addRuche(ruche);
        }

        response.sendRedirect("ruches");
    }
}
