
package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.enums.Category;
import ge.mziuri.enums.Type;
import ge.mziuri.model.Event;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EventCreateServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String name = (String)request.getAttribute("name");
        String description = (String)request.getAttribute("desc");
        String date_string = (String)request.getAttribute("date");
        String price = (String)request.getAttribute("price");
        Category category = (Category.valueOf((String)request.getAttribute("categ")));
        Type type = (Type.valueOf((String)request.getAttribute("type")));
        String places = (String)request.getAttribute("places");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
             date = formatter.parse(date_string);
        }
        catch(ParseException ex) {
            System.out.println(ex.getMessage());
        }
        Event event = new Event();
        event.setName(name);
        event.setDesc(description);
        event.setDate(date);
        event.setPrice(Double.parseDouble(price)); 
        event.setCategory(category);
        event.setType(type);
        event.setPlaces(Integer.parseInt(places));
        EventDAO eventDAO = new EventDAOImpl();
        eventDAO.CreateEvent(event);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
        
    }
}
