
package ge.mziuri.dao;

import ge.mziuri.model.Card;
import ge.mziuri.service.TicketService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class TicketDAOImpl implements TicketDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private static final String STATUS = "ACTIVE";
    
    public TicketDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void buyTicket(int EventID, int userID, int seat) {
        ResultSet result = null;
        TicketService service = new TicketService();
        try {
            service.processPayment(EventID, userID);
            pstmt = con.prepareStatement("INSERT INTO TICKET(event_id, seat) VALUES(?, ?) RETURNING id;");
            pstmt.setInt(1, EventID);
            pstmt.setInt(2, seat);
            pstmt.execute();
            result = pstmt.getResultSet();
            int ticketID = 0;
  
            if(result.next()) {
                ticketID = result.getInt(1);
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
}
