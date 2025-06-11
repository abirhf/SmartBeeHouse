package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.SiteApiculture_DAO;
import entities.site_apiculture;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiteApiculture_servlet extends HttpServlet {

    private SiteApiculture_DAO siteDAO;

    @Override
    public void init() throws ServletException {
        siteDAO = new SiteApiculture_DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            siteDAO.deleteSite(id);
            response.sendRedirect("sites");

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            site_apiculture site = siteDAO.getSiteById(id);
            request.setAttribute("site", site);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Editesites.jsp");
            dispatcher.forward(request, response);

        } else {
            List<site_apiculture> sites = siteDAO.getAllSites();
            request.setAttribute("sites", sites);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Sites.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        double altitude = Double.parseDouble(request.getParameter("altitude"));
        int fermeId = Integer.parseInt(request.getParameter("fermeId"));

        Date dateCreation = null;
        Date dateCloture = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateCreation = sdf.parse(request.getParameter("dateCreation"));
            String dateClotureStr = request.getParameter("dateCloture");
            if (dateClotureStr != null && !dateClotureStr.isEmpty()) {
                dateCloture = sdf.parse(dateClotureStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            site_apiculture site = new site_apiculture(id, latitude, longitude, altitude, dateCreation, dateCloture, fermeId);
            siteDAO.updateSite(site);
        } else {        	System.out.println("DOPOST : latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude + ", fermeId=" + fermeId + ", dateCreation=" + dateCreation + ", dateCloture=" + dateCloture);


            site_apiculture site = new site_apiculture(0, latitude, longitude, altitude, dateCreation, dateCloture, fermeId);
            siteDAO.addSite(site);

        }

        response.sendRedirect("sites");
    }
}
