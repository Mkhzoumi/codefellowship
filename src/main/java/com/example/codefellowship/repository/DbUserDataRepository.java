package com.example.codefellowship.repository;

import com.example.codefellowship.model.ApplicationUser;
import com.example.codefellowship.model.DbUserData;
import org.springframework.data.repository.CrudRepository;

public interface DbUserDataRepository extends CrudRepository<DbUserData,Integer> {
    public DbUserData findByUsername(String username);
}
