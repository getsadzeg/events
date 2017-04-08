
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
import java.util.ArrayList;
import java.util.Arrays;

public class EventDAOImpl implements EventDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public EventDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void CreateEvent(Event event) {
        try {
            StringBuilder availablePlacesBuilder = new StringBuilder();
            for (int i = 1; i <= event.getPlaces(); i++) {
                availablePlacesBuilder.append(i);
                if (i != event.getPlaces()) {
                    availablePlacesBuilder.append(",");
                }
            }
            String availablePlacesString = availablePlacesBuilder.toString();
            pstmt = con.prepareStatement("INSERT INTO EVENT (name, description, date, price, category, type, places, available_places)"
                    + " VALUES (?,?,?,?,?,?,?,?)"); //wanna add author_username after adding cookies
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDesc());
            pstmt.setDate(3, new Date(event.getDate().getTime()));
            pstmt.setDouble(4, event.getPrice());
            pstmt.setString(5, event.getCategory().toString());
            pstmt.setString(6, event.getType().toString());
            pstmt.setInt(7, event.getPlaces());
            pstmt.setString(8, availablePlacesString);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void DeleteEvent(Event event) {
        try {
            pstmt = con.prepareStatement("DELETE FROM EVENT WHERE id = ? ");
            pstmt.setInt(1, event.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void UpdateEvent(Event event) {
        try {
            pstmt = con.prepareStatement("UPDATE EVENT SET name = ?, description = ?, date = ?,"
                    + "price = ?, category = ? WHERE id = ? ");
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDesc());
            pstmt.setDate(3, new Date(event.getDate().getTime()));
            pstmt.setDouble(4, event.getPrice());
            pstmt.setString(5, event.getCategory().toString());
            pstmt.setInt(6, event.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Event getEvent(int id) {
        Event event = new Event();
        User author = new User();
        String availablePlaceString = null;
        ArrayList list = new ArrayList<>();

        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Category category = Category.valueOf(result.getString("category"));
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                availablePlaceString = result.getString("available_places");
                list = new ArrayList(Arrays.asList(availablePlaceString.split(",")));             
                String author_username = result.getString("author_username");
                author.setUsername(author_username);
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setAvailablePlaces(list);
                event.setAuthor(author);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return event;
    }

   /* @Override
    public ArrayList getAvailablePlaces(int id) {
        String availablePlaceString = null;
        ArrayList list = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT available_places FROM EVENT WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            availablePlaceString = result.getString("available_places");
            list = new ArrayList(Arrays.asList(availablePlaceString.split(",")));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    } */

    @Override
    public ArrayList getAllEvents() {
        ArrayList list = new ArrayList<>();
        Event event;
        User author;
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT");
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                event = new Event();
                author = new User();
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Category category = Category.valueOf(result.getString("category"));
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                String author_username = result.getString("author_username");
                author.setUsername(author_username);
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setAuthor(author);
                list.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public ArrayList getAllEvents(Category category) {
        ArrayList list = new ArrayList<>();
        Event event;
        User author;
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT WHERE category = ?");
            pstmt.setString(1, category.toString());
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                event = new Event();
                author = new User();
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                String author_username = result.getString("author_username");
                author.setUsername(author_username);
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setAuthor(author);
                list.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

}
