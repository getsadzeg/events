package ge.mziuri.servlet;

import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyTicketServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(403);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        TicketDAO ticketDAO = new TicketDAOImpl();
        String eventID = "";
        String userID = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            switch (cookie.getName()) {
                case "eventIDCookie":
                    eventID = cookie.getValue();
                    break;
                case "userIDCookie":
                    userID = cookie.getValue();
                    break;
            }
        }
        int selection = Integer.parseInt(request.getParameter("selection"));
        
        ticketDAO.buyTicket(Integer.parseInt(eventID), Integer.parseInt(userID), selection); 
        //should notify user that they bought ticket
        
    }

}

