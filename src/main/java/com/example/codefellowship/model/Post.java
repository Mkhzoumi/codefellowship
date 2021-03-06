package com.example.codefellowship.model;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String body;
    private String createdAt;
    @ManyToOne
    private DbUserData applicationUser;




    public Post(){

    }

    public Post(String body, String createdAt, DbUserData applicationUser) {
        this.body = body;
        this.createdAt = createdAt;
        this.applicationUser = applicationUser;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public DbUserData getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(DbUserData applicationUser) {
        this.applicationUser = applicationUser;
    }
}
