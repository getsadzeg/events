
package ge.mziuri.service;

import ge.mziuri.dao.CardDAO;
import ge.mziuri.dao.CardDAOImpl;
import ge.mziuri.dao.DatabaseUtil;
import ge.mziuri.model.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TicketService {
    private Connection con;
    private PreparedStatement pstmt;
    
    public TicketService() {
        con = DatabaseUtil.getConnection();
    }
    public void processPayment(int EventID, int userID) {
        Card card = null;
        try {
            pstmt = con.prepareStatement("SELECT price FROM EVENT where id = ?");
            pstmt.setInt(1, EventID);
            double price = pstmt.executeQuery().getDouble("price");
            pstmt = con.prepareStatement("SELECT card_id FROM USER WHERE id = ?");
            pstmt.setInt(1, userID);
            int card_id = pstmt.executeQuery().getInt("card_id");
            pstmt = con.prepareStatement("SELECT money FROM CARD WHERE id = ?");
            pstmt.setInt(1, card_id);
            int money = pstmt.executeQuery().getInt("money");
            card.setMoney(money);
            card.setId(card_id);
            CardDAO cardDAO = new CardDAOImpl();
            cardDAO.updateMoney(money-price, card);
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
