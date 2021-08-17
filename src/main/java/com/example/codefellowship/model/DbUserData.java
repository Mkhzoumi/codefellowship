package com.example.codefellowship.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class DbUserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String bio;

    @OneToMany(mappedBy ="applicationUser")
    private List<Post> posts;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "following_followers",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "followers_id"))
    List<DbUserData> following = new ArrayList<>();


    @ManyToMany(mappedBy = "following")
    List<DbUserData> followers = new ArrayList<>();

    public DbUserData(){

    }

    public DbUserData(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;

    }

    public List<DbUserData> getFollowing() {
        return following;
    }

    public void setFollowing(List<DbUserData> following) {
        this.following = following;
    }

    public List<DbUserData> getFollowers() {
        return followers;
    }

    public void setFollowers(List<DbUserData> followers) {
        this.followers = followers;
    }
}
