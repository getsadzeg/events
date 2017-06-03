
package ge.mziuri.util;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletUtil {
    
    public ServletUtil() {
        
    }
    
    public static void setEncoding(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
