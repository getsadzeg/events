package ge.mziuri.service;

import ge.mziuri.dao.CardDAO;
import ge.mziuri.dao.CardDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.Card;
import ge.mziuri.model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class MyAccountService {

    public MyAccountService() {

    }

    public static void update(HttpServletRequest request, User user) {
        UserDAO userDAO = new UserDAOImpl();
        String name = (String) request.getParameter("firstname");
        String surname = (String) request.getParameter("lastname");
        String password = (String) request.getParameter("password");
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        userDAO.updateUser(user);
    }

    public static void update(HttpServletRequest request, Card card) {
        CardDAO cardDAO = new CardDAOImpl();
        String cardCode = (String) request.getParameter("cardcode");
        String cardPass = (String) request.getParameter("passcode");
        String date_string = (String) request.getParameter("expDate");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
        Date expDate = null;
        try {
            expDate = formatter.parse(date_string);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        card.setCode(cardCode);
        card.setPasscode(cardPass);
        card.setExpDate(expDate);
        cardDAO.updateCard(card);
    }
}
