package ge.mziuri.servlet;

import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        eventID = CookieUtil.getCookieContent("eventIDCookie", request);
        userID = CookieUtil.getCookieContent("userIDCookie", request);
        int selection = Integer.parseInt(request.getParameter("selection"));
        ticketDAO.buyTicket(Integer.parseInt(eventID), Integer.parseInt(userID), selection); 
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        try {
            rd.forward(request, response);
        }
        
        catch(ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

