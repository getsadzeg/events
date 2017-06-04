package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.model.Event;
import ge.mziuri.util.CookieUtil;
import ge.mziuri.util.ServletUtil;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventUpdateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        ServletUtil.setEncoding(request, response);
        String id = "";
        id = CookieUtil.getDataFromRequest("eventIDCookie", request);
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
        try {
            response.sendRedirect("EventViewServlet?id=" + id);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
