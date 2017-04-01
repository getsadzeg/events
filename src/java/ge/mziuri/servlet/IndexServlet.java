package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
       // response.setStatus(403);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* int id = 0;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("idCookie")) id = Integer.parseInt(cookie.getValue());
        } */
        try {
            EventDAO eventDAO = new EventDAOImpl();
            System.out.println("all events: " + eventDAO.getAllEvents());
            request.setAttribute("events", eventDAO.getAllEvents());
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        catch(IOException | ServletException e) {
            System.out.println(e.getMessage());
        }

    }
}
