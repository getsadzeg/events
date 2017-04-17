
package ge.mziuri.test;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.model.Event;
import ge.mziuri.model.Ticket;
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        EventDAO eventDAO = new EventDAOImpl();
        ArrayList<Event> list = eventDAO.getAllEvents(1);
        for(Event event : list) {
            System.out.println(event.toString());
        }
    }
}
