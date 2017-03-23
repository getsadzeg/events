package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import ge.mziuri.model.Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventViewEditServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("freeplaces", event.getAvailablePlaces());
        request.setAttribute("author", event.getAuthor().getUsername());
        String actionType = request.getParameter("actionType");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if (actionType != null && actionType.equals("edit")) {
            RequestDispatcher rd = request.getRequestDispatcher("editE.jsp");
            rd.forward(request, response);
            String name = (String) request.getAttribute("name");
            String description = (String) request.getAttribute("desc");
            String date_string = (String) request.getAttribute("date");
            Category category = (Category.valueOf((String) request.getAttribute("category")));
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = null;
            try {
                date = formatter.parse(date_string);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            event.setName(name);
            event.setDesc(description);
            event.setDate(date);
            event.setCategory(category);
            eventDAO.UpdateEvent(event);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("event.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
