package ge.mziuri.servlet;

import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.model.Ticket;
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
        ArrayList<Ticket> boughtTickets = ticketDAO.getBoughtTickets(Integer.parseInt(id));
        request.setAttribute("BoughtTickets", boughtTickets);
    }

}
