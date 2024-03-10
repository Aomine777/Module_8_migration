package org.example.entities;

public class MaxProjectCountClient {
    private int id;
    private String name;
    private int projectCount;

    public MaxProjectCountClient(int id, String name, int projectCount) {
        this.id = id;
        this.name = name;
        this.projectCount = projectCount;
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

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
