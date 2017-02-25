
package ge.mziuri.model;

import java.util.ArrayList;


public class User {
   
   private int id;
   private String name;
   private String surname;
   private String username;
   private String password;
   private Card card;
   private ArrayList<Ticket> boughtTickets;

    public User() {
        
    }

    public User(int id, String name, String surname, String username, String password,
            Card card, ArrayList<Ticket> boughtTickets) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.card = card;
        this.boughtTickets = boughtTickets;
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

    public ArrayList<Ticket> getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtT(ArrayList<Ticket> boughtTickets) {
        this.boughtTickets = boughtTickets;
    }

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    
   
    
    
     
    
    
}
