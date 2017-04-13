package ge.mziuri.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    public CookieUtil() {

    }

    public static String getCookieContent(String name, HttpServletRequest request) {
        String id = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                id = cookie.getValue();
            }
        }
        return id;
    }
}
