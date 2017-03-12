
package ge.mziuri.dao;

import ge.mziuri.model.User;

public interface UserDAO {
    
    int register(User user);
    
    User login(String username, String password);
}
