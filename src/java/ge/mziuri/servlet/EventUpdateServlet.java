package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.model.Event;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventUpdateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String id = "";
        id = CookieUtil.getCookieContent("eventIDCookie", request);
        EventDAO eventDAO = new EventDAOImpl();
        Event event = eventDAO.getEvent(Integer.parseInt(id));
        String name = (String) request.getParameter("name");
        String description = (String) request.getParameter("desc");
        String date_string = (String) request.getParameter("date");
        Category category = (Category.valueOf((String) request.getParameter("category")));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
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
        request.setAttribute("name", name);
        request.setAttribute("description", description);
        request.setAttribute("date", date);
        request.setAttribute("price", event.getPrice());
        request.setAttribute("category", category.toString());
        request.setAttribute("type", event.getType().toString());
        request.setAttribute("places", event.getPlaces());
        request.setAttribute("freeplaces", event.getAvailablePlaces());
        request.setAttribute("author", event.getOwner().getUsername());
        RequestDispatcher rd = request.getRequestDispatcher("event.jsp");
        try {
            rd.forward(request, response);
        } catch(ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
