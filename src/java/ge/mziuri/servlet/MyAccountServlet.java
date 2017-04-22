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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doEverything(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doEverything(request, response);
    }

    private void doEverything(HttpServletRequest request, HttpServletResponse response) {
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
        RequestDispatcher rd = request.getRequestDispatcher("userInf.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        String updateValue = (String) request.getParameter("updateValue");
        switch (updateValue) {
            case "userUpdate":
                String name = (String) request.getParameter("firstname");
                String surname = (String) request.getParameter("lastname");
                String password = (String) request.getParameter("password");
                user.setName(name);
                user.setSurname(surname);
                user.setPassword(password);
                userDAO.updateUser(user);
                break;
            case "cardUpdate":
                String cardCode = (String) request.getParameter("cardcode");
                String cardPass = (String) request.getParameter("passcode");
                String date_string = (String) request.getParameter("expDate");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
                Date expDate = null;
                try {
                    expDate = formatter.parse(date_string);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
                card.setCode(cardCode);
                card.setPasscode(cardPass);
                card.setExpDate(expDate);
                cardDAO.updateCard(card);
                break;
        }
    }

}
