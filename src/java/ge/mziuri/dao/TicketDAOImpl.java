
package ge.mziuri.dao;


import ge.mziuri.model.Event;
import ge.mziuri.model.Ticket;
import ge.mziuri.service.TicketService;
import java.sql.Connection;
import java.sql.Date;
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
    public ArrayList getBoughtTickets(int user_id) {
        ArrayList<Ticket> boughtTickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        try {
            pstmt = con.prepareStatement("SELECT ticket_id FROM TICKET_HISTORY WHERE user_id = ?");
            pstmt.setInt(1, user_id);
            ResultSet historyResult = pstmt.executeQuery();
            if(historyResult.next()) {
                int ticket_id = historyResult.getInt("ticket_id");
                ticket.setId(ticket_id);
                pstmt = con.prepareStatement("SELECT event_id FROM TICKET WHERE id = ?");
                pstmt.setInt(1, ticket_id);
                ResultSet ticketResult = pstmt.executeQuery();
                if(ticketResult.next()) {
                    Event event = new Event();
                    int event_id = ticketResult.getInt("event_id");
                    event.setId(event_id);
                    pstmt = con.prepareStatement("SELECT name, date FROM EVENT WHERE id = ?");
                    pstmt.setInt(1, event_id);
                    ResultSet eventResult = pstmt.executeQuery();
                    if(eventResult.next()) {
                        event.setName(eventResult.getString("name"));
                        event.setDate(new Date(eventResult.getDate("Date").getTime()));
                    }
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
