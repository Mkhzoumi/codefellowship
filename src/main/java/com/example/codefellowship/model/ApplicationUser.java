package com.example.codefellowship.model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;


public class ApplicationUser implements UserDetails {
    DbUserData dbUserData;




     public ApplicationUser(){
     }

    public ApplicationUser(DbUserData dbUserData) {
        this.dbUserData = dbUserData;
    }

    public int getId() {
        return dbUserData.getId();
    }

    public String getUsername() {
        return dbUserData.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return dbUserData.getPassword();
    }


    public DbUserData getDbUserData() {
        return dbUserData;
    }

    public void setDbUserData(DbUserData dbUserData) {
        this.dbUserData = dbUserData;
    }
}
