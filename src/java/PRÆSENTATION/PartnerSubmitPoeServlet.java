package PRÆSENTATION;

import DOMAIN.Controller;
import DOMAIN.Proposal;
import DOMAIN.Poe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PartnerSubmitPoeServlet", urlPatterns = {"/PartnerSubmitPoeServlet"})
public class PartnerSubmitPoeServlet extends HttpServlet {

    private Controller con = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(request.getParameter("fk_prop_id") != null && request.getParameter("poe_link") != null){

                String poe_id = request.getParameter("");
                String fk_prop_id = request.getParameter("fk_prop_id");
                String poe_link = request.getParameter("poe_link");
                String poe_status = "0";
                con.uploadPoe(new Poe(poe_id,poe_link, poe_status, fk_prop_id));

                fk_prop_id = request.getParameter("fk_prop_id");

                
            
            request.getRequestDispatcher("PartnerCampaignInfoServlet?proposalid="+fk_prop_id+"").forward(request, response);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
