
package ge.mziuri.model;

import java.util.Date;


public class Card {

    private int id;
    private double money;
    private String code;
    private String passcode;
    private Date expDate;

    public Card() {
        
    }

    public Card(int id, double money, String code, String passcode, Date expDate) {
        this.id = id;
        this.money = money;
        this.code = code;
        this.passcode = passcode;
        this.expDate = expDate;
    }

    

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "id: " + id + ", money: " + money + ", code: " + code + ", password: " + passcode + ", expiration date: " + expDate.toString();
    }
    
    
}
