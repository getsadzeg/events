
package ge.mziuri.dao;

import ge.mziuri.model.Card;


public interface CardDAO {
    void updateMoney(double money, Card card);
    
    void updateCard(Card card);
    
    Card getCardwithUserID(int user_id);
}
