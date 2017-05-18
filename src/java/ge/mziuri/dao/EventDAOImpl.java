package ge.mziuri.dao;

import ge.mziuri.util.DatabaseUtil;
import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import ge.mziuri.model.Event;
import ge.mziuri.model.User;
import ge.mziuri.util.EventUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDAOImpl implements EventDAO {

    private final Connection con;

    private PreparedStatement pstmt;

    private final EventUtil eventUtil = new EventUtil();
    
    

    public EventDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void CreateEvent(Event event) {
        try {

            String availablePlacesString = eventUtil.makeUpString(event.getPlaces());
            pstmt = con.prepareStatement("INSERT INTO EVENT (name, description, date, price, category, type, places, available_places, author_username)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDesc());
            pstmt.setDate(3, new Date(event.getDate().getTime()));
            if (event.getType().toString().equals("PRIVATE")) {
                event.setPrice(0);
            }
            pstmt.setDouble(4, event.getPrice());
            pstmt.setString(5, event.getCategory().toString());
            pstmt.setString(6, event.getType().toString());
            pstmt.setInt(7, event.getPlaces());
            pstmt.setString(8, availablePlacesString);
            pstmt.setString(9, event.getOwner().getUsername());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public void DeleteEvent(int event_id) {
        try {
            pstmt = con.prepareStatement("DELETE FROM EVENT WHERE id = ? ");
            pstmt.setInt(1, event_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public void UpdateEvent(Event event) {
        try {
            pstmt = con.prepareStatement("UPDATE EVENT SET name = ?, description = ?, date = ?,"
                    + "price = ?, category = ?, available_places = ? WHERE id = ? ");
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDesc());
            pstmt.setDate(3, new Date(event.getDate().getTime()));
            pstmt.setDouble(4, event.getPrice());
            pstmt.setString(5, event.getCategory().toString());
            pstmt.setString(6, eventUtil.makeUpString(event.getAvailablePlaces()));
            pstmt.setInt(7, event.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public void updateViews(int event_id) {
        try {
            pstmt = con.prepareStatement("UPDATE EVENT SET views = views+1 WHERE id = ?");
            pstmt.setInt(1, event_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public Event getEvent(int id) {
        Event event = new Event();
        User owner = new User();
        UserDAO userDAO = new UserDAOImpl();
        String availablePlaceString = null;
        ArrayList list = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Category category = Category.valueOf(result.getString("category"));
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                availablePlaceString = result.getString("available_places");
                list = eventUtil.StringToList(availablePlaceString);
                int views = result.getInt("views");
                String owner_username = result.getString("author_username");
                if(new java.util.Date().getTime() > date.getTime()) event.setSellingEndedStatus(true);
                owner.setUsername(owner_username);
                owner.setId(userDAO.getIdFromUsername(owner_username));
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setAvailablePlaces(list);
                event.setViews(views);
                event.setOwner(owner);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return event;
    }

    @Override
    public User getEventOwner(int id) {
        EventDAO eventDAO = new EventDAOImpl();
        Event event = eventDAO.getEvent(id);
        return event.getOwner();
    }

    @Override
    public ArrayList getAllEvents() {
        ArrayList list = new ArrayList<>();
        Event event;
        User owner;
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT ORDER BY views DESC");
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                event = new Event();
                owner = new User();
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Category category = Category.valueOf(result.getString("category"));
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                String owner_username = result.getString("author_username");
                int views = result.getInt("views");
                owner.setUsername(owner_username);
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setViews(views);
                event.setOwner(owner);
                list.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return list;

    }

    @Override
    public ArrayList getAllEvents(Category category) {
        ArrayList list = new ArrayList<>();
        Event event;
        User owner;
        try {
            pstmt = con.prepareStatement("SELECT * FROM EVENT WHERE category = ? ORDER BY views DESC");
            pstmt.setString(1, category.toString());
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                event = new Event();
                owner = new User();
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("Description");
                Date date = new Date(result.getDate("Date").getTime());
                double price = result.getDouble("price");
                Type type = Type.valueOf(result.getString("type"));
                int seatsnum = result.getInt("places");
                String owner_username = result.getString("author_username");
                int views = result.getInt("views");
                owner.setUsername(owner_username);
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setViews(views);
                event.setOwner(owner);
                list.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return list;
    }

    @Override
    public ArrayList getAllEvents(int owner_id) {
        String owner_username = "";
        Event event;
        ArrayList<Event> list = new ArrayList<>();
        User owner;
        try {
            pstmt = con.prepareStatement("SELECT username FROM \"USER\" WHERE id = ?");
            pstmt.setInt(1, owner_id);
            ResultSet userRes = pstmt.executeQuery();
            if (userRes.next()) {
                owner_username = userRes.getString("username");
            }
            pstmt = con.prepareStatement("SELECT * FROM EVENT WHERE author_username = ? ORDER BY views DESC");
            pstmt.setString(1, owner_username);
            ResultSet eventRes = pstmt.executeQuery();
            while (eventRes.next()) {
                event = new Event();
                int id = eventRes.getInt("id");
                String name = eventRes.getString("name");
                String description = eventRes.getString("Description");
                Date date = new Date(eventRes.getDate("Date").getTime());
                double price = eventRes.getDouble("price");
                Type type = Type.valueOf(eventRes.getString("type"));
                int seatsnum = eventRes.getInt("places");
                Category category = Category.valueOf(eventRes.getString("category"));
                int views = eventRes.getInt("views");
                owner = new User();
                owner.setUsername(owner_username);
                event.setId(id);
                event.setName(name);
                event.setDesc(description);
                event.setDate(date);
                event.setPrice(price);
                event.setCategory(category);
                event.setType(type);
                event.setPlaces(seatsnum);
                event.setViews(views);
                event.setOwner(owner);
                list.add(event);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return list;
    }

}
