package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.ferme_DAO;
import entities.ferme;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ferme_servlet extends HttpServlet {

    private ferme_DAO fermeDAO;

    @Override
    public void init() throws ServletException {
        fermeDAO = new ferme_DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            fermeDAO.deleteFerme(id);
            response.sendRedirect("fermes"); // redirection après suppression
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            ferme ferme = fermeDAO.getFermeById(id);
            request.setAttribute("ferme", ferme);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Editeferme.jsp");
            dispatcher.forward(request, response);
        } else {
            List<ferme> fermes = fermeDAO.getAllFermes();
            request.setAttribute("fermes", fermes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/fermes.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Récupération des données du formulaire
        String idStr = request.getParameter("id"); // pour différencier ajout / modification
        String nom = request.getParameter("nom");
        String localisation = request.getParameter("localisation");
        String proprietaire = request.getParameter("proprietaire");

        if (idStr != null && !idStr.isEmpty()) {
            // C’est une modification
            int id = Integer.parseInt(idStr);
            ferme ferme = new ferme(id, nom, localisation, proprietaire);
            fermeDAO.updateFerme(ferme);
        } else {
            // C’est un ajout
        	System.out.println("Ajout : " + nom + " - " + localisation + " - " + proprietaire);

            ferme ferme = new ferme(0, nom, localisation, proprietaire);
            fermeDAO.addFerme(ferme);
        }

        // Redirection après traitement
        response.sendRedirect("fermes");
    }
}
