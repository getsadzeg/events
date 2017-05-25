package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Event;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventViewServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pt = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        EventDAO eventDAO = new EventDAOImpl();
        eventDAO = new EventDAOImpl();
        Event event = new Event();
        if (eventDAO.getEvent(id) != null) {
            event = eventDAO.getEvent(id);
            eventDAO.updateViews(id);
            request.setAttribute("name", event.getName());
            request.setAttribute("description", event.getDesc());
            request.setAttribute("date", event.getDate());
            request.setAttribute("price", event.getPrice());
            request.setAttribute("category", event.getCategory().toString());
            request.setAttribute("type", event.getType().toString());
            request.setAttribute("places", event.getPlaces());
            request.setAttribute("availableSeats", event.getAvailablePlaces());
            request.setAttribute("views", event.getViews());
            request.setAttribute("author", event.getOwner().getUsername());
            request.setAttribute("selling_ended", event.SELLING_ENDED());
            Cookie cookie = new Cookie("eventIDCookie", String.valueOf(id));
            response.addCookie(cookie);
            request.setAttribute("eventID", id);
            RequestDispatcher rd = request.getRequestDispatcher("event.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                ex.printStackTrace();
            }
        } else {
            pt.append("ღონისძიება ვერ მოიძებნა");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
