/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import ge.mziuri.model.Event;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.util.locale.provider.LocaleProviderAdapter;


 

public class EventDAOImpl implements EventDAO{

    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    public EventDAOImpl() {
       con = DatabaseUtil.getConnection();
    }
    
    @Override
    public void CreateEvent(Event event) {
       try { 
           pstmt = con.prepareStatement("INSERT INTO EVENT (name, desc, date, price, category, type, places)"
                    + " VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDesc());
            pstmt.setDate(3, (Date) event.getDate());
            pstmt.setDouble(4, event.getPrice());
            pstmt.setString(5, event.getCategory().toString());
            pstmt.setString(6, event.getType().toString());
            pstmt.setInt(7, event.getPlaces());
            pstmt.executeUpdate();
            
       }catch(SQLException ex){
            System.out.println(ex.getMessage());
       }
    }

    @Override
    public void DeleteEvent(Event event) {
       try {
           pstmt = con.prepareStatement("DELETE FROM EVENT WHERE id = ? ");
           pstmt.setInt(1, event.getId());
           pstmt.executeUpdate();
       }
       catch(SQLException ex) {
           System.out.println(ex.getMessage());
       }
    }

    @Override
    public void UpdateEvent(Event event) {
        try {
            pstmt = con.prepareStatement("UPDATE EVENT SET name = ?, desc = ?, date = ?,"
                    + "price = ?, category = ? WHERE id = ? ");
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDesc());
            pstmt.setDate(3, new Date(event.getDate().getTime()));
            pstmt.setDouble(4, event.getPrice());
            pstmt.setString(5, event.getCategory().toString());
            pstmt.setInt(6, event.getId());
            pstmt.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public Event getEvent(int id) {
        Event event = null;
        User author = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            while(result.next()) {
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Category category = Category.valueOf(result.getString("category"));
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                String author_username = result.getString("author_username");
                author.setUsername(author_username);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setAuthor(author);
            }
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return event;
    }

   
    
}
