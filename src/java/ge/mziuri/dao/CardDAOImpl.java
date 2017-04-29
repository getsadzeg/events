package ge.mziuri.dao;

import ge.mziuri.util.DatabaseUtil;
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
            pstmt.setDouble(1, money);
            pstmt.setInt(2, card.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public Card getCardwithUserID(int user_id) { //no money needed in Card obj
        Card card;
        try {
            pstmt = con.prepareStatement("SELECT card_id FROM \"USER\" WHERE id = ?");
            pstmt.setInt(1, user_id);
            ResultSet cardIDResult = pstmt.executeQuery();
            if (cardIDResult.next()) {
                int card_id = cardIDResult.getInt("card_id");
                card = new Card();
                card.setId(card_id);
                pstmt = con.prepareStatement("SELECT cardCode, passCode, expirationDate FROM CARD WHERE id = ?");
                pstmt.setInt(1, card_id);
                ResultSet cardResult = pstmt.executeQuery();
                if (cardResult.next()) {
                    card.setCode(cardResult.getString("cardCode"));
                    card.setPasscode(cardResult.getString("passCode"));
                    card.setExpDate(new Date(cardResult.getDate("expirationDate").getTime()));
                    return card;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return null;
    }

}
