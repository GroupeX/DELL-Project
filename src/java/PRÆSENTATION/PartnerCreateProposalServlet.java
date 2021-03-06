
package PRÆSENTATION;

import DOMAIN.Controller;
import DOMAIN.Proposal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PartnerCreateProposalServlet", urlPatterns = {"/PartnerCreateProposalServlet"})
public class PartnerCreateProposalServlet extends HttpServlet {

    private Controller con = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String text = request.getParameter("text");
            String budget = request.getParameter("budget");
            String status = request.getParameter("status");
            String fk_partner_id = request.getParameter("sess_partner_id");
           
            con.createProposal(new Proposal(id, title, text, budget, status, fk_partner_id));
            Collection<Proposal> proposals = con.listPartnerPropasal(fk_partner_id);

            request.setAttribute("proposals", proposals);
            request.getRequestDispatcher("PartnerProposalStatus.jsp").forward(request, response);
            
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
