
package ge.mziuri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TicketDAOImpl implements TicketDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private static final String STATUS = "ACTIVE";
    
    public TicketDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void buyTicket(int EventID, int userID) {
        try {
            pstmt = con.prepareStatement("INSERT INTO TICKET(event_id) VALUES(?) RETURNING id;");
            pstmt.setInt(1, EventID);
            pstmt.execute();
            ResultSet result = pstmt.getResultSet();
            int ticketID = result.getInt(1);
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
