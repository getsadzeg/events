package ge.mziuri.dao;

import ge.mziuri.enums.RegistrationFailedExceptionType;
import ge.mziuri.exceptions.RegistrationFailedException;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public UserDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public int register(User user) throws RegistrationFailedException {
        int res = 0;
        try {
            pstmt = con.prepareStatement("INSERT INTO \"USER\" (name, surname, username, password)"
                    + " VALUES (?,?,?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            res = pstmt.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("(username)=") && ex.getMessage().contains("already exists")) {
                throw new RegistrationFailedException("მომხმარებელი ამ სახელით უკვე არსებობს",
                        RegistrationFailedExceptionType.USERNAME);
            }
        }
        return res;
    }

    @Override
    public User login(String username, String passwordHash) {
        User user = new User();
        try {
            pstmt = con.prepareStatement("SELECT * FROM \"USER\" WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            ResultSet rs = pstmt.executeQuery();            
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user; //why can't I return nothing here and return user at the end of method?
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public User getUser(int id) {
        try {
            pstmt = con.prepareStatement("SELECT * FROM \"USER\" WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(id);
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    @Override
    public int getIdFromUsername(String username) {
        int id = 0;
        try {
            pstmt = con.prepareStatement("SELECT id FROM \"USER\" WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt("id");
            }
        }
        
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

}
