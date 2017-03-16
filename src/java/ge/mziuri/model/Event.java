
package ge.mziuri.model;

import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import java.util.ArrayList;
import java.util.Date;


public class Event {
    
    private int id;
    private String name;
    private String desc;
    private Date date;
    private double price;
    private Category category;
    private Type type;
    private int places;
    private ArrayList availablePlaces;
    private User author;

    public Event() {
        
    }

    public Event(int id, String name, String desc, Date date, double price,
            Category category, Type type, int places, User author) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.price = price;
        this.category = category;
        this.type = type;
        this.places = places;
        availablePlaces = new ArrayList<>();
        this.author = author;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public ArrayList<Integer> getAvailablePlaces() {
        return availablePlaces;
    }

    
    public void setAvailablePlaces(ArrayList<Integer> availablePlaces) {
        this.availablePlaces = availablePlaces;
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + desc + " " + date.toString() + " " + price + " " + category + 
                " " + type + " " + places + " " + author.getUsername();
    }
    
}
