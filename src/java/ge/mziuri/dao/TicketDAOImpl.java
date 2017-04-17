
package ge.mziuri.dao;


import ge.mziuri.model.Event;
import ge.mziuri.model.Ticket;
import ge.mziuri.service.TicketService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TicketDAOImpl implements TicketDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private static final String STATUS = "ACTIVE"; //wanna change this if present date > event date
    
    public TicketDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void buyTicket(int EventID, int userID, int seat) {
        ResultSet result = null;
        TicketService service = new TicketService();
        try {
            service.processTicket(EventID, userID);
            service.updateSeats(EventID, seat);
            pstmt = con.prepareStatement("INSERT INTO TICKET(event_id, seat) VALUES(?, ?) RETURNING id;");
            pstmt.setInt(1, EventID);
            pstmt.setInt(2, seat);
            pstmt.execute();
            result = pstmt.getResultSet();
            int ticketID = 0;
  
            if(result.next()) {
                ticketID = result.getInt("id");
            }
            
            pstmt = con.prepareStatement("INSERT INTO TICKET_HISTORY(user_id, ticket_id, status) VALUES(?, ?, ?)");
            pstmt.setInt(1, userID);
            pstmt.setInt(2, ticketID);
            pstmt.setString(3, STATUS);
            pstmt.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public ArrayList getBoughtTickets(int user_id) { //wanna move some code to service
        ArrayList<Ticket> boughtTickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        try {
            pstmt = con.prepareStatement("SELECT * FROM TICKET_HISTORY WHERE user_id = ?");
            pstmt.setInt(1, user_id);
            ResultSet historyResult = pstmt.executeQuery();
            while(historyResult.next()) {
                int ticket_id = historyResult.getInt("ticket_id");
                ticket.setId(ticket_id);
                pstmt = con.prepareStatement("SELECT event_id FROM TICKET WHERE id = ?"); //wanna change event_id to event_name in db and add event_date
                pstmt.setInt(1, ticket_id);
                ResultSet ticketResult = pstmt.executeQuery();
                if(ticketResult.next()) {
                    Event event = new Event();
                    event.setId(ticketResult.getInt("event_id"));
                    ticket.setEvent(event);
                }
                boughtTickets.add(ticket);
            }
        }
        
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return boughtTickets;
    }
}
