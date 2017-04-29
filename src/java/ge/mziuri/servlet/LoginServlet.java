package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(403);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.login(username, String.valueOf(password.hashCode()));
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            if (user == null) {
                printWriter.append("არასწორი სახელი ან პაროლი");
            } else {
                Cookie cookie = new Cookie("userIDCookie", String.valueOf(user.getId()));
                response.addCookie(cookie);
                request.setAttribute("userID", user.getId());
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        } catch (IOException | ServletException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
