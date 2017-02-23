
package ge.mziuri.model;


public class User {
   
   private int id;
   private  String name;
   private  String surname;
   private  String username;
   private  String password;
   private  Card card;
   private  Ticket boughtT;

    public User() {
    }

    public User(int id, String name, String surname, String username, String password, Card card, Ticket boughtT) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.card = card;
        this.boughtT = boughtT;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Ticket getBoughtT() {
        return boughtT;
    }

    public void setBoughtT(Ticket boughtT) {
        this.boughtT = boughtT;
    }

    
    
   
    
    
     
    
    
}
