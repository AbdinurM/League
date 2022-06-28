package com.abdinurmuse.league.Repository;

import com.abdinurmuse.league.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")//query is used to find email withen the db
    public User findByEmail(String email);//queries
}
