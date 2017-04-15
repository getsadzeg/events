
package ge.mziuri.dao;

import ge.mziuri.exceptions.RegistrationFailedException;
import ge.mziuri.model.User;

public interface UserDAO {
    
    int register(User user) throws RegistrationFailedException;
    
    User login(String username, String password);
    
    User getUser(int id);
    
    int getIdFromUsername(String username);
}
