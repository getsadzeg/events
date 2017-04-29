package ge.mziuri.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    public CookieUtil() {

    }

    public static String getDataFromRequest(String name, HttpServletRequest request) {
        String value = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    public static String getDataFromRequest(String name, HttpServletRequest request, boolean searchInAttribute) {
        String value = "";
        value = getDataFromRequest(name + "Cookie", request);
        if (value.isEmpty() && searchInAttribute) {
            if(request.getAttribute(name) != null)
            value = request.getAttribute(name).toString();
        }
        return value;
    }

    public static Cookie getCookie(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }
}
