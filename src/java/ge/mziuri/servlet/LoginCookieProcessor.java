package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCookieProcessor extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO = new UserDAOImpl();
        try {
            String id = "";
            id = CookieUtil.getCookieContent("userIDCookie", request);
            request.setAttribute("user", userDAO.getUser(Integer.parseInt(id)));
            request.setAttribute("id", id);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        catch(ServletException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
