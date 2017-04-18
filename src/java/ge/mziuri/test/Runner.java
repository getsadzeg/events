
package ge.mziuri.test;

import ge.mziuri.dao.CardDAO;
import ge.mziuri.dao.CardDAOImpl;
import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.dao.TicketDAO;
import ge.mziuri.dao.TicketDAOImpl;
import ge.mziuri.model.Event;
import ge.mziuri.model.Ticket;
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        CardDAO cardDAO = new CardDAOImpl();
        System.out.println(cardDAO.getCardwithUserID(1).toString());
    }
}
