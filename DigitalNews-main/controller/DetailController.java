package controller;

import dao.DigitalDAO;
import dao.impl.DigitalDAOImpl;
import entity.News;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DetailControl", urlPatterns = {"/DetailControl"})
public class DetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * ProcessRequest to get digital news by id get data, then forward to the home <code>HomePage.jsp</code>
     * If system is error or an unannounced error, the class will redirect to an error page with error message on that page.
     *
     * @param request is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response is a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //begin of set one
            int id = Integer.parseInt(request.getParameter("id"));
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            News d = digitalDAO.getNewsById(id);
            request.setAttribute("one", d);
            //end of set one
            //begin of set short description
            News top1 = digitalDAO.getTop(1).get(0);
            request.setAttribute("top1", top1);
            //end of set short description
            List<News> list = digitalDAO.getTop(6);
            request.setAttribute("top6", list);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
