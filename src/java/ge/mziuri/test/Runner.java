
package ge.mziuri.test;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import ge.mziuri.model.Event;
import java.util.Date;


public class Runner {
    public static void main(String[] args) {
        Event event = new Event();
        event.setName("Test");
        event.setDesc("This is a test event");
        event.setDate(new Date());
        event.setPrice(10.95); 
        event.setCategory(Category.CINEMA);
        event.setType(Type.PUBLIC);
        event.setPlaces(60);
        EventDAO eventDAO = new EventDAOImpl();
        eventDAO.CreateEvent(event);
    }
}
