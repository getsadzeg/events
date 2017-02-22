
package ge.mziuri.model;

import java.util.Date;


public class Card {
    
    private double money;
    private String code;
    private String passcode;
    private Date expDate;

    public Card() {
    }

    public Card(double money, String code, String passcode, Date expDate) {
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
    
    
    
    
}
