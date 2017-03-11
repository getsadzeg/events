
package ge.mziuri.service;

import ge.mziuri.dao.CardDAO;
import ge.mziuri.dao.CardDAOImpl;
import ge.mziuri.dao.DatabaseUtil;
import ge.mziuri.model.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TicketService {
    private Connection con;
    private PreparedStatement pstmt;
    
    public TicketService() {
        con = DatabaseUtil.getConnection();
    }
    public void processPayment(int EventID, int userID) {
        ResultSet result = null;
        Card card = null;
        try {
            pstmt = con.prepareStatement("SELECT price, author_username FROM EVENT where id = ?");
            pstmt.setInt(1, EventID);
            result = pstmt.executeQuery();
            double price = result.getDouble("price");
            String author_username = result.getString("author_username");
            pstmt = con.prepareStatement("SELECT card_id FROM USER WHERE id = ?");
            pstmt.setInt(1, userID);
            int card_id = pstmt.executeQuery().getInt("card_id");
            int money = moneywithCardID(card_id);
            card.setMoney(money);
            card.setId(card_id);
            CardDAO cardDAO = new CardDAOImpl();
            cardDAO.updateMoney(money-price, card);
            pstmt = con.prepareStatement("SELECT card_id FROM USER WHERE author_username = ?");
            int author_card_id = pstmt.executeQuery().getInt("card_id");
            int author_money = moneywithCardID(author_card_id);
            card.setMoney(author_money);
            card.setId(author_card_id);
            cardDAO.updateMoney(author_money+price*(9/10), card);
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int moneywithCardID(int card_id) {
        int money;
        try {
            pstmt = con.prepareStatement("SELECT money FROM CARD WHERE id = ?");
            pstmt.setInt(1, card_id);
            money = pstmt.executeQuery().getInt("money");
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return money;
    }
    
    
}
