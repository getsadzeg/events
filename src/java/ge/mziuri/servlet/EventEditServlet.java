
package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Event;
import java.io.IOException;
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
        int id = 0;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("idCookie")) id = Integer.parseInt(cookie.getValue());
        }
        EventDAO eventDAO = new EventDAOImpl();
        Event event = eventDAO.getEvent(id);
        request.setAttribute("name", event.getName());
        request.setAttribute("desc", event.getDesc());
        request.setAttribute("date", event.getDate());
        request.setAttribute("category", event.getCategory().toString());
        Cookie cookie = new Cookie("idCookie", String.valueOf(id));
        response.addCookie(cookie);
        RequestDispatcher rd = request.getRequestDispatcher("editE.jsp");
        try {
            rd.forward(request, response);
        } catch(ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
