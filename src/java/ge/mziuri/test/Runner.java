
package ge.mziuri.test;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.model.Ticket;
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        TicketDAO ticketDAO = new TicketDAOImpl();
        ArrayList<Ticket> list = ticketDAO.getBoughtTickets(1);
        for(Ticket ticket : list) {
            System.out.println(ticket.toString());
        }
    }
}
