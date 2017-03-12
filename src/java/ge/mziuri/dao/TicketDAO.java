
package ge.mziuri.dao;

import ge.mziuri.model.Event;


public interface TicketDAO {
    void buyTicket(int EventID, int userID);
}
