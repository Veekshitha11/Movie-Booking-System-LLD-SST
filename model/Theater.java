package model;

import java.util.*;

public class Theater {
    private String id;
    private String name;
    private String location;
    private List<Show> shows = new ArrayList<>();

    public Theater(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() { return shows; }
    public String getLocation() { return location; }
}