 
package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import ge.mziuri.exceptions.RegistrationFailedException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("password2");
        try {
            validate(firstName, lastName, username, password, repeatedPassword);
            //construct here
            //userDAO impl new object here
            //userDAO.register(user);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("login.html"); 
        rd.forward(request, response);
    }
    
    public void validate(String firstName, String lastName, String username, 
            String password, String repeatedPassword) throws RegistrationFailedException {
        if(firstName.length() > 30) throw new RegistrationFailedException("თქვენი სახელი არ უნდა აღემატებოდეს 30 სიმბოლოს");
        if(firstName.length() > 30) throw new RegistrationFailedException("თქვენი გვარი არ უნდა აღემატებოდეს 30 სიმბოლოს");
        if(username.length() > 30) throw new RegistrationFailedException("მომხმარებლის სახელი არ უნდა აღემატებოდეს 30 სიმბოლოს");
        if(password.length() > 30 || password.length() < 6) throw new RegistrationFailedException("მომხმარებლის სახელი არ უნდა აღემატებოდეს 30 სიმბოლოს"
                + "და უნდა იყოს 6 სიმბოლოზე მეტი");
    }
    
}
