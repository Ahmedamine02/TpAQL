package org.example;

import jakarta.persistence.*;

@Entity
public class Mail {
    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    private User user;

    public void setSubject(String subject) {
        this.subject = subject;
    }
// getters/setters
}