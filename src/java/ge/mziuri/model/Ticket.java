
package ge.mziuri.model;

public class Ticket {

    private int id;
    private Event event;

    public Ticket() {
        
    }

    public Ticket(int id, Event event) {
        this.id = id;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
