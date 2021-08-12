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

@WebServlet(name = "SearchControl", urlPatterns = {"/SearchControl"})
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. ProcessRequest to get the digital news by title and list of most
     * recent news by function<code></code> Then forward to the home
     * <code>SearchResultPage.jsp</code>. If system is error or an unannounced
     * error, the class will redirect to an error page with error message on
     * that page.
     *
     * @param request is a <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response is a <code>HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String title = request.getParameter("txtSearch").trim();
            String pageIndex = request.getParameter("index");
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            int total = digitalDAO.count(title);
                int pageSize = 3;
                int maxPage = total / pageSize;
                if (total % pageSize != 0) {
                    maxPage++;
                }
                List<News> listSearch = digitalDAO.search(title, index, pageSize);
                request.setAttribute("list", listSearch);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("txt", title);
                request.setAttribute("index", index);

                //begin of set short description
                News top1 = digitalDAO.getTop(1).get(0);
                request.setAttribute("top1", top1);
                //end of set short description
                //begin of set list 
                List<News> list = digitalDAO.getTop(6);
                request.setAttribute("top5", list);
                //end of set list
                request.setAttribute("search", title);
                request.getRequestDispatcher("SearchResultPage.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Search Page Not Found");
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
