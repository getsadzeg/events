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
import static ge.mziuri.service.MyAccountService.update;
import ge.mziuri.util.CookieUtil;
import ge.mziuri.util.ServletUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAccountServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doEverything(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doEverything(request, response);
    }

    private void doEverything(HttpServletRequest request, HttpServletResponse response) {
        ServletUtil.setEncoding(request, response);
        String id = CookieUtil.getDataFromRequest("userIDCookie", request);
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
        RequestDispatcher rd = request.getRequestDispatcher("userInf.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        String updateValue = (String) request.getParameter("updateValue");
        switch (updateValue) {
            case "userUpdate":
                update(request, user);
                break;
            case "cardUpdate":
                update(request, card);
                break;
        }
    }

}
