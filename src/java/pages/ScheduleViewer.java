/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyJBDC;



/**
 *
 * @author becca
 */
public class ScheduleViewer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>DATE</th><th>BACKROOM RESTOCK</th><th>KITCHEN</th><th>BAR</th><th>SERVICE</th><th>DAY OFF</th></tr>");
        List<com.UserInput> list = MyJBDC.getAllDates();
        for (com.UserInput e:list) {
            //out.print("<tr><td>" + e.getID()+ "</td><td>" + e.getName()+ "</td><td>" + e.getReason()+ "</td><td>" + e.getTime()+ "</td><td>" + e.getDate() + "</td><td>" + "<input type='radio' name='deleteRadio' value='"+e.getID() + "'>" + "</td><tr>");
            out.print("<tr><td>" + e.getDate()+ 
                    "</td><td>" + e.getBR()+
                 
                    "</td><td>" + e.getKIT() +
                    "</td><td>" + e.getBAR() +
                    "</td><td>" + e.getSERVICE() +
                    "</td><td>" + e.getDF() 

               
                   );
            
        }
 
        out.print("</table>");
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
