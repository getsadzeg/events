
package ge.mziuri.dao;

import ge.mziuri.model.Event;


public interface EventDAO {
    
    void CreateEvent(Event event);
    
    void DeleteEvent(Event event);
    
    void UpdateEvent(Event event);
}
