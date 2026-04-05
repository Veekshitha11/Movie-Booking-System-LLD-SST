package service;

import model.*;
import java.util.*;

public class ShowService {
    private Map<String, Show> shows = new HashMap<>();

    public void addShow(Show show) {
        shows.put(show.getId(), show);
    }

    public Show getShow(String id) {
        return shows.get(id);
    }
}