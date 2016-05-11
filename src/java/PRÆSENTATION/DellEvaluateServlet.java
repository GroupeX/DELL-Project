
package PRÆSENTATION;

import DOMAIN.Controller;
import DOMAIN.Proposal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DellEvaluateServlet", urlPatterns = {"/DellEvaluateServlet"})
public class DellEvaluateServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Controller con = new Controller();
            
            if(request.getParameter("proposalid") != null){
            String proposalid = request.getParameter("proposalid");
            
            Proposal p = con.findPropasal(proposalid);
            
            if(p != null){
            request.setAttribute("proposal", p);
            request.getRequestDispatcher("EvaluateProposal.jsp").forward(request, response);
            } else {
                response.sendRedirect("ShowProposalStatus.jsp");
            }
            }
            
            if(request.getParameter("ChangeStatusForId") != null){
                String id = request.getParameter("ChangeStatusForId");
                String status = request.getParameter("StatusChanged");
                
                con.changeProposalStatus(id, status);
            }
                
               response.sendRedirect("ShowProposalStatus.jsp");
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
