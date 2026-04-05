package service;

import model.Theater;
import java.util.*;

public class TheaterService {
    private Map<String, Theater> theaters = new HashMap<>();

    public void addTheater(Theater theater) {
        theaters.put(theater.getLocation(), theater);
    }

    public List<Theater> getByLocation(String location) {
        List<Theater> result = new ArrayList<>();
        for (Theater t : theaters.values()) {
            if (t.getLocation().equals(location)) {
                result.add(t);
            }
        }
        return result;
    }
}