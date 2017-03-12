
package ge.mziuri.dao;

import ge.mziuri.model.Card;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CardDAOImpl implements CardDAO {
    private Connection con;
    private PreparedStatement pstmt;
    
    public CardDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void updateMoney(double money, Card card) {
        try {
            pstmt = con.prepareStatement("UPDATE CARD SET money = ? WHERE id = ?");
            pstmt.setDouble(1, card.getMoney() + money);
            pstmt.setInt(2, card.getId());
            pstmt.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }  

    @Override
    public void updateCard(Card card) {
        try {
            pstmt = con.prepareStatement("UPDATE CARD SET cardCode = ?,"
                    + "passCode = ?, expirationDate = ? WHERE id = ?");
           pstmt.setString(1, card.getCode());
           pstmt.setString(2, card.getPasscode());
           pstmt.setDate(3, new Date(card.getExpDate().getTime())); 
           pstmt.setInt(4, card.getId());
           pstmt.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
