package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import ge.mziuri.model.Event;
import ge.mziuri.model.User;
import ge.mziuri.util.CookieUtil;
import ge.mziuri.util.ServletUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventCreateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) { 
        response.setStatus(403);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        ServletUtil.setEncoding(request, response);
        String name = (String) request.getParameter("name");
        String description = (String) request.getParameter("desc");
        String date_string = (String) request.getParameter("date");
        String price = (String) request.getParameter("price");
        Category category = Category.valueOf((String) request.getParameter("category"));
        Type type = Type.valueOf((String) request.getParameter("type"));
        String places = (String) request.getParameter("places");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(date_string);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        Event event = new Event();
        String userID = CookieUtil.getDataFromRequest("userIDCookie", request);
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(Integer.parseInt(userID));
        event.setName(name);
        event.setDesc(description);
        event.setDate(date);
        event.setPrice(Double.parseDouble(price));
        event.setCategory(category);
        event.setType(type);
        event.setPlaces(Integer.parseInt(places));
        event.setOwner(user);
        EventDAO eventDAO = new EventDAOImpl();
        eventDAO.CreateEvent(event);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        try {
            rd.forward(request, response);
        }
        catch(ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
