package ge.mziuri.service;

import java.util.ArrayList;
import java.util.Arrays;

public class EventService {

    public EventService() {

    }

    
    public String makeUpString(int seats) {
        StringBuilder availablePlacesBuilder = new StringBuilder();
        for (int i = 1; i <= seats; i++) {
            availablePlacesBuilder.append(i);
            if (i != seats) {
                availablePlacesBuilder.append(",");
            }
        }
        return availablePlacesBuilder.toString();
    }

    public ArrayList StringToList(String string) {
        return new ArrayList(Arrays.asList(string.split(",")));
    }
}
