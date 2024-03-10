package org.example.entities;

public class LongestProject {
    private int id;
    private String name;
    private int date_diff;

    public LongestProject(int id, String name, int date_diff) {
        this.id = id;
        this.name = name;
        this.date_diff = date_diff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate_diff() {
        return date_diff;
    }

    public void setDate_diff(int date_diff) {
        this.date_diff = date_diff;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_diff=" + date_diff +
                '}';
    }
}
