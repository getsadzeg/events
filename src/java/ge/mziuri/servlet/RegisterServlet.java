
package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import ge.mziuri.enums.RegistrationFailedExceptionType;
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
            validatefirstName(firstName);
            validatelastName(lastName);
            validateUsername(username);
            validatePassword(password, repeatedPassword);
            User user = new User();
            user.setName(firstName);
            user.setSurname(lastName);
            user.setUsername(username);
            user.setPassword(password);
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.register(user);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.forward(request, response);
    }

    public void validatefirstName(String firstName) throws RegistrationFailedException {
        if(firstName.length() > 30) throw new RegistrationFailedException
        ("თქვენი სახელი არ უნდა აღემატებოდეს 30 სიმბოლოს", RegistrationFailedExceptionType.FIRSTNAME);
    }

    public void validatelastName(String lastName) throws RegistrationFailedException {
        if(lastName.length() > 30) throw new RegistrationFailedException
        ("თქვენი გვარი არ უნდა აღემატებოდეს 30 სიმბოლოს", RegistrationFailedExceptionType.LASTNAME);
    }

    public void validateUsername(String Username) throws RegistrationFailedException {
        if(Username.length() > 30) throw new RegistrationFailedException
        ("მომხმარებლის სახელი არ უნდა აღემატებოდეს 30 სიმბოლოს", RegistrationFailedExceptionType.USERNAME);
    }

    public void validatePassword(String password, String repeatedPassword) throws RegistrationFailedException {
        if(password.length() > 30 || password.length() < 6) throw new RegistrationFailedException
        ("პაროლი უნდა იყოს 30 სიმბოლოზე ნაკლები და 6 სიმბოლოზე მეტი", RegistrationFailedExceptionType.PASSWORD);
        if(!password.equals(repeatedPassword)) throw new RegistrationFailedException
                ("პაროლი არ ემთხვევა გამეორებულ პაროლს", RegistrationFailedExceptionType.PASSWORD);
    }
}
