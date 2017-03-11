
package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EventServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    //demo
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* request.setAttribute("description", "rame");
        RequestDispatcher rd = request.getRequestDispatcher("event.jsp");
        rd.forward(request, response); */
    }
}
