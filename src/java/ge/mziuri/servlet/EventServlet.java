
package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Event;
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
        int id = Integer.parseInt(request.getParameter("id"));
        EventDAO eventDAO = new EventDAOImpl();
        Event event = eventDAO.getEvent(id);
        request.setAttribute("name", event.getName());
        request.setAttribute("description", event.getDesc());
        request.setAttribute("date", event.getDate());
        request.setAttribute("price", event.getPrice());
        request.setAttribute("category", event.getCategory().toString());
        request.setAttribute("type", event.getType().toString());
        request.setAttribute("places", event.getPlaces());
        request.setAttribute("author", event.getAuthor().getUsername());
        RequestDispatcher rd = request.getRequestDispatcher("event.jsp");
        rd.forward(request, response);
    }
}
