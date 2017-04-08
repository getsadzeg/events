
package ge.mziuri.service;

import ge.mziuri.dao.CardDAO;
import ge.mziuri.dao.CardDAOImpl;
import ge.mziuri.dao.DatabaseUtil;
import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Card;
import ge.mziuri.model.Ticket;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TicketService {
    private Connection con;
    private PreparedStatement pstmt;
    
    public TicketService() {
        con = DatabaseUtil.getConnection();
    }
    public void processPayment(int EventID, int userID) {
        EventDAO eventDAO = new EventDAOImpl();
        ResultSet result = null;
        Card card = null;
        User user = new User();
        Ticket ticket = new Ticket();
        ArrayList boughtlist = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT price, author_username FROM EVENT where id = ?");
            pstmt.setInt(1, EventID);
            result = pstmt.executeQuery();
            double price = result.getDouble("price");
            //String author_username = result.getString("author_username");
            pstmt = con.prepareStatement("SELECT card_id FROM USER WHERE id = ?");
            pstmt.setInt(1, userID);
            user.setId(userID);
            boughtlist = user.getBoughtTickets();
            ticket.setEvent(eventDAO.getEvent(EventID));
            boughtlist.add(ticket);
            user.setBoughtT(boughtlist);
            int card_id = pstmt.executeQuery().getInt("card_id");
            double money = moneywithCardID(card_id);
            card.setMoney(money);
            card.setId(card_id);
            CardDAO cardDAO = new CardDAOImpl();
            cardDAO.updateMoney(money-price, card);
            pstmt = con.prepareStatement("SELECT card_id FROM USER WHERE author_username = ?");
            int author_card_id = pstmt.executeQuery().getInt("card_id");
            double author_money = moneywithCardID(author_card_id);
            card.setMoney(author_money);
            card.setId(author_card_id);
            cardDAO.updateMoney(author_money+price*(9/10), card);
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public double moneywithCardID(int card_id) {
        double money = 0.0;
        try {
            pstmt = con.prepareStatement("SELECT money FROM CARD WHERE id = ?");
            pstmt.setInt(1, card_id);
            money = pstmt.executeQuery().getDouble("money");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return money;
    }
    
    
}
