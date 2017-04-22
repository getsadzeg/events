package ge.mziuri.util;

import ge.mziuri.model.Event;
import java.util.ArrayList;
import java.util.Arrays;

public class EventUtil {

    public EventUtil() {

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

    public String makeUpString(ArrayList<Integer> list) {
        StringBuilder availablePlacesBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            availablePlacesBuilder.append(list.get(i));
            if (i != list.size() - 1) {
                availablePlacesBuilder.append(",");
            }
        }

        return availablePlacesBuilder.toString();
    }

    public ArrayList StringToList(String string) {
        return new ArrayList(Arrays.asList(string.split(",")));
    }
}
