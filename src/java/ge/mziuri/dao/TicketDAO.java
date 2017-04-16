
package ge.mziuri.dao;

import java.util.ArrayList;


public interface TicketDAO {
    void buyTicket(int EventID, int userID, int seat);
    ArrayList getBoughtTickets(int user_id);
}
