
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
    private int views;
    private User owner;

    public Event() {
        
    }

    public Event(int id, String name, String desc, Date date, double price,
            Category category, Type type, int places, int views, User owner) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.price = price;
        this.category = category;
        this.type = type;
        this.places = places;
        availablePlaces = new ArrayList<>();
        this.views = views;
        this.owner = owner;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
    
    public int getViews() {
        return views;
    }

    
    public void setViews(int views) {
        this.views = views;
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + desc + " " + date.toString() + " " + price + " " + category + 
                " " + type + " " + places + " " + owner.getUsername();
    }

    
}
