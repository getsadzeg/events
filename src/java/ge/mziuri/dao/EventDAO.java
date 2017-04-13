
package ge.mziuri.dao;

import ge.mziuri.enums.Category;
import ge.mziuri.model.Event;
import ge.mziuri.model.User;
import java.util.ArrayList;


public interface EventDAO {
    
    void CreateEvent(Event event);
    
    void DeleteEvent(Event event);
    
    void UpdateEvent(Event event);
    
    Event getEvent(int id);
    
    User getEventOwner(int id);
    
    ArrayList getAllEvents();
    
    ArrayList getAllEvents(Category category);
}
