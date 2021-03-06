
package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Event;
import ge.mziuri.util.CookieUtil;
import ge.mziuri.util.ServletUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EventEditServlet extends HttpServlet {
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
        request.setAttribute("name", event.getName());
        request.setAttribute("desc", event.getDesc());
        request.setAttribute("date", event.getDate());
        request.setAttribute("category", event.getCategory().toString());
        RequestDispatcher rd = request.getRequestDispatcher("editE.jsp");
        try {
            rd.forward(request, response);
        } catch(ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
