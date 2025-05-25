package org.example;

public class User {
    private long id;
    private String name;

    // Constructor, getters and setters
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {

    }

    public long getId() { return id; }
    public String getName() { return name; }

    public void setName(String alice) {
    }

    public void setEmail(String mail) {
    }
}
