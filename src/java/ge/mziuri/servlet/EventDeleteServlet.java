package ge.mziuri.servlet;

import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.util.CookieUtil;
import ge.mziuri.util.ServletUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventDeleteServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        ServletUtil.setEncoding(request, response);
        EventDAO eventDAO = new EventDAOImpl();
        int eventID = Integer.parseInt(CookieUtil.getDataFromRequest("eventIDCookie", request));
        eventDAO.DeleteEvent(eventID);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        try {
            rd.forward(request, response);
        }
        catch(ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
