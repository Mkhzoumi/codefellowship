package com.example.codefellowship.impl;

import com.example.codefellowship.model.ApplicationUser;
import com.example.codefellowship.model.DbUserData;
import com.example.codefellowship.repository.DbUserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Dependency Injection & IoC
    @Autowired
    DbUserDataRepository dbUserDataRepository;

    // Polymorphism
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DbUserData applicationUser1 = dbUserDataRepository.findByUsername(username);
        ApplicationUser applicationUser = new ApplicationUser(applicationUser1);
        // Error handling ... the user is equal to null (doesn't exist in the database)
        if(applicationUser1 == null){
            throw  new UsernameNotFoundException("The user "+ username + " does not exist");
        }
        return applicationUser;
    }
}