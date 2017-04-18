package ge.mziuri.servlet;

import ge.mziuri.dao.CardDAO;
import ge.mziuri.dao.CardDAOImpl;
import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.Card;
import ge.mziuri.model.Event;
import ge.mziuri.model.Ticket;
import ge.mziuri.model.User;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { //don't forget to redirect to userInf
        String id = CookieUtil.getCookieContent("userIDCookie", request);
        TicketDAO ticketDAO = new TicketDAOImpl();
        EventDAO eventDAO = new EventDAOImpl();
        ArrayList<Ticket> boughtTickets = ticketDAO.getBoughtTickets(Integer.parseInt(id));
        request.setAttribute("BoughtTickets", boughtTickets);
        ArrayList<Event> myEvents = eventDAO.getAllEvents(Integer.parseInt(id));
        request.setAttribute("myEvents", myEvents);
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(Integer.parseInt(id));
        request.setAttribute("User", user);
        CardDAO cardDAO = new CardDAOImpl();
        Card card = cardDAO.getCardwithUserID(Integer.parseInt(id));
        request.setAttribute("Card", card);
    }

}
