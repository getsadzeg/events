package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.model.Event;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventUpdateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("idCookie")) {
                id = Integer.parseInt(cookie.getValue());
            }
        }
        EventDAO eventDAO = new EventDAOImpl();
        Event event = eventDAO.getEvent(id);
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
    }
}
