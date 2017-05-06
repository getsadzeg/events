
package ge.mziuri.dao;

import ge.mziuri.enums.Category;
import ge.mziuri.model.Event;
import ge.mziuri.model.User;
import java.util.ArrayList;


public interface EventDAO {
    
    void CreateEvent(Event event);
    
    void DeleteEvent(int event_id);
    
    void UpdateEvent(Event event);
    
    void updateViews(int event_id);
    
    Event getEvent(int id);
    
    User getEventOwner(int id);
    
    ArrayList getAllEvents();
    
    ArrayList getAllEvents(Category category);
    
    ArrayList getAllEvents(int owner_id);
}
